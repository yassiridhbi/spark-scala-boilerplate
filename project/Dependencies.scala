import sbt._

object Versions {
  val ScalaLogging = "3.9.4"
  val Scopt = "4.0.1"
  val Spark = "3.1.2"

  // Testing
  val ScalaTest = "3.2.9"
}

object Dependencies {

  val testDependencies: Seq[ModuleID] = Seq(
    "org.scalatest" %% "scalatest" % Versions.ScalaTest
  ).map(_ % Test)

  val libraryDependencies: Seq[ModuleID] = testDependencies ++ Seq(
    "org.apache.spark" %% "spark-core" % Versions.Spark % Provided,
    "org.apache.spark" %% "spark-sql"  % Versions.Spark % Provided,
    "org.apache.spark" %% "spark-streaming" % Versions.Spark % Provided,
    "com.github.scopt" %% "scopt"      % Versions.Scopt,
    "com.typesafe.scala-logging" %% "scala-logging" % Versions.ScalaLogging
  )
}
