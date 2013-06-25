package com.k_int.euinside.definition


class MessagePropertyUtilitiesService {

	private static String DIRECTORY_MESSAGE_PROPERTIES = "grails-app/i18n";

	private static String KEY_PREFIX_DEFINITION = "definition";
	private static String KEY_PREFIX_ERROR      = "error";
	private static String KEY_PREFIX_FIELD      = "field";
	private static String KEY_PREFIX_PROFILE    = "profile";
	
	protected static String KEY_SEPARATOR = ".";
	
	private static String SPLITTER_MESSAGE_PROPERTIES = "[_.]";
	private static String SPLITTER_KEY                = "\\.";
	
	private static Map<String, Language > languages = new HashMap<String, Language>();
	private static Map<String, Profile> profiles = new HashMap<String, Profile>();
	private static Map<String, Error> errors = new HashMap<String, Error>();
	
	private static String rootDirectory;
	
    static void initialise(servletContext) {

		// Determine the root directory to the application
		determineRootDirectory(servletContext);
		
		// Called once from bootstrap, to load up our configuration
		// Look at all the messages.property files to see which ones we have defined 		
		new File(rootDirectory + DIRECTORY_MESSAGE_PROPERTIES).eachFile {
			// The files take the format message_<language>_<country>.properties
			// Where both _<language> and _<country> are optional
			// but if _<country> is defined then _<language> must be defined
			String[] filenameComponents = it.name.split(SPLITTER_MESSAGE_PROPERTIES);
			
			// Generate the locale for each message.properties file we find
			if (filenameComponents.length > 2) {
				String languageCode = filenameComponents[1];
				Language language = new Language(languageCode);
				if (!languageCode.isEmpty()) {
					languages.putAt(languageCode, language);
				}
			}
		}
		
		// If we havn't loaded the default locale, load it now
		// Get hold of the default locale to ensure we do not load it twice
		Language defaultLanguage = Language.getDefaultLanguage();
		String defaultLanguageCode = defaultLanguage.getLanguageCode();
		if (languages.getAt(defaultLanguageCode) == null) { 
			languages.putAt(defaultLanguageCode, defaultLanguage);
		}
		
		// Now we have determined which languages we support, lets determine the list of profiles and error codes
		defaultLanguage.getProperties().keys().each {
			// The keys take one of the following formats
			// profile.definition.<profile identifier>
			// profile.field.definition.<profile identifier>.<field>
			// error.definition.<error code>
			
			// So first of all we split the fields up based on the dot separator
			String[] keyComponents = it.split(SPLITTER_KEY);
			
			// If we do not have at least 3 parts to this key we will ignore it
			if (keyComponents.length > 2) {
				// Now look at the first element to see what type of key we have
				if (keyComponents[0] == KEY_PREFIX_PROFILE) {
					// Now are we dealing with a profile, but is it a field ?
					if (keyComponents[1] == KEY_PREFIX_FIELD) {
						// it is a field, but we must have at least 4 elements in the array
						if (keyComponents.length > 3) {
							// The third element must be definition
							if (keyComponents[2] == KEY_PREFIX_DEFINITION) {
								// If this is the first time we have come across this profile then we need to create a new entry
								Profile profile = determineProfile(keyComponents, 3);
		
								// Determine the field identifier								
								String field = determineCode(keyComponents, 4);
								
								// Now add it to the profile
								profile.addField(field);
							}
						}
					} else {
						// We are just dealing with a profile
						determineProfile(keyComponents, 2);
					}
				} else {
					if (keyComponents[0] == KEY_PREFIX_ERROR) {
						String errorCode = determineCode(keyComponents, 2);
						errors.putAt(errorCode, new Error(errorCode));
					}
				}
			}
		}
	}

	private static void determineRootDirectory(servletContext) {
		def possibleRootPaths = [servletContext.getRealPath("/") + "WEB-INF/",
			                     "./"];
		possibleRootPaths.each {
			// Check to see if the path exists to the messages directory
			if ((new File(it + DIRECTORY_MESSAGE_PROPERTIES)).exists()) {
				rootDirectory = it;
			}
		}
	}
		
	private static Profile determineProfile(keyComponents, profilePosition) {
		// Get hold of the profile identifier
		String profileIdentifier = keyComponents[profilePosition];
		
		// If this is the first time we have come across this profile then we need to create a new entry
		Profile profile = profiles.getAt(profileIdentifier);
		if (profile == null) {
			profile = new Profile(profileIdentifier);
			profiles.putAt(profileIdentifier, profile);
		}
		return(profile);
	}
	
	private static String determineCode(String [] keyComponents, int startPosition) {
		String key = "";
		for (i in startPosition..(keyComponents.length - 1)) {
			// Unfortunately the key has a dot in it as there is more than 1 part to it
			if (!key.isEmpty()) {
				key += KEY_SEPARATOR;
			}
			key += keyComponents[i];
		}
		return(key);
	}
	
	static Language getLanguage(String languageCode) {
		return(languages.getAt(languageCode));
	}
	
	static Map<String, Language> getLanguages() {
		return(languages);
	}
	
	static Profile getProfile(String profile) {
		return(profiles.getAt(profile));
	}
	
	static Map<String, Profile> getProfiles() {
		return(profiles);
	}
	
	static Error getError(String error) {
		return(errors.getAt(error));
	}
	
	static Map<String, Error> getErrors() {
		return(errors);
	}
	
	static String getRootDirectory() {
		return(rootDirectory);
	}
}
