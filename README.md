# kotlin-book
examples in "Kotlin in Action"

The examples can be tried as follows:
- for a main, by compiling and running the program
- else, by using the Kotlin REPL, e.g.,
    ```kotlin
    import chapter2.Person
    val person = Person("Bob", true)
    println(person.name)
    ```

- [x] chapter 2
    (basics,
    `val` vs `var`, string templates,
    functions, value-object classes, enums,
    smart cast, ranges,
    conditionals including `when`, loops,
    exceptions)
- [x] chapter 3
    (collections, strings including multi-line strings, regex,
    named arguments, default parameter values,
    infix call syntax,
    destructuring declarations,
    extension functions and properties,
    structuring code)
- [x] chapter 4
    (more on classes,
    differences wrt. Java -- including
        final by default,
        package vs module visibility,
        protected semantics,
        nested and inner classes --
    interfaces, data classes, sealed classes, overriding,
    non trivial properties and constructors,
    delegation,
    companion objects and singletons,
    `==` vs `===`)
