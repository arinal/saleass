package com.saleass.domain.interpreter.product

import util.Try
import com.lamedh.common.domain.Repository

trait ProductRepository extends Repository[Product, Long] {
  def byCode(code: String): Try[Product]
  def nameLike(pattern: String): Try[Seq[Product]]
}
