package foo

import groovy.util.logging.Slf4j
import jakarta.inject.Inject
import jakarta.inject.Singleton
import org.hibernate.SessionFactory
import org.hibernate.stat.Statistics

@Slf4j
@Singleton
class HibernateService {

    @Inject
    SessionFactory session

    Statistics resetStats() {
        final Statistics stats = session.getStatistics()
        stats.clear()
        log.info "Hibernate reset stats"
        stats
    }
}
