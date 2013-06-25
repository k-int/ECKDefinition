package com.k_int.euinside.definition

import com.k_int.euinside.definition.MessagePropertyUtilitiesService;

class Profile {

	private static String MESSAGE_PREFIX_PROFILE_DEFINITION = "profile.definition";
	private String identifier;
	private List<String> fields;
	
	Profile(String identifier) {
		this.identifier = identifier;
		fields = new ArrayList<String>();
	}
	
	void addField(String field) {
		fields.add(field);
	}

	ProfileJSON getJSONObject(Language language) {
		def processFields = {fieldsJSON ->
			fields.each() {field ->
				fieldsJSON.add(getJSONObject(language, field));
			}
		}

		return(new ProfileJSON(language, identifier, MESSAGE_PREFIX_PROFILE_DEFINITION, processFields));
	}
	
	ProfileFieldJSON getJSONObject(language, field) {		
		return(new ProfileFieldJSON(language, field, identifier));
	}
}
