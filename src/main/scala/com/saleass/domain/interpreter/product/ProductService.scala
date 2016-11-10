package com.saleass.domain.interpreter.product

import com.lamedh.common.pattern.Reader
import com.saleass.domain.algebra.ProductService

object ProductService extends ProductService[Product, ProductRepo] {
  override def count = Reader(repo => repo.count)
  override def store(product: Product) = Reader(repo => repo.store(product))
  override def create = for (tc <- generateCode)
                        yield tc.map(c => Product(id = 0, code = c, name = ""))
}
