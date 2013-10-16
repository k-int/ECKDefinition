<% def messagePropertyUtilitiesService = application.getAttribute("org.codehaus.groovy.grails.APPLICATION_CONTEXT").getBean("messagePropertyUtilitiesService") %>
<!doctype html>
<html>
	<head>
	  	<meta name="layout" content="bootstrap"/>
	  	<title>ECKDefinition - Test Page</title>
	</head>

	<body>
    	<div class="row-fluid">
			<section id="main">
		
		  		<div class="hero-unit row">
		    		<div class="page-header span12">
		      			<h1>ECKDefinition - Test Page</h1>
		    		</div>
		  		</div>
		  
			  	<div class="row">
			     	<div class="span12">
		           		<table>
		               		<tr>
		                   		<th align="right">Language: </th>
		                   		<td>
			                   		<select id="language">
										<g:each in="${messagePropertyUtilitiesService.getLanguages()}">
											<option value="${it.key}">${it.value.getDescription()}</option>
										</g:each>
										<option value="NotSet" selected="selected"></option>
									</select>
								</td>
		               		</tr>
		               		<tr>
		                   		<th align="right">Error Code: </th>
		                   		<td><g:field type="text" name="errorCode"/></td>
		               		</tr>
		               		<tr>
		                   		<th align="right">Profile Code: </th>
		                   		<td><g:field type="text" name="profileCode"/></td>
		               		</tr>
		               		<tr>
		                   		<th align="right">Field Identifier: </th>
		                   		<td><g:field type="text" name="fieldIdentifier"/></td>
		               		</tr>
		               		<tr>
		                   		<td colspan="2">
		                   			<div class="btn btn-primary">
		                       			<g:field type="button"  name="errorButton" value="Error"/>
		                       		</div>
		                   			<div class="btn btn-primary">
		                       			<g:field type="button"  name="languageButton" value="Language"/>
		                       		</div>
		                   			<div class="btn btn-primary">
		                       			<g:field type="button"  name="profileButton" value="Profile"/>
		                       		</div>
		                   		</td>
		               		</tr>
		           		</table>
			     	</div>
		  		</div>
      		</section>
    	</div>
    
    	<script type="text/javascript">
	    	$("#errorButton").click(function() {
		    	var url = "${request.contextPath}/errors"; 
		    	var language = $("#language").val();
		    	if (language != "NotSet") {
			    	url += "/" + language;
			    	var errorCode = $("#errorCode").val();
			    	if ((errorCode != null) && (errorCode != "")) {
				    	url += "/" + errorCode;
				    }
			    } 
		    	window.location = url;   
	    	});
	    	$("#languageButton").click(function() {
		    	var url = "${request.contextPath}/languages";
		    	window.location = url;   
	    	});
	    	$("#profileButton").click(function() {
		    	var url = "${request.contextPath}/profiles"; 
		    	var language = $("#language").val();
		    	if (language != "NotSet") {
			    	url += "/" + language;
			    	var profile = $("#profileCode").val();
			    	if ((profile != null) && (profile != "")) {
				    	url += "/" + profile;
				    	var fieldIdentifier = $("#fieldIdentifier").val();
				    	if ((fieldIdentifier != null) && (fieldIdentifier != "")) {
					    	url += "/" + fieldIdentifier;
				    	}
				    }
			    } 
		    	window.location = url;   
	    	});
    	</script>
    
  	</body>
</html>
