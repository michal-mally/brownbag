class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: 'poll', action: 'index')
        "/$id(.$format)?"(controller: 'poll', action: 'show')
        "500"(view:'/error')
	}

}
