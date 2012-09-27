package ch.hedgesphere

import org.apache.shiro.SecurityUtils
import org.apache.shiro.subject.Subject
import org.apache.shiro.web.util.SavedRequest
import org.apache.shiro.web.util.WebUtils

class SecurityService {

    def shiroSecurityManager

    Subject getSubject() {
       SecurityUtils.subject
    }

    SavedRequest getSavedRequest(request) {
        WebUtils.getSavedRequest(request)
    }

    def login(Subject subject, authToken) {
        shiroSecurityManager.login(subject, authToken)
    }
}
