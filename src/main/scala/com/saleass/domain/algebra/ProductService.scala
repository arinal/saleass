package com.saleass.domain.algebra

import com.lamedh.common.domain.EntityService
import com.lamedh.common.pattern.Reader

import scala.util.Try

trait ProductService[Product, ProductRepo] extends EntityService[Product, ProductRepo] {
  def generateCode: Reader[ProductRepo, Try[String]] =
    for (tc <- count) yield
      for (c <- tc) yield s"P${c + 1}"
}
