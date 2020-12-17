import scala.util.Random
import Array._

// Generate random integer array
def generateArray (n: Int) : Array[Int] = {
  var arr = (0 to n).toList 
  Random.shuffle(arr).toArray
}

// Main demo
def main(): Unit = {
  // Set test scale
  var scale = 10000
  var array = generateArray(scale);
  println(array(0))
}

// Run main demo
main()