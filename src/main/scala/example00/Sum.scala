package example00

import example00.Sum.Monoid.IntMonoid

object Sum extends App {

  val nums = List(1,2,2,3,4,5,5)

  def sum(xs: List[Int]): Int = xs.foldLeft(0){ _ + _ }

  println(sum(nums))

  trait Monoid[A] {
    def mappend(a: A, b: A): A
    def mzero: A
  }

  object Monoid {
    implicit object IntMonoid extends Monoid[Int] {
      def mappend(a: Int, b: Int): Int = a + b
      def mzero: Int = 0
    }
    implicit object StringMonoid extends Monoid[String] {
      def mzero: String = ""
      def mappend(a: String, b: String): String = a + b
    }
  }

  def sumMonoid(xs: List[Int]): Int = xs.foldLeft(IntMonoid.mzero)(IntMonoid.mappend)

  println(sumMonoid(nums))

  def sumMonoid2(xs: List[Int])(implicit m: Monoid[Int]): Int = xs.foldLeft(m.mzero)(m.mappend)

  println(sumMonoid2(nums))

  def sumGeneral[A: Monoid](xs: List[A]): A = {
    val m = implicitly[Monoid[A]]
    xs.foldLeft(m.mzero)(m.mappend)
  }

  println(sumGeneral(List("a","b","hoge")))

}
