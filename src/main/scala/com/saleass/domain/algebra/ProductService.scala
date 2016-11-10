package com.saleass.domain.algebra

import scala.util.{Success, Try}
import com.lamedh.common.pattern.Reader
import com.lamedh.common.domain.EntityService

trait ProductService[Product, ProductRepo] extends EntityService[Product, ProductRepo] {
  def generateCode: Reader[ProductRepo, Try[String]] =
    for (tc <- count) yield
    for (c <- tc) yield (s"P$c")
}
