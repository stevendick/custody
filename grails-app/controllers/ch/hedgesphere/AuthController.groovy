package ch.hedgesphere

import org.apache.shiro.subject.Subject
import org.apache.shiro.authc.AuthenticationException
import org.apache.shiro.authc.UsernamePasswordToken
import org.apache.shiro.grails.ConfigUtils
import org.apache.shiro.mgt.SecurityManager
import org.apache.shiro.subject.Subject

class AuthController {
    SecurityManager shiroSecurityManager
    def securityService

    def index = { redirect(action: "login", params: params) }

    def login = {
        return [ username: params.username, rememberMe: (params.rememberMe != null), targetUri: params.targetUri ]
    }

    def signIn() {
        def authToken = new UsernamePasswordToken(params.username, params.password as String)

        // Support for "remember me"
        if (params.rememberMe) {
            authToken.rememberMe = true
        }

        // If a controller redirected to this page, redirect back
        // to it. Otherwise redirect to the root URI.
        def targetUri = params.targetUri ?: "/"

        // Handle requests saved by Shiro filters.
        def savedRequest = securityService.getSavedRequest(request)
        if (savedRequest) {
            targetUri = savedRequest.requestURI - request.contextPath
            if (savedRequest.queryString) targetUri = targetUri + '?' + savedRequest.queryString
        }

        try{
            // Perform the actual login. An AuthenticationException
            // will be thrown if the username is unrecognised or the
            // password is incorrect.
            Subject subject = securityService.getSubject()
            securityService.login(subject, authToken)

            // update the session with the user's client ID
            subject.getSession().setAttribute('client', params.client)

            withFormat {
                html {
                    log.info "Redirecting to '${targetUri}'."
                    redirect(uri: targetUri)
                }
                json {
                    log.info 'JSON login successfull'
                    response.sendError(200, 'Done')
                }
            }
        }
        catch (AuthenticationException ex){
            // Authentication failed, so display the appropriate message
            // on the login page.
            log.info "Authentication failure for user '${params.username}'."
            flash.message = message(code: "login.failed")

            // Keep the username and "remember me" setting so that the
            // user doesn't have to enter them again.
            def m = [ username: params.username ]
            if (params.rememberMe) {
                m["rememberMe"] = true
            }

            // Remember the target URI too.
            if (params.targetUri) {
                m["targetUri"] = params.targetUri
            }

            // Now redirect back to the login page.
            withFormat {
                html {
                    redirect(action: "login", params: m)
                }
                json {
                    response.sendError(401)
                }
            }
        }
    }

    def signOut = {
        // Log the user out of the application.
        def principal = securityService.subject?.principal
        securityService.subject?.logout()
        // For now, redirect back to the home page.
        if (ConfigUtils.getCasEnable() && ConfigUtils.isFromCas(principal)) {
            redirect(uri:ConfigUtils.getLogoutUrl())
        }else {
            redirect(uri: "/")
        }
        ConfigUtils.removePrincipal(principal)
    }

    def unauthorized = {
        render "You do not have permission to access this page."
    }
}
