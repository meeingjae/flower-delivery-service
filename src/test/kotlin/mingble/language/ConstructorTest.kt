package mingble.language

import kotlin.test.Test

class ConstructorTest {

    init {
        println("test init")
    }

    @Test
    fun Test() {
        val firstMan: Man = Man("minjae", 17, Grade.C, 300)
        firstMan.footSize(300)
        print(firstMan.toString())
    }

    open class Person(var name: String, var age: Int, var grade: Grade) {

        var nameUpper: String = name.uppercase()
            get() = name.replace("min", " ")


        override fun toString(): String {
            return "nameUpperGet:" + nameUpper + "\n" +
                    "name:" + this.name + "\n" +
                    "nameUpper:" + nameUpper + "\n" +
                    "age:" + this.age  + "\n" +
                    "grade :" + grade.name + "\n"
        }
    }

    open class Man(name: String, age: Int, grade: Grade, var footSize: Long) : Person(name, age, grade) {

        fun footSize(footSize: Long) {
            this.footSize = this.footSize + footSize
        }
        override fun toString(): String {
            return super.toString() + "footSize: " + footSize + "\n"
        }
    }

    enum class Grade {
        A,
        B,
        C
    }
}