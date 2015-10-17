package me.ivanyu

import scala.language.implicitConversions

package object typed_queries {
  val beginQuery = QueryBuilder.begin _

  // Implicit conversions to make execute() and execute(value) more convenient.
  implicit def unitToTuple0(u: Unit): Tuple0 = new Tuple0
  implicit def valueToTuple1[T](v: T): Tuple1[T] = Tuple1(v)
}
