package foo

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.micronaut.management.endpoint.annotation.Endpoint
import io.micronaut.management.endpoint.annotation.Write
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import org.hibernate.stat.Statistics

@Slf4j
@CompileStatic
@Endpoint('h8stats')
class MyEndpoint {

    private HibernateService hibernateService
    MyEndpoint(HibernateService hibernateService) {
        this.hibernateService = hibernateService
    }

    @Write
    //@Post
    @Secured(SecurityRule.IS_ANONYMOUS)
    Map<String, Object> reset() {
        Statistics stats = hibernateService.resetStats()
        Collections.singletonMap("enabled", stats.isStatisticsEnabled()) as Map<String, Object>
    }
}
