package pl.helenium.brownbag
import grails.transaction.Transactional

class IdeaController {

    def index() {
        render view: 'index'
    }

    def list() {
        respond Idea.listOrderByVotes(order: 'desc')
    }

    @Transactional
    def vote() {
        Idea.get(params.id).votes++
        render "OK"
    }

}
