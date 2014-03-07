grails {
    mongo {
        host = System.getenv("MONGO_PORT_27017_TCP_ADDR")
        port = 27017
        databaseName = "brownbag"
    }
}
