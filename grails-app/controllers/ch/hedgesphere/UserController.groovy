package ch.hedgesphere

class UserController {

	def index() {
	}

	def login(LoginCommand cmd) {
		if(request.method == 'POST') {
			if(!cmd.hasErrors()) {
				session.user = cmd.getUser()
				redirect controller: 'dashboard'
			} else {
				render view:'/dashboard/dashboard', model: [loginCmd: cmd]
			}
		} else {
			render view:'/dashboard/dashboard'
		}
	}
}

class LoginCommand {
	String login
	String password
	private u
	
	User getUser() {
		if(!u && login) {
			//u = User.findByLogin(login)
			u = new User(firstName: 'Bob', lastName: 'Bamalam', login: 'bob', password: 'password')
		}
		return u
	}
	
	static constraints = {
		
		login blank:false, validator:{ val, obj ->
			if(!obj.user)
				return "user.not.found"
		}
	
		password blank:false, validator:{ val, obj ->
			if(obj.user && obj.user.password != val)
				return "user.password.invalid"
		}
	}
}