
<%@ page import="sample.Transference" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'transference.label', default: 'Transference')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-transference" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-transference" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="transference.payer.label" default="Payer" /></th>
					
						<th><g:message code="transference.beneficiary.label" default="Beneficiary" /></th>
					
						<g:sortableColumn property="amount" title="${message(code: 'transference.amount.label', default: 'Amount')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${transferenceInstanceList}" status="i" var="transferenceInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${transferenceInstance.id}">${fieldValue(bean: transferenceInstance, field: "payer")}</g:link></td>
					
						<td>${fieldValue(bean: transferenceInstance, field: "beneficiary")}</td>
					
						<td>${fieldValue(bean: transferenceInstance, field: "amount")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${transferenceInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
