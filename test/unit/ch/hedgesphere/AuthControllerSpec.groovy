package ch.hedgesphere

import grails.test.mixin.*

import org.apache.shiro.authc.AuthenticationException
import org.apache.shiro.subject.Subject

import spock.lang.Specification

@TestFor(AuthController)
@Mock([User, Role])
class AuthControllerSpec extends Specification {

    def 'unknown user fails to sign in'() {
        def securityService = mockFor(SecurityService)
        Subject subject = mockFor(Subject).createMock()

        securityService.demand.getSavedRequest { param -> null }
        securityService.demand.getSubject { -> subject }
        securityService.demand.login { subject2, authToken -> throw new AuthenticationException() }

        controller.securityService = securityService.createMock()

        given:
        String username = 'bob'
        String password = 'password'

        when:
        def result = controller.signIn()

        then:
        assert response.status == 401
    }
}
