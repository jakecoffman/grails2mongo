class BootStrap {

    def init = { servletContext ->
        if (Book.count() == 0) {
            new Book(title: '1984').save()
        }
    }
    def destroy = {
    }
}
