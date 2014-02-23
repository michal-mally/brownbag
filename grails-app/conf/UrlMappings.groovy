class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(redirect: [controller: 'idea', action: 'index'])
        "500"(view:'/error')
	}
}
