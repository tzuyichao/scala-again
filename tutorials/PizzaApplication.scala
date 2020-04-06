import scala.collection.mutable.ArrayBuffer

sealed trait Topping
case object Cheese extends Topping
case object Pepperoni extends Topping
case object Sausage extends Topping
case object Mushrooms extends Topping
case object Onions extends Topping

sealed trait CrustSize
case object SmallCrustSize extends CrustSize
case object MediumCrustSize extends CrustSize
case object LargeCrustSize extends CrustSize

sealed trait CrustType
case object RegularCrustType extends CrustType
case object ThinCrustType extends CrustType
case object ThinkCrustType extends CrustType

class Pizza (var crustSize: CrustSize = MediumCrustSize, var crustType: CrustType = ThinCrustType) {
    val toppings = ArrayBuffer[Topping]()

    def addTopping(topping: Topping): Unit = {
        toppings += topping
    }

    def removeTopping(topping: Topping): Unit = {
        toppings -= topping
    }

    def removeAllToppings(): Unit = {
        toppings.clear
    }

    override def toString(): String = {
        s"""
        |Crust Type: $crustType
        |Crust Size: $crustSize
        |Toppings: $toppings
        """.stripMargin
    }
}

object PizzaTest extends App {
    val p = new Pizza
    p.addTopping(Cheese)
    p.addTopping(Onions)
    println(p)
}