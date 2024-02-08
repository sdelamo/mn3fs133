package foo

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Slf4j
@CompileStatic
@Entity
@Table(name = "pet")
class Pet {
    @Id
    long id

    String name
}
