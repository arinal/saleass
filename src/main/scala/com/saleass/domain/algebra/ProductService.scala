package com.saleass.domain.algebra

import com.lamedh.common.pattern.Reader
import scala.util.{Success, Try}

trait ProductService[Product, ProductRepository] {
  def create: Reader[ProductRepository, Try[Product]]
  def count: Reader[ProductRepository, Try[Int]]
  def store(product: Product): Reader[ProductRepository, Try[Product]]

  def generateCode: Reader[ProductRepository, Try[String]] =
    for (tc <- count) yield
      for (c <- tc) yield (s"P$c")
}
