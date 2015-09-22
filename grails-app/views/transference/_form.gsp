<%@ page import="sample.Transference" %>



<div class="fieldcontain ${hasErrors(bean: transferenceInstance, field: 'payer', 'error')} required">
	<label for="payer">
		<g:message code="transference.payer.label" default="Payer" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="payer" name="payer.id" from="${sample.Person.list()}" optionKey="id" required="" value="${transferenceInstance?.payer?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: transferenceInstance, field: 'beneficiary', 'error')} required">
	<label for="beneficiary">
		<g:message code="transference.beneficiary.label" default="Beneficiary" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="beneficiary" name="beneficiary.id" from="${sample.Person.list()}" optionKey="id" required="" value="${transferenceInstance?.beneficiary?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: transferenceInstance, field: 'amount', 'error')} required">
	<label for="amount">
		<g:message code="transference.amount.label" default="Amount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="amount" value="${fieldValue(bean: transferenceInstance, field: 'amount')}" required=""/>
</div>

