package example01

import scalaz._
import Scalaz._

object ExampleEnum extends App {
  val range = 'a' to 'c'
  println(range)
  println(range.map{_.succ})

  println(1 |=> 10)
  println(1 |==>(2, 10))
  println(1 |-> 10)
  println(1 |-->(2, 10))
}
