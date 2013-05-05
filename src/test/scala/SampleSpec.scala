import org.specs2.mutable.Specification

class SampleSpec extends Specification {
  "Sample" should {
    "#test" >> {
      new Sample().test must_== "test"
    }
  }
}
