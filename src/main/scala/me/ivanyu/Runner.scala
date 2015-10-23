package me.ivanyu

object Runner extends App {
  import me.ivanyu.typed_queries._

  // Better, to remove deprecation warning: execute(())
  beginQuery()
    .build()
    .execute()

  beginQuery()
    .addParameter[String]("param1")
    .build()
    .execute("'some string'")

  beginQuery()
    .addParameter[String]("param1")
    .addParameter[Int]("param2")
    .build()
    .execute("'some string'", 1)

  beginQuery()
    .addParameter[String]("param1")
    .addParameter[Int]("param2")
    .addParameter[Boolean]("param3")
    .build()
    .execute("'some string'", 1, false)


  // Won't work due to one implicit conversion (to tuple) is already done :(
  case class A()
  case class B()
  import scala.language.implicitConversions
  implicit def A2B(a: A): B = B()
  beginQuery()
    .addParameter[B]("long param")
    .build()
//    .execute(A())
}
