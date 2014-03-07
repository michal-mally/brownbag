package pl.helenium.brownbag

class TemplateController {

    def show() {
        render view: params.id
    }

}
