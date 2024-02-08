package foo

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Slf4j
@CompileStatic
@Entity
@Table(name = "pet")
class Pet {
    @Id
    long id

    String name
}
