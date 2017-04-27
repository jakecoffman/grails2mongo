import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(BookController)
@Mock([Book])
class BookControllerSpec extends Specification {
    def "test something"() {
        setup:
        def book = new Book(title: 'test')
        book.save(flush: true)

        when:
        controller.index()

        then:
        response.json == []
    }
}
