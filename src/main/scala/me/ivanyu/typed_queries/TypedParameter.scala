package me.ivanyu.typed_queries

import scala.language.existentials
import scala.reflect.ClassTag

case class TypedParameter(name: String,
                          classTag: ClassTag[_])
