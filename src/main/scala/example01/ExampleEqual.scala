package example01

import scalaz._
import Scalaz._

object ExampleEqual extends App {
  // ==との違いは型安全
  println(1 == 1.0) // true
  println(1 === 1) // true
  //println(1 === 1.0) // error

  // someはscalazのメソッド
  // =/=は===の否定
  // /== は＝から始まらないので優先順位が変わってしまうらしい
  println(1.some =/= 2.some) // true
  println(1 =/= 2 && false) // false

  1 assert_=== 1
}
