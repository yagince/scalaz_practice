import sbt._
import Keys._

object ProjectBuild extends Build {
  lazy val root = Project(
    id = BaseSettings.buildName,
    base = file("."),
    settings = Defaults.defaultSettings 
      ++ BaseSettings.settings 
      ++ Seq(
        resolvers ++= Dependencies.resolvers,
        libraryDependencies ++= Dependencies.libraries
      )
  )
}
