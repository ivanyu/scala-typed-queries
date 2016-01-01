package me.ivanyu.common

class Query[P <: Product] (parameters: Seq[TypedParameter]) {
  def execute(parameterValues: P): Unit = {
    val zipped = parameters zip parameterValues.productIterator.toList
    println(s"Much magic: $zipped")
    // Your code
  }
}
