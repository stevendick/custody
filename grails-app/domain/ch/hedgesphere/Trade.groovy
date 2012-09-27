package ch.hedgesphere

import grails.plugin.multitenant.core.annotation.MultiTenant

import org.joda.time.LocalDate

@MultiTenant
class Trade {

	String account
	String security
	String transactionType
	String bankAccountType
	BigDecimal amount
	BigDecimal shares
	BigDecimal nav
	LocalDate date

    static constraints = {
    }

	static {
		grails.converters.JSON.registerObjectMarshaller(Trade) {
			return it.properties.findAll {k,v -> k != 'class'}
		}
	}
}
