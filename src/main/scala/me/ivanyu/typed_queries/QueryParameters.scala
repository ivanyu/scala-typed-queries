package me.ivanyu.typed_queries

import scala.language.higherKinds

// Type flags to mark query parameter set that is the last possible.
private[typed_queries] sealed trait FinalFlag
private[typed_queries] sealed trait NotFinal extends FinalFlag
private[typed_queries] sealed trait Final extends FinalFlag

// Empty tuple (to make it iterable as Product).
class Tuple0 extends Product {
  override def productElement(n: Int): Any =
    throw new NoSuchElementException()
  override def productArity: Int = 0
  override def canEqual(that: Any): Boolean = false

  override def toString: String = "()"
}

sealed trait QueryParameters {
  // Final flag.
  type FF <: FinalFlag

  // Parameter type that will go to the final execute method.
  type MethodParameters <: Product

  // The next QueryParameters type, used during parameter addition.
  type Next[T] <: QueryParameters
}

// 22 query parameter set

class QueryParameters0 extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = Tuple0
  override type Next[T] = QueryParameters1[T]
}

class QueryParameters1[T1] extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = Tuple1[T1]
  override type Next[T] = QueryParameters2[T1, T]
}

class QueryParameters2[T1, T2] extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = (T1, T2)
  override type Next[T] = QueryParameters3[T1, T2, T]
}

class QueryParameters3[T1, T2, T3] extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = (T1, T2, T3)
  override type Next[T] = QueryParameters4[T1, T2, T3, T]
}

class QueryParameters4[T1, T2, T3, T4] extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = (T1, T2, T3, T4)
  override type Next[T] = QueryParameters5[T1, T2, T3, T4, T]
}

class QueryParameters5[T1, T2, T3, T4, T5] extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = (T1, T2, T3, T4, T5)
  override type Next[T] = QueryParameters6[T1, T2, T3, T4, T5, T]
}

class QueryParameters6[T1, T2, T3, T4, T5, T6] extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = (T1, T2, T3, T4, T5, T6)
  override type Next[T] = QueryParameters7[T1, T2, T3, T4, T5, T6, T]
}

class QueryParameters7[T1, T2, T3, T4, T5, T6, T7] extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = (T1, T2, T3, T4, T5, T6, T7)
  override type Next[T] = QueryParameters8[T1, T2, T3, T4, T5, T6, T7, T]
}

class QueryParameters8[T1, T2, T3, T4, T5, T6, T7, T8] extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = (T1, T2, T3, T4, T5, T6, T7, T8)
  override type Next[T] = QueryParameters9[T1, T2, T3, T4, T5, T6, T7, T8, T]
}

class QueryParameters9[T1, T2, T3, T4, T5, T6, T7, T8, T9] extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = (T1, T2, T3, T4, T5, T6, T7, T8, T9)
  override type Next[T] = QueryParameters10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T]
}

class QueryParameters10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10] extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)
  override type Next[T] = QueryParameters11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T]
}

class QueryParameters11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11] extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)
  override type Next[T] = QueryParameters12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T]
}

class QueryParameters12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]
  extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)
  override type Next[T] = QueryParameters13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T]
}

class QueryParameters13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13] extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)
  override type Next[T] = QueryParameters14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T]
}

class QueryParameters14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14] extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)
  override type Next[T] = QueryParameters15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T]
}

class QueryParameters15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15] extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)
  override type Next[T] = QueryParameters16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T]
}

class QueryParameters16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16] extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)
  override type Next[T] = QueryParameters17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T]
}

class QueryParameters17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17] extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)
  override type Next[T] = QueryParameters18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T]
}

class QueryParameters18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18] extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)
  override type Next[T] = QueryParameters19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T]
}

class QueryParameters19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19] extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)
  override type Next[T] = QueryParameters20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T]
}

class QueryParameters20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20] extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)
  override type Next[T] = QueryParameters21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T]
}

class QueryParameters21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21] extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)
  override type Next[T] = QueryParameters22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T]
}

class QueryParameters22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22] extends QueryParameters {
  override type FF = NotFinal
  override type MethodParameters = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22)
  override type Next[T] = QueryParametersFinal
}

// The marker of "cannot add more parameters"
class QueryParametersFinal extends QueryParameters {
  override type FF = Final
  override type MethodParameters = Nothing
  override type Next[T] = Nothing
}
