package example01

import scalaz._
import Scalaz._

object ExampleOrder extends App {
  println(1 gt 2) // false
  println(1 ?|? 2) // LT
  println(1.0 max 2.0) // 2.0
}
