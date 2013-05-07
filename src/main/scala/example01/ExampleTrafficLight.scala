package example01

import scalaz._
import Scalaz._

object ExampleTrafficLight extends App {

//  sealed trait TrafficLight
//  object Red extends TrafficLight
//  object Yellow extends TrafficLight
//  object Green extends TrafficLight
  case class TrafficLight(name: String)
  val red = TrafficLight("red")
  val yellow = TrafficLight("yellow")
  val green = TrafficLight("green")

  implicit val TrafficLightEqual: Equal[TrafficLight] = Equal.equal(_ == _)

//  Red === Yellow
//  red === yellow
}
