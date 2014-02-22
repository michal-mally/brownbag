package pl.helenium.brownbag

class IdeaController {

    def index() {
        [ideaList: Idea.listOrderById()]
    }

    def create() {
        [idea: new Idea()]
    }

    def save(Idea idea) {
        if (idea.hasErrors()) {
            render view: 'create', model: [idea: idea]
            return
        }

        idea.save()
        redirect action: 'index'
    }

}
