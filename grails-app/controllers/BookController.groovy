import grails.rest.RestfulController

class BookController extends RestfulController<Book> {
    static getResponseFormats() {
        ['json']
    }

    BookController() {
        super(Book)
    }
}
