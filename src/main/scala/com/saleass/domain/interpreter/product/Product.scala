package com.saleass.domain.interpreter.product

import util.Try
import com.lamedh.common.Repository
import com.lamedh.common.pattern.Reader
import com.saleass.domain.algebra.ProductService

case class Product(id: Long, code: String, name: String, unitPrice: BigDecimal = BigDecimal(0))

trait ProductRepository extends Repository[Product, Long] {
  def byCode(code: String): Try[Product]
  def nameLike(pattern: String): Try[Seq[Product]]
}

object ProductService extends ProductService[Product, ProductRepository] {
  override def count = Reader(repo => repo.count)
  override def store(product: Product) = Reader(repo => repo.store(product))
  override def create = for (tc <- generateCode)
                        yield tc.map(c => Product(id = 0, code = c, name = ""))
}
