package chapter3

import chapter3.strings.join

fun main(args: Array<String>) {
    val list = listOf("args (with spread op): ", *args)
    println(list)
    val list2 = listOf("args (without spread op): ", args)
    println(list2)
}

infix fun Any.to(other: Any) = Pair(this, other)
