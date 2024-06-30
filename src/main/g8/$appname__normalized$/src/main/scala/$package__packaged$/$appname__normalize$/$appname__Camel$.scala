package $package$.$appname;format="word"$

import $package$.$applicationModule;format="word"$
import $package$.$domainModule;format="word"$

$if(useScala3.truthy)$
@main 
def run(): Unit = {
  println("Hello, Scala developer!")
}
$else$
object Main {
  def main(args: Array[String]): Unit =
    println("Hello, Scala developer!")
}
$endif$


