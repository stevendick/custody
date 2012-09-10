package ch.hedgesphere

import org.joda.time.LocalDate

class Trade {

	String account
	String security
	String transactionType
	String bankAccountType
	BigDecimal Amount
	BigDecimal shares
	BigDecimal nav
	LocalDate date
	
    static constraints = {
    }
}
