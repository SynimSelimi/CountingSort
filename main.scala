import scala.util.Random
import Array._
import java.util.concurrent.TimeUnit

// Generate random integer array
def generateArray (n: Int) : Array[Int] = {
  var arr = (0 to n).toList 
  Random.shuffle(arr).toArray
}

// Apply Comparison Count Sort on a
def comparisonCountSort(a: Array[Int]): Array[Int] = {
  val size = a.length
  val sortedArray: Array[Int] = new Array[Int](size)
  val count: Array[Int] = new Array[Int](size)

  for (i <- 0 to size - 1; j <- i + 1 to size - 1) {
    if(a(i) < a(j)) count(j) += 1
    else count(i) += 1
  }
  
  for (i <- 0 to size - 1)
    sortedArray(count(i)) = a(i)

  sortedArray
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
  var scale = 1000
  var array = generateArray(scale);

  // Test comparisonCountSort speed
  println(array(0))
  var sortedArray = time {
    comparisonCountSort(array)
  }
  println(sortedArray(0))
}

// Run main demo
main()