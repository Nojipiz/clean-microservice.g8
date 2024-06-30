import Dependencies._

ThisBuild / scalaVersion := $if(useScala3.truthy && useLts.truthy)$ 
  "3.3.3" 
$elseif(useScala3.truthy)$
  "3.4.2" 
$else$
  "2.13.14"
$endif$

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
