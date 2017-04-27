import grails.test.spock.IntegrationSpec
import org.bson.Document

class BookIntegrationSpec extends IntegrationSpec {
    static db = 'BookIntegrationSpec'
    def mongo

    def setup() {
        mongo.getDB(db)
        mongo.dropDatabase(db)
        Book.useDatabase(db)
    }

    def "test something"() {
        when:
        def book = new Book(title: 'integration')
        book.save(flush: true)

        then:
        Book.collection.find([:], [title:1, _id: 0]).toList() == [new Document([title: 'integration'])]
    }
}
