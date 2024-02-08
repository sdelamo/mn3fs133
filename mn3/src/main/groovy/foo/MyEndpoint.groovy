package foo

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.micronaut.management.endpoint.annotation.Endpoint
import io.micronaut.management.endpoint.annotation.Write
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import jakarta.inject.Inject
import org.hibernate.SessionFactory
import org.hibernate.stat.Statistics

@Slf4j
@CompileStatic
@Endpoint('h8stats')
class MyEndpoint {

    @Inject
    SessionFactory session

    @Write
    @Secured(SecurityRule.IS_ANONYMOUS)
    Map<String, Object> reset() {
        final stats = session.getStatistics()
        stats.clear()
        log.info "Hibernate reset stats"
        Collections.singletonMap("enabled", stats.isStatisticsEnabled()) as Map<String, Object>
    }
}
