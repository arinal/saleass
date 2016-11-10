package com.saleass.domain.interpreter.product

import com.lamedh.common.domain.Repository

import scala.util.Try

trait ProductRepo extends Repository[Product, Long] {
  def byCode(code: String): Try[Product]
  def nameLike(pattern: String): Try[Seq[Product]]
}
