object Signature1 {
    def isEven(n: Int): Boolean = {
        n % 2 == 0
    }

    def main(args: Array[String]): Unit = {
        println(isEven(10))
    }
}