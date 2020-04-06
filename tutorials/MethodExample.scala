
object Math {
    def add(x: Int, y: Int): Int = x+y
}

object MethodLab {
    def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier

    def main(args: Array[String]): Unit = {
        println("addThenMultiply(1, 2)(3)=" + addThenMultiply(1, 2)(3))
        println("add(1, 2)=" + Math.add(1, 2))
    }
}