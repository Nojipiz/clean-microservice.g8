import Dependencies._
import Settings._

scalaVersion := "$scala_version$"

lazy val $domainModule$ = (project in file("$domainModule$")).
  .settings(libraryDependencies ++= $domainModule$Dependencies)

lazy val $applicationModule$ = (project in file("$applicationModule$"))
  .settings(libraryDependencies ++= $applicationModule$Dependencies)
  .dependsOn($domainModule$)

lazy val $infrastructureModule$ = (project in file("$infrastructureModule$")).
  .settings(libraryDependencies ++= $infrastructureModule$Dependencies)
  .dependsOn($applicationModule$)

lazy val $appname$ = (project in file("$appname$"))
  .dependsOn($infrastructureModule$)
