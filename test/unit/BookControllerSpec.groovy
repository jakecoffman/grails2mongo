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
        response.status == 200
        response.contentAsString == '[{"class":"Book","id":"1","title":"test"}]'
    }

    def "test save"() {
        when:
        params.title = 'hi'
        controller.save()

        then:
        response.status == 201
        Book.count() == 1
        Book.first().title == 'hi'
    }
}
