package chapter4

import java.util.Comparator
import java.io.File

data class Person(val name: String, var salary: Double) {
    object NameComparator : Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int = o1.name.compareTo(o2.name)
    }

    object SalaryComparator : Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int = o1.salary.compareTo(o2.salary)
    }
}

object Payroll {
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary() =
            allEmployees
                    .map { e -> e.salary }
                    .sum()
}

fun main(args: Array<String>) {
    val selector = 5
    when (selector) {
        1 -> main1()
        2 -> main2()
        3 -> main3()
        4 -> main4()
        5 -> main5()
        else -> println("Unknown choice")
    }
}

fun main1() {
    Payroll.allEmployees.addAll(listOf(
            Person("Alice", 2000.0),
            Person("Charles", 2500.0),
            Person("Bob", 1500.0)
    ))
    println("""There are ${Payroll.allEmployees.size} employees,
                the total salary is ${Payroll.calculateSalary()}""")
}

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}

fun main2() {
    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))
}

fun main3() {
    Payroll.allEmployees.addAll(listOf(
            Person("Alice", 2000.0),
            Person("Charles", 2500.0),
            Person("Bob", 1500.0)
    ))
    println(Payroll.allEmployees.sortedWith(Person.NameComparator))
    println(Payroll.allEmployees.sortedWith(Person.SalaryComparator))
}

class User4 {
    val nickname: String

    constructor(email: String) {
        nickname = email.substringBefore('@')
    }

    constructor(facebookAccountId: Int) {
        nickname = getFacebookName(facebookAccountId)
    }
}

fun getFacebookName(id: Int) = "Foo$id"

class User5 private constructor(val nickname: String) {
    override fun toString() = "User $nickname"

    companion object {
        fun newSubscribingUser(email: String) = User5(email.substringBefore('@'))

        fun newFacebookUser(facebookAccountId: Int) = User5(getFacebookName(facebookAccountId))
    }
}

fun main4() {
    val user = User5.newSubscribingUser("foo@bar.com")
    println(user)
}

// we replace the JSON example by a String one to be able to run it
interface StringFactory<T> {
    fun fromString(text: String): T
}

class Person2(val name: String) {
    companion object : StringFactory<Person2> {
        override fun fromString(text: String) = Person2(name = text.trim())
    }

    override fun toString() = "Person $name"
}

class User6(val nickname: String, val email: String) {
    companion object : StringFactory<User6> {
        override fun fromString(text: String): User6 {
            val (n, e) = text.split(':')
            return User6(n.trim(), e.trim())
        }
    }

    override fun toString() = "User $nickname, email $email"
}

fun <T> loadFromStrings(factory: StringFactory<T>, text: String): List<T> {
    var rtr = ArrayList<T>()
    text.split('\n').forEach { x -> rtr.add(factory.fromString(x)) }
    return rtr
}

fun main5() {
    val ps = loadFromStrings(Person2,
            """
            Alice
            Bob
            Charles
            """.trimIndent())
    println(ps)
    val us = loadFromStrings(User6,
            """
            Alice   : alice@foo.com
            Bob     : bob@bar.com
            Charles : charles@foo.com
            """.trimIndent())
    println(us)
}