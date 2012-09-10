<html>
   <head>
      <meta name="layout" content="main"/>
      <r:require modules="bootstrap"/>
   </head>
<body>
<h1>HFoF TOM Dashboard</h1>
<div id="loginBox" class="loginBox">
	<g:if test="${session?.user}">
		<div style="margin-top: 20px">
			<div style="float: right;">
				<a href="#">Profile</a> |
				<g:link controller="user" action="logout">Logout</g:link>
				<br>
			</div>
			<h2>Some cool menu</h2>
		</div>
	</g:if>
	<g:else>
		<g:form name="loginForm" url="[controller:'user',action:'login']">
			<div>Username:</div>
			<g:textField name="login"
				value="${fieldValue(bean:loginCmd, field:'login')}">
			</g:textField>
			<div>Password:</div>
			<g:passwordField name="password"></g:passwordField>
			<br />
	            <button class="btn btn-large btn-primary" type="submit">Login</button>
		</g:form>
		<g:renderErrors bean="${loginCmd}"></g:renderErrors>
	</g:else>
</div>
</body>
</html>