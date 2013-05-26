package example00

import scalaz._
import Scalaz._

object SyntaxSamples extends App {
  println(1.some | 2) // Some(1).getOrElse(2)

  val a = 10
  val b = 100
  println((a > b)? "a is Bigger" | "b is Bigger") // if (a>b) "" else ""
}
