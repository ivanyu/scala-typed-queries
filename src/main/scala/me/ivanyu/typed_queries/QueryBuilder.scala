package me.ivanyu.typed_queries

import me.ivanyu.common.{Query, TypedParameter}

import scala.reflect.ClassTag

class QueryBuilder[P <: QueryParameters] private(parameters: Seq[TypedParameter]) {
  final def addParameter[T : ClassTag](name: String)
                                      (implicit ev: P#Next[T]#FF =:= NotFinal): QueryBuilder[P#Next[T]] = {
    val classTag = implicitly[ClassTag[T]]
    val param = TypedParameter(name, classTag)
    new QueryBuilder[P#Next[T]](parameters :+ param)
  }

  final def build(): Query[P#MethodParameters] = {
    new Query[P#MethodParameters](parameters)
  }
}

object QueryBuilder {
  final def begin(): QueryBuilder[QueryParameters0] = {
    new QueryBuilder[QueryParameters0](Nil)
  }
}
