
<%@ page import="ch.hedgesphere.Trade" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trade.label', default: 'Trade')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-trade" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-trade" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="account" title="${message(code: 'trade.account.label', default: 'Account')}" />
					
						<g:sortableColumn property="amount" title="${message(code: 'trade.amount.label', default: 'Amount')}" />
					
						<g:sortableColumn property="bankAccountType" title="${message(code: 'trade.bankAccountType.label', default: 'Bank Account Type')}" />
					
						<g:sortableColumn property="date" title="${message(code: 'trade.date.label', default: 'Date')}" />
					
						<g:sortableColumn property="nav" title="${message(code: 'trade.nav.label', default: 'Nav')}" />
					
						<g:sortableColumn property="security" title="${message(code: 'trade.security.label', default: 'Security')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${tradeInstanceList}" status="i" var="tradeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${tradeInstance.id}">${fieldValue(bean: tradeInstance, field: "account")}</g:link></td>
					
						<td>${fieldValue(bean: tradeInstance, field: "amount")}</td>
					
						<td>${fieldValue(bean: tradeInstance, field: "bankAccountType")}</td>
					
						<td>${fieldValue(bean: tradeInstance, field: "date")}</td>
					
						<td>${fieldValue(bean: tradeInstance, field: "nav")}</td>
					
						<td>${fieldValue(bean: tradeInstance, field: "security")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${tradeInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
