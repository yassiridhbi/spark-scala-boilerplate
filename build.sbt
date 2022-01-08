name := Build.Name
version := Build.Version
organization := Build.Organization

lazy val root = (project in file("."))
    .settings(Common.settings: _*)
    .settings(libraryDependencies ++= Dependencies.libraryDependencies)
