package example00

import scalaz._
import Scalaz._

object MyLibrary extends App {
  trait MonoidOp[A] {
    val F: Sum.Monoid[A]
    val value: A
    def |+|(a2: A) = F.mappend(value, a2)
  }

  implicit class ToMonoidOp[A: Sum.Monoid](val a: A) extends MonoidOp[A]{
    val value: A = a
    val F: Sum.Monoid[A] = implicitly[Sum.Monoid[A]]
  }

  import Sum.Monoid._

  println(1 |+| 2)
  println("hoge" |+| "aaaa")

  case class Hoge(id: Int, name: String)
  implicit object HogeMonoid extends Sum.Monoid[Hoge] {
    def mzero: Hoge = Hoge(0, "")
    def mappend(a: Hoge, b: Hoge): Hoge = Hoge(a.id + b.id, a.name + b.name)
  }

  println(Hoge(1, "aaa") |+| Hoge(100, "bbb"))
}
