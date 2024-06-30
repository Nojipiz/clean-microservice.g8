import sbt._
import Keys._

object Dependencies {

  $if(includeStack == "zio")$
  lazy val ZIOVersion = "2.1.5"
  lazy val ZIOLoggingVersion = "2.3.0"
  lazy val ZIOJsonVersion = "0.7.1"
  lazy val ZIOHttpVersion = "3.0.0-RC9"
  lazy val includedStack = Seq(
    "dev.zio" %% "zio" % ZIOVersion,
    "dev.zio" %% "zio-test" % ZIOVersion % Test, 
    "dev.zio" %% "zio-logging" % ZIOLoggingVersion,
    "dev.zio" %% "zio-streams" % ZIOVersion,
    "dev.zio" %% "zio-json" % ZIOJsonVersion,
    "dev.zio" %% "zio-http" % ZIOHttpVersion
  )
  $elseif(includeStack == "akka")$
    /*TODO Akka*/
  $elseif(includeStack == "pekko")$
    /*TODO Pekko*/
  $endif$
  

  /*
   * Your domain dependencies will be available for the infrastructure and application modules
   */
  val $domainModule$Dependencies: Seq[ModuleID] = Seq(
    $if(includeOpinionatedLibraries.truthy && useScala3.truthy)$
      "io.github.iltotore" %% "iron" % "2.6.0", // Refined Types
      "io.github.arainko" %% "ducktape" % "0.2.2" // Data transformation
    $elseif(includeOpinionatedLibraries.truthy)$
      "eu.timepit" %% "refined" % "0.11.2", // Refined Types 
      "io.scalaland" %% "chimney" % "1.2.0" // Data transformation
    $endif$
  )

  val $applicationModule$Dependencies: Seq[ModuleID] = Seq(
  ) ++ includedStack

  val $infrastructureModule$Dependencies: Seq[ModuleID] = Seq(
    $if(includeOpinionatedLibraries.truthy && useScala3.truthy)$
      "io.getquill" %% "quill-jdbc" % "4.8.5", // SQL DSL
    $elseif(includeOpinionatedLibraries.truthy)$
      "com.typesafe.slick" %% "slick" % "3.5.1", // SQL DSL
      "com.typesafe.slick" %% "slick-hikaricp" % "3.5.1"
    $endif$
  )

  val $appname$Dependencies: Seq[ModuleID] = Seq(
  )
}
