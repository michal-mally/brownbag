grails {
    mongo {
        host = System.getenv("MONGO_HOST")
        port = 27017
        databaseName = "brownbag"
    }
}
