package ch.hedgesphere

class User {

    static constraints = {
		login blank:false, size:5..255,matches:/[\S]+/, unique:true
		password blank:false, size:5..255,matches:/[\S]+/
    }
	
	String login
	String password
	String firstName
	String lastName
}
