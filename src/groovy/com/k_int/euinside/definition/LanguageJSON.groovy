package com.k_int.euinside.definition

import java.util.Locale;
import java.util.Map;

class LanguageJSON extends CodeDefinitionItemsJSON {
	
	static private final String JSON_PROFILE_LANGUAGE_CODE       = JSON_FIELD_MAPPING_CODE;
	static private final String JSON_PROFILE_LANGUAGE_DEFINITION = "language";
	
	static Map<String, String> fieldMappingsJSON = new HashMap<String, String>();
	
	static {
		// Setup the field mappings, as they are defined in static strings we can't use [ : ] notation
		fieldMappingsJSON.putAt(JSON_FIELD_MAPPING_CODE,       JSON_PROFILE_LANGUAGE_CODE);
		fieldMappingsJSON.putAt(JSON_FIELD_MAPPING_DEFINITION, JSON_PROFILE_LANGUAGE_DEFINITION);
	}
	
	protected Map<String, String> getFieldNameMapping() {
		return(fieldMappingsJSON);
	}
	
	LanguageJSON(String languageCode) {
		super(languageCode, (new Locale(languageCode)).getDisplayLanguage());
	}
}
