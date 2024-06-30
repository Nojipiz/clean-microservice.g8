import sbt._
import Keys._

object Dependencies {

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
  ) 

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
