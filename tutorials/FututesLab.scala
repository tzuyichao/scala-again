import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object MultipleFutures extends App {
    println("Futures lab")
    val startTime = currentTime

    val applFuture = getStockPrice("APPL")
    val amznFuture = getStockPrice("AMZN")
    val googFuture = getStockPrice("GOOG")

    val result: Future[(Double, Double, Double)] = for {
        appl <- applFuture
        amzn <- amznFuture
        goog <- googFuture
    } yield(appl, amzn, goog)
    
    result.onComplete {
        case Success(x) => {
            val totalTime = deltaTime(startTime)
            println(s"In success case, time delta: $totalTime")
            println(s"The stock price are: $x")
        }
        case Failure(e) => e.printStackTrace
    }

    // keep jvm main thread alive
    sleep(5000)

    println("Delta:" + deltaTime(startTime))

    def getStockPrice(stockSymbol: String): Future[Double] = Future {
        val r = scala.util.Random
        val randomSleepTime = r.nextInt(3000)
        println(s"For $stockSymbol, sleep time is $randomSleepTime")
        val randomPrice = r.nextDouble * 1000
        sleep(randomSleepTime)
        randomPrice
    }
    def sleep(time: Long): Unit = Thread.sleep(time)
    def currentTime = System.currentTimeMillis()
    def deltaTime(t0: Long) = currentTime - t0
}