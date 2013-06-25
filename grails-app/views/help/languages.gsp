<!doctype html>
<html>
  	<head>
	    <meta name="layout" content="bootstrap"/>
	    <link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'json_syntax.css')}" />
	    <title>ECKDefinition - Languages Supported</title>
  	</head>

  	<body>
    	<div class="row-fluid">
      		<section id="main">
        		<div class="hero-unit row">
          			<div class="page-header span12">
            			<h1>Supported Languages</h1>
          			</div>
        		</div>
        
        		<div class="row">
          			<div class="span12">
            			<h4>Invocation</h4>
           				<p>To retrieve a list of the languages supported the caller must send a GET to <a href="/ECKDefinition/languages">/ECKDefinition/languages</a></p>

           				<p>The content is returned as json</p>
           
           				<h4>Response</h4>
           				<pre id="successResponse" class="jsonSyntax"></pre>
         			</div>
       			</div>
		    </section>
    	</div>
    
		<script src="/ECKDefinition/js/json_syntax.js" type="text/javascript"></script>
		
	    <script type="text/javascript">
		    $(document).ready(function (){
		    	var jsonResponse = [{"code":"da","language":"Danish"},{"code":"it","language":"Italian"},{"code":"cs","language":"Czech"},{"code":"de","language":"German"},{"code":"pl","language":"Polish"},{"code":"pt","language":"Portuguese"},{"code":"fr","language":"French"},{"code":"en","language":"English"},{"code":"es","language":"Spanish"},{"code":"nl","language":"Dutch"}];
        		$("#successResponse").html(JSONSyntaxHighlight(jsonResponse));
    		});
    
    	</script>
	</body>
</html>
