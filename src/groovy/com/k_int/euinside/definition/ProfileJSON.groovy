package com.k_int.euinside.definition

class ProfileJSON extends CodeDefinitionItemsJSON {

	static private final String JSON_PROFILE_CODE       = "profile";
	static private final String JSON_PROFILE_DEFINITION = JSON_FIELD_MAPPING_DEFINITION;
	static private final String JSON_PROFILE_ITEMS      = "fields";
	
	static Map<String, String> fieldMappingsJSON = new HashMap<String, String>();
	
	static {
		// Setup the field mappings, as they are defined in static strings we can't use [ : ] notation
		fieldMappingsJSON.putAt(JSON_FIELD_MAPPING_CODE,       JSON_PROFILE_CODE);
		fieldMappingsJSON.putAt(JSON_FIELD_MAPPING_DEFINITION, JSON_PROFILE_DEFINITION);
		fieldMappingsJSON.putAt(JSON_FIELD_MAPPING_ITEMS,      JSON_PROFILE_ITEMS); 	
	}
	
	protected Map<String, String> getFieldNameMapping() {
		return(fieldMappingsJSON);
	}
	
	ProfileJSON(Language language, String code, String messagePrefix, listClosure) {
		super(language, code, messagePrefix, listClosure);
	}
}
