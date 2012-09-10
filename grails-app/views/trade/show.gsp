
<%@ page import="ch.hedgesphere.Trade" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trade.label', default: 'Trade')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-trade" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-trade" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list trade">
			
				<g:if test="${tradeInstance?.account}">
				<li class="fieldcontain">
					<span id="account-label" class="property-label"><g:message code="trade.account.label" default="Account" /></span>
					
						<span class="property-value" aria-labelledby="account-label"><g:fieldValue bean="${tradeInstance}" field="account"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tradeInstance?.amount}">
				<li class="fieldcontain">
					<span id="amount-label" class="property-label"><g:message code="trade.amount.label" default="Amount" /></span>
					
						<span class="property-value" aria-labelledby="amount-label"><g:fieldValue bean="${tradeInstance}" field="amount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tradeInstance?.bankAccountType}">
				<li class="fieldcontain">
					<span id="bankAccountType-label" class="property-label"><g:message code="trade.bankAccountType.label" default="Bank Account Type" /></span>
					
						<span class="property-value" aria-labelledby="bankAccountType-label"><g:fieldValue bean="${tradeInstance}" field="bankAccountType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tradeInstance?.date}">
				<li class="fieldcontain">
					<span id="date-label" class="property-label"><g:message code="trade.date.label" default="Date" /></span>
					
						<span class="property-value" aria-labelledby="date-label"><g:fieldValue bean="${tradeInstance}" field="date"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tradeInstance?.nav}">
				<li class="fieldcontain">
					<span id="nav-label" class="property-label"><g:message code="trade.nav.label" default="Nav" /></span>
					
						<span class="property-value" aria-labelledby="nav-label"><g:fieldValue bean="${tradeInstance}" field="nav"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tradeInstance?.security}">
				<li class="fieldcontain">
					<span id="security-label" class="property-label"><g:message code="trade.security.label" default="Security" /></span>
					
						<span class="property-value" aria-labelledby="security-label"><g:fieldValue bean="${tradeInstance}" field="security"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tradeInstance?.shares}">
				<li class="fieldcontain">
					<span id="shares-label" class="property-label"><g:message code="trade.shares.label" default="Shares" /></span>
					
						<span class="property-value" aria-labelledby="shares-label"><g:fieldValue bean="${tradeInstance}" field="shares"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tradeInstance?.transactionType}">
				<li class="fieldcontain">
					<span id="transactionType-label" class="property-label"><g:message code="trade.transactionType.label" default="Transaction Type" /></span>
					
						<span class="property-value" aria-labelledby="transactionType-label"><g:fieldValue bean="${tradeInstance}" field="transactionType"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${tradeInstance?.id}" />
					<g:link class="edit" action="edit" id="${tradeInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
