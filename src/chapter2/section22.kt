package chapter2

class Person(
        val name: String,       // getter
        var isMarried: Boolean  // getter + setter
)

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean       // custom accessor
        get() {
            return height == width
        }
}

