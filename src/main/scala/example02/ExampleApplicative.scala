package example02
import scalaz._
import Scalaz._

object ExampleApplicative extends App {
  /* 2引数関数で写す場合 */
  val list = List(1,2,3,4)
  println( (list map { (_: Int) * (_: Int) }.curried).map{_(3)} )

  /* Let's Applicative!! */
  println(1.point[List])
  println(1.point[Option])
  println(1.point[List].map(_+1))
  println(1.point[Option].map(_*2))

  /* 関数の入っているファンクター値と値の入っているファンクター値を引数に取って
   * 一つ目もファンクター値の関数を2つ目のファンクター値の中身の値に適用する */
  println( 9.some <*> {(_:Int) * 3}.some )

  def double(i:Int) = i * 2

  val i = (1.some <*> (double _).some)
  println(i)
  val value: Option[Int] = None
  println(value <*> (double _).some)

  /* Applicative Style
   * Haskellとは違う？？ */
  println(^(3.some, 5.some){ _ * _ }) // ファンクター値の数に応じて^が付く
  println(^^(3.some, 5.some, 10.some){ _ * _ + _})
  println(^^^(3.some, 5.some, 3.some, 5.some){ _ * _ + _ * _})
  // ↓これを簡単に書けるイメージで良いのかな？
  val forValue =
    for{
      x <- 3.some
      y <- 5.some
    } yield { x * y }
  println(forValue)

  /* List */
  println(list <*> List((_:Int) * 2, (_:Int) * 10, (x:Int)=> x * x))
  println( (List("1","2","3") |@| List ("hoge", "foo", "bar", "baz")){ _ + _ } )

  /* sequenceA */
  // List(F[A], F[A]) -> F[List[A]]
  def sequenceA[F[_]: Applicative, A](list: List[F[A]]): F[List[A]] = list match {
    case Nil => (Nil: List[A]).pure[F]
    case x :: xs => (x |@| sequenceA(xs)){_ :: _}
  }

  println( sequenceA(List(1.some, 5.some)) )
  println( sequenceA(List(1.some, none, 5.some)) )
  println( sequenceA(List(List(1,2,3), List(4,5,6))) )
}
