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

// Apply Distribution Count Sort on a from min to max
def distributionCountSort(a: Array[Int], min: Int, max: Int): Array[Int] = {
  def toKey(value: Int): Int = {
    return value - min
  }

  val result: Array[Int] = new Array[Int](a.length)

  // Count each key and save it to count
  val count: Array[Int] = new Array[Int](max - min + 1)
  a.foreach( (e: Int) => count(toKey(e)) += 1)

  // Use preceding counts to compute offset for each array member
  // This will offset duplicates and set position for single values
  // The addition is accumulative, 2, 3, 4, 5, ...
  for (i <- 1 to (max-min)) {
    count(i) += count(i-1)
  }

  // Use sorted keys to assemble the sorted array
  // Subtract the 1 offset added above as a side-effect
  for (e <- a.reverseIterator) {
    count(toKey(e)) -= 1
    result(count(toKey(e))) = e
  }
  
  result
}

// Apply Distribution Count Sort with defualt min max
def distributionCountSort(a: Array[Int]): Array[Int] = {
  distributionCountSort(a, a.min, a.max)
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

  // Test distributionCountSort speed
  println(array(0))
  sortedArray = time {
    distributionCountSort(array)
  }
  println(sortedArray(0))
}

// Run main demo
main()