package pl.helenium.brownbag

class IdeaController {

    def index() {
        render view: 'index'
    }

//    def create() {
//        [idea: new Idea()]
//    }

    def list() {
        respond Idea.listOrderByVotes(order: 'desc')
    }

//    def save(Idea idea) {
//        if (idea.hasErrors()) {
//            render view: 'create', model: [idea: idea]
//            return
//        }
//
//        idea.save()
//        redirect action: 'index'
//    }

}
