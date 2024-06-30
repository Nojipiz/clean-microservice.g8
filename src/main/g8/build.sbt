import Dependencies._

ThisBuild / scalaVersion := "$scala_version$"

lazy val $domainModule$ = project.in(file("core/$domainModule$"))
  .settings(libraryDependencies ++= $domainModule$Dependencies)

lazy val $applicationModule$ = project.in(file("core/$applicationModule$"))
  .settings(libraryDependencies ++= $applicationModule$Dependencies)
  .dependsOn($domainModule$)

lazy val $infrastructureModule$ = project.in(file("core/$infrastructureModule$"))
  .settings(libraryDependencies ++= $infrastructureModule$Dependencies)
  .dependsOn($applicationModule$)

lazy val $appname$ = (project in file("$appname$"))
  .dependsOn($infrastructureModule$)
