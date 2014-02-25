package pl.helenium.brownbag

class IdeaController {

    def ideaService

    def index() {
        linkUserByCookie()
        render view: 'index'
    }

    def list() {
        respond ideaService.getAll()
    }

    def save() {
        def idea = new Idea(request.JSON)
        idea.creatorId = getUserId()
        ideaService.create(idea)
        render "OK"
    }

    def vote() {
        ideaService.vote(params.id, getUserId())
        render "OK"
    }

    private void linkUserByCookie() {
        if(!getUserId()) {
            response.setCookie('userId', UUID.randomUUID().toString())
        }
    }

    private String getUserId() {
        request.getCookie('userId')
    }

}
