package com.k_int.euinside.definition

import grails.converters.JSON

class DefinitionController {

	def MessagePropertyUtilitiesService;
	
    private def show(languageCode, items, filter, item, parameter) {
		
		// Determine the language we are interested in
		Language language = MessagePropertyUtilitiesService.getLanguage(languageCode);
		if (language == null) {
			// We use the default language, if we can't find the language they specify
			language = Language.getDefaultLanguage();
		}

		def json;
		if (item == null) {
			// They are interested in all the items or we have been passed a filter
			json = [ ];
			items.each() {key, value ->
				// If we have a filter, then is this the item we are interested in
				if ((filter == null) || (filter == key)) {
					json.add(value.getJSONObject(language));
				}
			}
		} else {
			// Just dealing with a single item, with a potential parameter
			if (parameter == null) {
				json = item.getJSONObject(language);
			} else {
				json = item.getJSONObject(language, parameter);
			}
		}
		
		render json as JSON;
	}
	
    def showError() {
		String languageCode = params.languageCode;
		String errorCode = params.errorCode;
		Error error = MessagePropertyUtilitiesService.getError(errorCode);
		Map<String, Error> errors = MessagePropertyUtilitiesService.getErrors();
		
		show(languageCode, errors, null, error, null);
	}

    def showLanguage() {
		// Get hold of the languages we know about
		Map<String, Language> languages = MessagePropertyUtilitiesService.getLanguages();
		show(null, languages, null, null, null);
	}
	
    def showProfile() {
		String languageCode = params.languageCode;
		String profileIdentifier = params.profileIdentifier;
		String field = params.field;
		Map<String, Profile> profiles = MessagePropertyUtilitiesService.getProfiles();
		Profile profile = null;

		// We only filter on the field if the profile identifier is valid and the field has been specified		
		if ((profileIdentifier != null) && (field != null)) {
			profile = MessagePropertyUtilitiesService.getProfile(profileIdentifier);
		} 
		show(languageCode, profiles, profileIdentifier, profile, field);
	}
}
