package ch.hedgesphere

import grails.plugin.multitenant.core.exception.TenantResolveException
import grails.plugin.multitenant.core.resolve.TenantResolver

import javax.servlet.http.HttpServletRequest

import org.apache.shiro.SecurityUtils
import org.apache.shiro.subject.Subject

/**
 * @see http://multi-tenant.github.com/grails-multi-tenant-single-db/
 */
class DomainTenantResolver implements TenantResolver {

    Integer resolve(HttpServletRequest request) throws TenantResolveException {

        Subject subject = SecurityUtils.getSubject()

        if(subject.isAuthenticated() == false) {
            return null
        }

        Integer client = subject.getSession().getAttribute('client')

        if(client == null) {
            throw new IllegalStateException("No client for user ${subject.principal}")
        }



    }

}