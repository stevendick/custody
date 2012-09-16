class UrlMappings {

	static mappings = {
		//"/$controller/$action?/$id?" {

		"/trades"(controller: "trade") {
			action = [GET: "list", POST: "save"]
		}
		
		"/trades/$id"(controller: "trade", parseRequest: true) {
			action = [GET: "show", PUT: "update", DELETE: "delete", POST: "update"]
		}

		"/$controller/$action?/$id?"(parseRequest: true) { constraints { // apply constraints here
			} }

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
