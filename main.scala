import scala.util.Random
import Array._
import java.util.concurrent.TimeUnit

// Generate random integer array
def generateArray (n: Int) : Array[Int] = {
  var arr = (0 to n).toList 
  Random.shuffle(arr).toArray
}

// Measure speed of executing block R 
def time[R](block: => R): R = {
  val t0 = System.nanoTime()
  val result = block    // call-by-name
  val t1 = System.nanoTime()
  val diff = TimeUnit.MILLISECONDS.convert((t1 - t0), TimeUnit.NANOSECONDS)
  println("Elapsed time: " + diff + "ms")
  result
}

// Main demo
def main(): Unit = {
  // Set test scale
  var scale = 10000
  var array = time {
    generateArray(scale);
  }
  println(array(0))
}

// Run main demo
main()