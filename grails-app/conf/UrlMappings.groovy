class UrlMappings {

	static mappings = {
		"/errors/$languageCode?/$errorCode?" {
			controller = "definition"
			action = "showError"
		}
		"/help/$action" {
			controller = "help"
		}
		"/languages" {
			controller = "definition"
			action = "showLanguage"
		}
		"/profiles/$languageCode?/$profileIdentifier?/$field?" {
			controller = "definition"
			action = "showProfile"
		}
		"/test/$action" {
			controller = "test"
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
