<!doctype html>
<html>
  	<head>
	    <meta name="layout" content="bootstrap"/>
	    <link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'json_syntax.css')}" />
	    <title>ECKDefinition - Error Definitions</title>
  	</head>

  	<body>
    	<div class="row-fluid">
      		<section id="main">
        		<div class="hero-unit row">
          			<div class="page-header span12">
            			<h1>Error Definitions</h1>
          			</div>
        		</div>
        
        		<div class="row">
          			<div class="span12">
            			<h4>Invocation</h4>
            			<p>The following are the possible ways to retrieve the definition of error message(s)</p>
            			
			            <dl>
			                <dt>/errors</dt>
			                <dd>Retrieves the full list of errors in the default language</dd>
			                <dt>/errors/&lt;language&gt;</dt>
			                <dd>Retrieves the full list of errors in the specified language</dd>
			                <dt>/errors/&lt;language&gt;/&lt;error code&gt;</dt>
			                <dd>Retrieves the definition of the specified error in the requested language</dd>
			            </dl>
            			 
           				<p>If the error definition is not available in the specified language, then it will be returned in the default language</p>

           				<p>The content is returned as json</p>
           
           				<h4>Response when /errors/en/error1 is specified as the url</h4>
           				<pre id="errorCodeResponse" class="jsonSyntax"></pre>
           
           				<h4>Response /errors or /errors/en is specified as the url</h4>
           				<pre id="allErrorsResponse" class="jsonSyntax"></pre>
         			</div>
       			</div>
		    </section>
    	</div>
    
		<script src="/ECKDefinition/js/json_syntax.js" type="text/javascript"></script>
		
	    <script type="text/javascript">
		    $(document).ready(function (){
		    	var errorCodeResponse = {"error":"error1","definition":"The first error code"};
        		$("#errorCodeResponse").html(JSONSyntaxHighlight(errorCodeResponse));
		    	var allErrorsResponse = [{"error":"error1","definition":"The first error code"},{"error":"error.with.dots","definition":"An error code with dots in it"}];
        		$("#allErrorsResponse").html(JSONSyntaxHighlight(allErrorsResponse));
    		});
    
    	</script>
	</body>
</html>
