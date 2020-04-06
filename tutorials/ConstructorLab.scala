/**
 from https://docs.scala-lang.org/overviews/scala-book/classes.html
 Tip: If you use Scala to write OOP code, create your fields as var fields so you can mutate them. 
 When you write FP code with Scala, you’ll general use case classes instead of classes like this.
 **/
class Person(var firstName: String, var lastName: String) {
    println("Constructor begins")

    val age = 0

    override def toString: String = s"$firstName $lastName is $age years old."

    def printFullName(): Unit = {
        println(s"$firstName $lastName")
    }

    println("End of constructor")
}

object PizzaDefault {
    val DefaultCrustSize: Int = 12
    val DefaultCrustType: String = "THIN"
}

class Pizza(var crustSize: Int, var crustType: String) {

    def this(crustSize: Int) {
        this(crustSize, PizzaDefault.DefaultCrustType)
    }

    def this(crustType: String) {
        this(PizzaDefault.DefaultCrustSize, crustType)
    }

    def this() {
        this(PizzaDefault.DefaultCrustSize, PizzaDefault.DefaultCrustType)
    }

    override def toString(): String = s"A $crustSize inch pizza with a $crustType crust"
}

object ConstructorLab {
    def main(args: Array[String]): Unit = {
        val p = new Person("Bill", "Panner")
        println(p.firstName + " " + p.lastName)
        println(p.toString())
        p.printFullName()

        val pizza1 = new Pizza(12, "THIN")
        val pizza2 = new Pizza(12)
        val pizza3 = new Pizza("THIN")
        val pizza4 = new Pizza
        println("pizza1=" + pizza1)
        println("pizza2=" + pizza2)
        println("pizza3=" + pizza3)
        println("pizza4=" + pizza4)
    }
}