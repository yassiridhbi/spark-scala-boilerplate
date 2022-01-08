import org.scalastyle.sbt.ScalastylePlugin.autoImport._
import sbt.Keys._
import sbt._
import sbtassembly.AssemblyKeys._
import sbtassembly.{MergeStrategy, PathList}

object Common {

  lazy val settings: Seq[Def.Setting[_]] = Seq(
    scalaVersion := "2.12.12",
    // Assembly
    assembly / test := {},
    assemblyJarName := Build.Name + ".jar",
    assembly / mainClass := Some("com.boilerplate.MainApp"),
    assembly / assemblyMergeStrategy := {
      case "module-info.class" => MergeStrategy.discard
      case PathList(
      "org",
      "apache",
      "spark",
      "unused",
      "UnusedStubClass.class"
      ) =>
        MergeStrategy.first

      case x =>
        val oldStrategy = (assembly / assemblyMergeStrategy).value
        oldStrategy(x)
    },
    // ScalaStyle
    scalastyleFailOnWarning := false,
    scalastyleFailOnError := true,
    scalastyleConfig := file("scalastyle_config.xml"),
    compileScalastyle := (Compile / scalastyle).toTask("").value,
    Compile / compile := ((Compile / compile) dependsOn compileScalastyle).value,
    Test / scalastyleFailOnError := true,
    Test / scalastyleFailOnWarning := true,
    Test / scalastyleConfig := file("scalastyle_config.xml"),
    testScalaStyle := (Test / scalastyle).toTask("").value,
    Test / test := ((Test / test) dependsOn testScalaStyle).value
  )

  lazy val compileScalastyle = taskKey[Unit]("compileScalastyle")
  lazy val testScalaStyle = taskKey[Unit]("testScalastyle")
}
