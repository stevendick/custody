package ch.hedgesphere

/**
 * Generated by the Shiro plugin. This filters class protects all URLs
 * via access control by convention.
 */
class SecurityFilters {

    def isJsonRequest(request) {
        request.getHeader('Accept').startsWith('application/json')
    }

    def filters = {
        all(uri: "/**") {
            before = {
                // Access control by convention - all resources are protected, even static ones
                accessControl()

            }
            after = {
                // enforce secure transport when we are using HTTPS
                if(request.getScheme().equals("https")) {
                    response.setHeader('Strict-Transport-Security', 'max-age=8640000; includeSubDomains')
                }
            }
        }
    }

    def onNotAuthenticated(subject, filter) {
        // doing the standard 302 re-direct for non-authenticated users is undetectable when doing a XHR call; 401 is better
        println filter.request.getRequestURI()
        if(isJsonRequest(filter.request)) {
            filter.response.status = 401
            return
        }
        true
    }
}
