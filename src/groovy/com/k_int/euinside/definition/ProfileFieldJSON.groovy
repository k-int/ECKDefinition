package com.k_int.euinside.definition

import grails.converters.JSON

class ProfileFieldJSON extends CodeDefinitionItemsJSON {

	private static String MESSAGE_PREFIX_FIELD_DEFINITION          = "profile.field.definition";
	private static String MESSAGE_PREFIX_FIELD_XPATH_DEFINITION    = "profile.field.xpath.definition";
	private static String MESSAGE_PREFIX_FIELD_EXAMPLE_DEFINITION  = "profile.field.example.definition";
	
	static private final String JSON_PROFILE_FIELD_CODE        = "field";
	static private final String JSON_PROFILE_FIELD_DEFINITION  = JSON_FIELD_MAPPING_DEFINITION;
	static private final String JSON_PROFILE_FIELD_EXAMPLE     = "example";
	static private final String JSON_PROFILE_FIELD_XPATH       = "xpath";
	
	static Map<String, String> fieldMappingsJSON = new HashMap<String, String>();
	
	static {
		// Setup the field mappings, as they are defined in static strings we can't use [ : ] notation
		fieldMappingsJSON.putAt(JSON_FIELD_MAPPING_CODE,       JSON_PROFILE_FIELD_CODE);
		fieldMappingsJSON.putAt(JSON_FIELD_MAPPING_DEFINITION, JSON_PROFILE_FIELD_DEFINITION);
	}

	static {
		// We do not want the class field being output in the JSON
		// This also allows us to map what the field names are called, since we are a generic base class
		JSON.registerObjectMarshaller(ProfileFieldJSON) {
			return(it.generateJSONFields());
		}
	}


	private String example;
	private String xpath;
		
	protected Map<String, String> getFieldNameMapping() {
		return(fieldMappingsJSON);
	}
	
	ProfileFieldJSON(Language language, String code, String profileIdentifier) {
		super(language, code, MESSAGE_PREFIX_FIELD_DEFINITION +  MessagePropertyUtilitiesService.KEY_SEPARATOR + profileIdentifier, null);
		example = language.getDescription(MESSAGE_PREFIX_FIELD_EXAMPLE_DEFINITION +  MessagePropertyUtilitiesService.KEY_SEPARATOR + profileIdentifier, code);
		xpath = language.getDescription(MESSAGE_PREFIX_FIELD_XPATH_DEFINITION +  MessagePropertyUtilitiesService.KEY_SEPARATOR + profileIdentifier, code);
	}
	
	Map generateJSONFields() {
		def fieldsJSON = [ : ]
		addFieldIfNotNull(fieldsJSON, JSON_PROFILE_FIELD_EXAMPLE, example);
		addFieldIfNotNull(fieldsJSON, JSON_PROFILE_FIELD_XPATH, xpath);
		
		return(fieldsJSON.plus(super.generateJSONFields()));
	}
}
