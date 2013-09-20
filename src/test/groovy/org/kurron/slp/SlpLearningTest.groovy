package org.kurron.slp

import groovy.util.logging.Slf4j
import org.livetribe.slp.SLP
import org.livetribe.slp.Scopes
import org.livetribe.slp.ServiceInfo
import org.livetribe.slp.ServiceType
import org.livetribe.slp.ua.UserAgentClient
import org.slf4j.bridge.SLF4JBridgeHandler
import spock.lang.Specification

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.core.Is.is
import static org.hamcrest.core.Is.is
import static org.hamcrest.core.IsEqual.equalTo
import static org.hamcrest.core.IsNull.notNullValue

/**
 * A learning test to understand the SLP library.
 */
@Slf4j
class SlpLearningTest extends Specification {
    def 'see if we can see the SLP server'() {

        given: 'a logger'
        assert log != null
        SLF4JBridgeHandler.removeHandlersForRootLogger()
        SLF4JBridgeHandler.install()

        and: 'valid subject under test'
        UserAgentClient sut = SLP.newUserAgentClient( null )

        when: 'find is called'
        ServiceType serviceType = new ServiceType('service:amqpbroker')
        String language = null // Any language
        Scopes scopes = Scopes.DEFAULT
        String filter = null
        List<ServiceInfo> services = sut.findServices( serviceType, language, scopes, filter )

        then: 'a service is found'
        assertThat( services, is( notNullValue() ) )
        assertThat( services.size(), is( equalTo( 1 ) ) )
        log.debug( 'Hi' )
    }
}
