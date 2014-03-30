package i_introduction._9_Data_Classes

import util.TODO

class Person1(val name: String, val age: Int)

//no 'new' keyword
fun create() = Person1("James Gosling", 58)

fun useFromJava() {
    // property 'val name' = backing field + getter
    // => from Java you access it through 'getName()'
    JavaCode9().useKotlinClass(Person1("Martin Odersky", 55))

    // property 'var mutable' = backing field + getter + setter
}

// It's the same as the following (redundant code is generated):
class Person2(_name: String, _age: Int) { //_name, _age are constructor parameters
    val name: String = _name //property initialization is the part of constructor
      get() {
          return $name // you can access the backing field of property with '$' + property name
      }

    val age: Int = _age
      get() {
          return $age
      }
}

// If you add annotation 'data' for your class, some additional methods will be generated for you
// like 'equals', 'hashCode', 'toString'.

data class Person3(val name: String, val age: Int)

// This class is the same only 42 lines shorter than Java class Person4. =)

fun todoTask9() = TODO(
        task = """There is no task for you here.
        Just confirm you're not forgetting to read carefully all code examples and comments and
        ask questions if any. =) """,
        references = { JavaCode9.Person4("???", -1) }
)

fun task9(): Boolean = todoTask9()