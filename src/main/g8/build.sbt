import Dependencies._


$if(useScala3.truthy && useLts.truthy)$ 
val globalScalaVersion = "3.3.3" 
$elseif(useScala3.truthy)$
val globalScalaVersion = "3.4.2" 
$else$
val globalScalaVersion = "2.13.14" 
$endif$

ThisBuild / scalaVersion := globalScalaVersion

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
