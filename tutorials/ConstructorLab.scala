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

object ConstructorLab {
    def main(args: Array[String]): Unit = {
        val p = new Person("Bill", "Panner")
        println(p.firstName + " " + p.lastName)
        println(p.toString())
        p.printFullName()
    }
}