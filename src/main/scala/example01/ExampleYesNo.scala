package example01

object ExampleYesNo extends App {
  trait CanTruthy[A] {// self =>
    def truthys(a: A): Boolean
  }
  object CanTruthy {
//    def apply[A](implicit ev: CanTruthy[A]): CanTruthy[A] = ev
    def truhtys[A](f: A => Boolean): CanTruthy[A] = new CanTruthy[A] {
      def truthys(a: A): Boolean = f(a)
    }
  }

  trait CanTruthyOps[A] {
    def self: A
    implicit def F: CanTruthy[A]
    final def truthy: Boolean = F.truthys(self)
  }
  object ToCanIsTruthyOps {
    implicit def toCanIsTruthyOps[A](v: A)(implicit ev: CanTruthy[A]) = new CanTruthyOps[A] {
      def self = v
      implicit def F: CanTruthy[A] = ev
    }
  }

  import ToCanIsTruthyOps._

  implicit val intCanTruthy: CanTruthy[Int] = CanTruthy.truhtys {
    case 0 => false
    case _ => true
  }

  println(10.truthy)

  implicit def listCanTruthy[A]: CanTruthy[List[A]] = CanTruthy.truhtys({
    case Nil => false
    case _ => true
  })

  println(List(1).truthy)
  val a: List[Int] = Nil
  println(a.truthy)

  implicit val boolCanTruthy: CanTruthy[Boolean] = CanTruthy.truhtys(identity)

  println(true.truthy)
}
