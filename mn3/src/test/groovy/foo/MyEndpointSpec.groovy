package foo

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest(application = Application, transactional = false)
class MyEndpointSpec extends Specification {

    @Inject
    @Client('/')
    HttpClient client

    void "reset the H8 stats"() {

        when: 'contact the endpoint to reset the stats'
        def req = HttpRequest.POST("/h8stats", [:])
        HttpResponse<Map<String, Object>> res = client.toBlocking().exchange(req, Map<String, Object>)

        then: 'the stats have been obtained'
        Map<String, Object> body = res.body()
        body != null
    }
}
