package me.ivanyu.common

// Empty tuple (to make it iterable as Product).
class Tuple0 extends Product {
  override def productElement(n: Int): Any =
    throw new NoSuchElementException()
  override def productArity: Int = 0
  override def canEqual(that: Any): Boolean = false

  override def toString: String = "()"
}
