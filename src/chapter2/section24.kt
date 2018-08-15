package chapter2

import java.util.*

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun binary() {
    val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary\n")
    }
}

fun recognize(c: Char) = when (c) {
    in '0' .. '9' -> "Digit"
    in 'a' .. 'z', in 'A' .. 'Z' -> "Letter"
    else -> "Don't know"
}
