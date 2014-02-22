package pl.helenium.brownbag

class IdeaController {

    static scaffold = true

//    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
//
//    def index(Integer max) {
//        params.max = Math.min(max ?: 10, 100)
//        respond Idea.list(params), model:[ideaInstanceCount: Idea.count()]
//    }
//
//    def show(Idea ideaInstance) {
//        respond ideaInstance
//    }
//
//    def create() {
//        respond new Idea(params)
//    }
//
//    @Transactional
//    def save(Idea ideaInstance) {
//        if (ideaInstance == null) {
//            notFound()
//            return
//        }
//
//        if (ideaInstance.hasErrors()) {
//            respond ideaInstance.errors, view:'create'
//            return
//        }
//
//        ideaInstance.save flush:true
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.created.message', args: [message(code: 'ideaInstance.label', default: 'Idea'), ideaInstance.id])
//                redirect ideaInstance
//            }
//            '*' { respond ideaInstance, [status: CREATED] }
//        }
//    }
//
//    def edit(Idea ideaInstance) {
//        respond ideaInstance
//    }
//
//    @Transactional
//    def update(Idea ideaInstance) {
//        if (ideaInstance == null) {
//            notFound()
//            return
//        }
//
//        if (ideaInstance.hasErrors()) {
//            respond ideaInstance.errors, view:'edit'
//            return
//        }
//
//        ideaInstance.save flush:true
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.updated.message', args: [message(code: 'Idea.label', default: 'Idea'), ideaInstance.id])
//                redirect ideaInstance
//            }
//            '*'{ respond ideaInstance, [status: OK] }
//        }
//    }
//
//    @Transactional
//    def delete(Idea ideaInstance) {
//
//        if (ideaInstance == null) {
//            notFound()
//            return
//        }
//
//        ideaInstance.delete flush:true
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Idea.label', default: 'Idea'), ideaInstance.id])
//                redirect action:"index", method:"GET"
//            }
//            '*'{ render status: NO_CONTENT }
//        }
//    }
//
//    protected void notFound() {
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ideaInstance.label', default: 'Idea'), params.id])
//                redirect action: "index", method: "GET"
//            }
//            '*'{ render status: NOT_FOUND }
//        }
//    }

}
