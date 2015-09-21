<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
	</head>
	<body>
		<g:form action="save" controller="person">
			<label for="lastName">Last Name</label>
			<g:textField name="lastName" value="${personSample.lastName}"/>
			</br>
			<label for="firstName">First Name</label>
			<g:textField name="firstName" value="${personSample.firstName}"/>
			</br>
			<label for="age">Age</label>
			<g:field name="age" type="number"  value="${personSample.age}"/>
			</br>
			<label for="totalAmount">Amount</label>
			<g:textField name="totalAmount" type="number"  value="${personSample.totalAmount}"/>
			
			</br>
			<g:submitButton name="create" value="Save" />
			
		
		</g:form>
	</body>
</html>