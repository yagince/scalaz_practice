package typeclass

import scalaz._
import Scalaz._

object Functor01 extends App {
  case class Box[A](a: A)

  implicit val BoxFunctor = new Functor[Box] {
    def map[A, B](fa: Box[A])(f: (A) => B): Box[B] = Box(f(fa.a))
  }

  println(Box(1).map(i => i * 10))

  implicit def FunctionFunctor[R] = new Functor[({type l[a] = R=>a})#l] {
    def map[A, B](fa: R => A)(f: A => B) : R => B = (x => f(fa(x)))
  }
}
