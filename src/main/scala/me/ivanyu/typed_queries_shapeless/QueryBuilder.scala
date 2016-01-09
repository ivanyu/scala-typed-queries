package me.ivanyu.typed_queries_shapeless

import me.ivanyu.common.{Query, TypedParameter, Tuple0}
import shapeless.ops.hlist.{Reverse, Tupler}
import shapeless.{HList, HNil, ::}

import scala.reflect.ClassTag

class QueryBuilder[L <: HList] private(parameters: Seq[TypedParameter]) {

  import QueryBuilder._

  final def addParameter[T : ClassTag](name: String): QueryBuilder[T :: L] = {
    val classTag = implicitly[ClassTag[T]]
    val param = TypedParameter(name, classTag)
    new QueryBuilder[T :: L](param +: parameters)
  }

  final def build[P <: Product]()(implicit aux: Aux[L, P]): Query[P] = {
    new Query[P](parameters.reverse)
  }
}

object QueryBuilder {
  // About Aux: http://gigiigig.github.io/posts/2015/09/13/aux-pattern.html
  sealed trait Aux[L <: HList, Out0]

  implicit def implicitAux0 = new Aux[HNil, Tuple0] {}
  implicit def implicitAux[L <: HList, RL <: HList, P <: Product]
    (implicit reverse: Reverse.Aux[L, RL],
     tupler: Tupler.Aux[RL, P]) = new Aux[L, P] {}

  final def begin(): QueryBuilder[HNil] = {
    new QueryBuilder[HNil](Nil)
  }
}
