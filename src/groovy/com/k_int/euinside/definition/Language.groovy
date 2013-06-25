package com.k_int.euinside.definition

import com.k_int.euinside.definition.MessagePropertyUtilitiesService;

class Language {
	private static String BASE_MESSAGE_PROPERTIES = "grails-app/i18n/messages";
	private static String END_MESSAGE_PROPERTIES  = ".properties";
	private static String LANGUAGE_CODE_PREFIX    = "_";
	private static String LANGUAGE_DEFAULT = "en";

	private static Language defaultLanguage = new Language(LANGUAGE_DEFAULT); 
	private String languageCode;	
	private Properties properties = new Properties();
	
	Language(String languageCode) {
		this.languageCode = languageCode;
	
		// Load the properties, we first look at messages_<language>.properties
		// then message.properties
		// except for the default language where we only look in message.properties
		if (!loadProperties(languageCode != LANGUAGE_DEFAULT)) {
			loadProperties(false);
		}
	}
	
	boolean loadProperties(boolean withLanguage) {
		boolean loaded = true;
		String filename = MessagePropertyUtilitiesService.getRootDirectory() + BASE_MESSAGE_PROPERTIES + (withLanguage ? (LANGUAGE_CODE_PREFIX + languageCode) : "") + END_MESSAGE_PROPERTIES;
		try {
			properties.load(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			loaded = false;
			log.info("Unable to locate file \"" + filename + "\": e.message");
		} catch (IOException e) {
			loaded = false;
			log.info("Unable to load file \"" + filename + "\": e.message");
		}
		return(loaded);
	}

	Properties getProperties() {
		return(properties);
	}
	
	String getLanguageCode() {
		return(languageCode);
	}
	
	LanguageJSON getJSONObject(Language language) {
		return(new LanguageJSON(languageCode));
	}

	String getDescription(String codePrefix, String code) {
		String key = codePrefix + MessagePropertyUtilitiesService.KEY_SEPARATOR + code;
		String value = properties.getProperty(key);
		if (value == null) {
			// We didn't find it in our properties, so we will look at the default properties
			Properties defaultProperties = defaultLanguage.getProperties();
			value = defaultProperties.getProperty(key);
			if (value != null) {
				// Set it in our properties, so we do not need to look at the default properties next time around
				properties.setProperty(key, value);
			}
		}
		
		return(value);
	}
	
	static Language getDefaultLanguage() {
		return(defaultLanguage);
	}
}
