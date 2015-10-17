package me.ivanyu.typed_queries

class Query[P <: QueryParameters] private[typed_queries](parameters: Seq[TypedParameter]) {
  def execute(parameterValues: P#MethodParameters): Unit = {
    val zipped = parameters zip parameterValues.productIterator.toList
    println(s"Much magic: $zipped")
    // Your code
  }
}
