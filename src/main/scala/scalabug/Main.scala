package scalabug

import scala.collection.immutable

object Main {

  def main(args: Array[String]) {

    val scalaVersion = util.Properties.versionString

    println("\n")
    println(scalaVersion)

    val map = immutable.HashMap(1 -> 1, 2 -> 2)

    val set = Set(3, 4)

    map ++ set.view
      .map { i =>
        try {
          println(s"  index: $i")
          Some(i -> i)
        } catch {
          case _: Exception =>
            None
        }
      }
      .collect { case Some(s) =>
        s
      }

    println("\n")
  }

}
