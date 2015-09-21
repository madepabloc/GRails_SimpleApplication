<!DOCTYPE html>
<%@page import="org.h2.command.ddl.CreateLinkedTable"%>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Render Domain</title>
</head>
<body>
	<g:each in="${people}" var = "person">
		<tr>
		
			<td>${person.lastName}, ${person.firstName} - ${person.age} años - ${person.totalAmount}€</br></td>
			
		</tr>
	</g:each>
	
<%--	<g:createLink id="displayForm" action="displayForm">Save a Person</g:createLink>--%>
	<a href="${createLink(action : 'index' ,controller: 'person')}">Lista de Clientes</a>
	<a href="${createLink(action: 'transferenceForm', controller: 'transference')}">Make a Transference</a>
</body>
</html>