package com.k_int.euinside.definition

class ErrorJSON extends CodeDefinitionItemsJSON {

	static private final String JSON_ERROR_CODE       = "error";
	static private final String JSON_ERROR_DEFINITION = JSON_FIELD_MAPPING_DEFINITION;
	
	static Map<String, String> fieldMappingsJSON = new HashMap<String, String>();
	
	static {
		// Setup the field mappings, as they are defined in static strings we can't use [ : ] notation
		fieldMappingsJSON.putAt(JSON_FIELD_MAPPING_CODE,       JSON_ERROR_CODE);
		fieldMappingsJSON.putAt(JSON_FIELD_MAPPING_DEFINITION, JSON_ERROR_DEFINITION);
	}
	
	protected Map<String, String> getFieldNameMapping() {
		return(fieldMappingsJSON);
	}
	
	ErrorJSON(Language language, String code, String messagePrefix) {
		super(language, code, messagePrefix, null);
	}
}
