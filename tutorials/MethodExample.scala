
object Math {
    def add(x: Int, y: Int): Int = x+y

    def double(x: Int) = x * 2

    def isEven(n: Int): Boolean = {
        n % 2 == 0
    }

    def isTrue(a: Any): Boolean = a match {
        case 0 | "" => false
        case _ => true
    }

    def convertBooleanToString(bool: Boolean): String = {
        if (bool) "true" else "false"
    }

     def convertBooleanToStringMessage(bool: Boolean): String = bool match {
         case true => "you said true"
         case false => "you said false"
     }
}

object MethodLab {
    def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier

    def main(args: Array[String]): Unit = {
        println("addThenMultiply(1, 2)(3)=" + addThenMultiply(1, 2)(3))
        println("add(1, 2)=" + Math.add(1, 2))
        println("true=" + Math.convertBooleanToString(true))
        println("true message=" + Math.convertBooleanToStringMessage(true))

        println("9 is even? " + Math.isEven(9))
    }
}