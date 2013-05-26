package example02

import scalaz._
import Scalaz._

object ExampleFunctor extends App {
  /* Tuple Functor */
  println((1,2,3,4) map {_ * 2}) // => (1,2,3,8)

  /* Function Functor */
  val f = (i: Int) => i + 1
  println(f.map(_ * 7)(3))

  /*
  mapをliftした
  List(1,2,3).map(_*2)
  の(_*2)を先に与えて、Functorを受け取って、Functorを返す関数にした
   */
  println(Functor[List].lift{(_:Int) * 2}(List(1,2,3)))

  val list = List(1,2,3)
  println( list >| "x" )
  println( list as "x" ) // >|と同じ

  println( list.fpair  )
  println( list.strengthL("left") )
  println( list.strengthR("right") )
  println( list.void )

}
