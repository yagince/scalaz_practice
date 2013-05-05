import sbt._
import Keys._

object BaseSettings {
  val buildName = "ScalazPractice"
  val buildOrg  = "yagince"
  val buildVersion = "0.0.1"
  val buildScalaVersion = "2.10.1"

  val settings = Seq(
    name := buildName,
    organization := buildOrg,
    version := buildVersion,
    scalaVersion := buildScalaVersion
  )
}
