package typeclass

import scala.util.Try

import scalaz._
import Scalaz._

object Monad01 extends App {
  Some("hoge") flatMap {str => Try{str.toInt}.toOption}
//  Some("hoge") >>= {str:String => Try{str.toInt}.toOption} // Error
}
