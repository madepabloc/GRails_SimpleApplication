
<%@ page import="sample.Transference" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'transference.label', default: 'Transference')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-transference" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-transference" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list transference">
			
				<g:if test="${transferenceInstance?.payer}">
				<li class="fieldcontain">
					<span id="payer-label" class="property-label"><g:message code="transference.payer.label" default="Payer" /></span>
					
						<span class="property-value" aria-labelledby="payer-label"><g:link controller="person" action="show" id="${transferenceInstance?.payer?.id}">${transferenceInstance?.payer?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${transferenceInstance?.beneficiary}">
				<li class="fieldcontain">
					<span id="beneficiary-label" class="property-label"><g:message code="transference.beneficiary.label" default="Beneficiary" /></span>
					
						<span class="property-value" aria-labelledby="beneficiary-label"><g:link controller="person" action="show" id="${transferenceInstance?.beneficiary?.id}">${transferenceInstance?.beneficiary?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${transferenceInstance?.amount}">
				<li class="fieldcontain">
					<span id="amount-label" class="property-label"><g:message code="transference.amount.label" default="Amount" /></span>
					
						<span class="property-value" aria-labelledby="amount-label"><g:fieldValue bean="${transferenceInstance}" field="amount"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${transferenceInstance?.id}" />
					<g:link class="edit" action="edit" id="${transferenceInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
