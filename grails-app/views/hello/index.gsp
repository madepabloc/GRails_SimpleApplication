<!DOCTYPE html>
<%@page import="org.h2.command.ddl.CreateLinkedTable"%>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Render Domain</title>
</head>
<body>
	<g:each in="${personList}" var = "person">
		<tr>
		
			<td>${person.lastName}, ${person.firstName} - ${person.age}</br></td>
			
		</tr>
	</g:each>
	
<%--	<g:createLink id="displayForm" action="displayForm">Save a Person</g:createLink>--%>
	<a href="${createLink(action: 'displayForm')}">Save a Person</a>
</body>
</html>