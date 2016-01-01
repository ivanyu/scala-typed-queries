package me.ivanyu.common

import scala.language.existentials
import scala.reflect.ClassTag

case class TypedParameter(name: String,
                          classTag: ClassTag[_])
