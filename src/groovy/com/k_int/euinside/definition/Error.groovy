package com.k_int.euinside.definition

class Error {

	private static String MESSAGE_PREFIX_ERROR_DEFINITION = "error.definition";
	private String errorCode;
	
	Error(String errorCode) {
		this.errorCode = errorCode;
	}
	
	ErrorJSON getJSONObject(Language language) {
		return(new ErrorJSON(language, errorCode, MESSAGE_PREFIX_ERROR_DEFINITION));
	}
}
