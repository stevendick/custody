package ch.hedgesphere

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(DashboardController)
class DashboardControllerTests {

	void testSomething() {
		controller.index()
		assert 'Welcome to HFoF TOM' == response.text
	}
}
