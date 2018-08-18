package chapter4

import java.io.Serializable

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) =
            println("I ${if (b) "got" else "lost"} focus.")

    fun showOff() = println("I'm focusable!")
}

class Button : Clickable, Focusable, View {
    override fun getCurrentState(): State = ButtonState()
    override fun restoreState(state: State) {}

    override fun click() = println("I was clicked.")
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

    class ButtonState : State {}
}

fun main(args: Array<String>) {
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.click()
}

abstract class Animated {
    abstract fun animate()
    open fun stopAnimating() {}
    fun animateTwice() {}
}

open class RichButton : Clickable {
    fun disable() {}
    open fun animate() {}
    final override fun click() {}
}

interface State : Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

/* Kotlin 1.0 requires inner subclasses

sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}

fun eval(e: Expr): Int =
        when (e) {
            is Expr.Num -> e.value
            is Expr.Sum -> eval(e.left) + eval(e.right)
        }

*/

/* Kotlin 1.1+ accepts this */

sealed class Expr {}
class Num(val value: Int) : Expr()
class Sum(val left: Expr, val right: Expr) : Expr()

fun eval(e: Expr): Int =
        when (e) {
            is Num -> e.value
            is Sum -> eval(e.left) + eval(e.right)
        }
