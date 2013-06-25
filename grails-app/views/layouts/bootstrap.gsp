<%@ page import="org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes" %>
<!doctype html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <title><g:layoutTitle default="${meta(name: 'app.name')}"/></title>
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <meta name="viewport" content="initial-scale = 1.0">
	
	    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
	    <!--[if lt IE 9]>
	      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	    <![endif]-->
	
	    <r:require modules="scaffolding"/>
	
	    <!-- Le fav and touch icons -->
	    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
	    <link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
	    <link rel="apple-touch-icon" sizes="72x72" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
	    <link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
	
	    <g:layoutHead/>
	    <r:layoutResources/>
	</head>

  	<body>
    	<nav class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container">
				  	<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					    <span class="icon-bar"></span>
					    <span class="icon-bar"></span>
					    <span class="icon-bar"></span>
					</a>
				  	<a class="brand" href="${createLink(uri: '/')}">ECKDefinition</a>
					<div class="nav-collapse">
						<ul class="nav">              
							<li<%= request.forwardURI == "${createLink(uri: '/')}" ? ' class="active"' : '' %>><a href="${createLink(uri: '/')}">Home</a></li>
							<li<%= request.forwardURI.startsWith("${createLink(uri: '/help/errors')}") ? ' class="active"' : '' %>><a href="${createLink(uri: '/help/errors')}">Errors</a></li>
							<li<%= request.forwardURI.startsWith("${createLink(uri: '/help/languages')}") ? ' class="active"' : '' %>><a href="${createLink(uri: '/help/languages')}">Languages</a></li>
							<li<%= request.forwardURI.startsWith("${createLink(uri: '/help/profiles')}") ? ' class="active"' : '' %>><a href="${createLink(uri: '/help/profiles')}">Profiles</a></li>
						</ul>
					</div>
				
				</div>
			</div>
		</nav>
		<div class="container">
			<g:layoutBody/>
			<hr>
			<footer>
			  	<span class="pull-right">&copy; Knowledge Integration Ltd 2013</span>
			  	<span><b>Europeana Inside ECK Definition prototype</b> <i>Simplified uploading of resources to Europeana Inside the Collections Management System</i></span>
			</footer>
		</div>
	    <r:layoutResources/>
  	</body>
</html>
