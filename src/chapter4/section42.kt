package chapter4

import javax.naming.Context
import javax.swing.text.AttributeSet

open class User1(val nickname: String, val isSubscribed: Boolean = true) {}

class TwitterUser(nickname: String) : User1(nickname) {}

interface User {
    val nickname: String
}

class PrivateUser(override val nickname: String) : User

class SubscribingUser(val email: String) : User {
    override val nickname: String
        get() = email.substringBefore('@')
}

class FacebookUser(val accountId: Int) : User {
    override val nickname = getFacebookName(accountId)

    private fun getFacebookName(accountId: Int): String {
        return "foo"
    }
}

interface User2 {
    val email: String
    val nickname: String
        get() = email.substringBefore('@')
}

class User3(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println("""
                Address was changed for $name:
                "$field" -> "$value".""".trimIndent())
            field = value
        }
}

class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}
