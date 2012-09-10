<%@ page import="ch.hedgesphere.Trade" %>



<div class="fieldcontain ${hasErrors(bean: tradeInstance, field: 'account', 'error')} ">
	<label for="account">
		<g:message code="trade.account.label" default="Account" />
		
	</label>
	<g:textField name="account" value="${tradeInstance?.account}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tradeInstance, field: 'amount', 'error')} required">
	<label for="amount">
		<g:message code="trade.amount.label" default="Amount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="amount" required="" value="${fieldValue(bean: tradeInstance, field: 'amount')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tradeInstance, field: 'bankAccountType', 'error')} ">
	<label for="bankAccountType">
		<g:message code="trade.bankAccountType.label" default="Bank Account Type" />
		
	</label>
	<g:textField name="bankAccountType" value="${tradeInstance?.bankAccountType}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tradeInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="trade.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<joda:datePicker name="date" value="${tradeInstance?.date}" ></joda:datePicker>
</div>

<div class="fieldcontain ${hasErrors(bean: tradeInstance, field: 'nav', 'error')} required">
	<label for="nav">
		<g:message code="trade.nav.label" default="Nav" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="nav" required="" value="${fieldValue(bean: tradeInstance, field: 'nav')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tradeInstance, field: 'security', 'error')} ">
	<label for="security">
		<g:message code="trade.security.label" default="Security" />
		
	</label>
	<g:textField name="security" value="${tradeInstance?.security}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tradeInstance, field: 'shares', 'error')} required">
	<label for="shares">
		<g:message code="trade.shares.label" default="Shares" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="shares" required="" value="${fieldValue(bean: tradeInstance, field: 'shares')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tradeInstance, field: 'transactionType', 'error')} ">
	<label for="transactionType">
		<g:message code="trade.transactionType.label" default="Transaction Type" />
		
	</label>
	<g:textField name="transactionType" value="${tradeInstance?.transactionType}"/>
</div>

