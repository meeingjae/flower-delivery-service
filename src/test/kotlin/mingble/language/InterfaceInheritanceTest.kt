package mingble.language

import kotlin.test.Test

class InterfaceInheritanceTest {

    @Test
    fun 출력() {
        val c : C = C()
        c.printName()
        c.printHello()
    }

    interface A {
        fun printName() {
            println("A name")
        }
        fun printHello() {
           println("A Hello")
        }
    }

    interface B {
        fun printName() {
            println("B name")
        }
        fun printHello() {
            println("B Hello")
        }
    }

    class C : A, B {
        override fun printName() {
            super<A>.printName()
        }
        override fun printHello() {
            super<B>.printHello()
        }
    }
}