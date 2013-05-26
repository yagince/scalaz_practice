package typeclass

/**
 * Created with IntelliJ IDEA.
 * User: natsuki
 * Date: 2013/05/25
 * Time: 23:14
 * To change this template use File | Settings | File Templates.
 */

import scalaz._
import Scalaz._

object Example01 extends App {
  implicit val IntShow = new Show[Int] {
    override def shows(f: Int): String = f.toString + "."
  }

//  def shows[A](a: A)(implicit shower: Show[A]) = shower.shows(a)
  def shows[A: Show](a: A) = implicitly[Show[A]].shows(a)

  println(shows(1))
  println(1.shows)
}
