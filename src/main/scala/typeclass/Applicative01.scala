package typeclass

import scalaz._
import Scalaz._

object Applicative01 extends App {
  implicit val OptionApplicative = new Applicative[Option] {
    def point[A](a: => A): Option[A] = Some(a)
    def ap[A, B](fa: => Option[A])(f: => Option[(A) => B]): Option[B] = f.flatMap(fa.map(_))
  }
}
