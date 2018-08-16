package chapter3

class User(val id: Int, val name: String, val address: String)

fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                    "Can't save user $id: empty $fieldName")
        }
    }

    validate(name, "name")
    validate(address, "address")
}

fun saveUser(user: User) {
    user.validateBeforeSave()

    // save user to database
}
