package com.k_int.euinside.definition

import grails.converters.JSON

abstract class CodeDefinitionItemsJSON {
	protected static final String JSON_FIELD_MAPPING_CODE       = "code";
	protected static final String JSON_FIELD_MAPPING_DEFINITION = "definition";
	protected static final String JSON_FIELD_MAPPING_ITEMS      = "items";
	
	static {
		// We do not want the class field being output in the JSON
		// This also allows us to map what the field names are called, since we are a generic base class
		JSON.registerObjectMarshaller(CodeDefinitionItemsJSON) {
			return(it.generateJSONFields());
		}
	}

	protected abstract Map<String, String> getFieldNameMapping();
		
	private String code;
	private String definition;
	private def items = null;

	CodeDefinitionItemsJSON(String code, String definition) {
		this.code = code;
		this.definition = definition;
	}
	
	CodeDefinitionItemsJSON(Language language, String code, String messagePrefix, listClosure) {
		this.code = code;
		definition = language.getDescription(messagePrefix, code);
		if (listClosure != null) {
			items = [ ];
			listClosure(items);
		}
	}
	
	protected Map generateJSONFields() {
		def fieldsJSON = [ : ]
		addFieldIfNotNull(fieldsJSON, (getFieldNameMapping())[JSON_FIELD_MAPPING_CODE], code);
		addFieldIfNotNull(fieldsJSON, (getFieldNameMapping())[JSON_FIELD_MAPPING_DEFINITION], definition);
		if (items != null) {
			fieldsJSON[(getFieldNameMapping())[JSON_FIELD_MAPPING_ITEMS]] = items
		}
		return(fieldsJSON)

		// If you just want to exclude class and metaClass then just use the following
		// return(it.properties.findAll{key, value ->
		//     ((key != "class") && (key != "metaClass") && (value != null))
		// })
	}
	
	protected addFieldIfNotNull(Map map, String key, String value) {
		if (value != null) {
			map[key] = value;
		}
	}
}
