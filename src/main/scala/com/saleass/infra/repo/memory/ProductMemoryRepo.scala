package com.saleass.infra.repo.memory

import com.saleass.domain.interpreter.product.{Product, ProductRepository}

import scala.collection.mutable
import scala.util.{Failure, Success, Try}
import com.lamedh.common.infra.repo.MemoryRepo

trait ProductMemoryRepo extends MemoryRepo[Product] with ProductRepository {

  override def byCode(code: String) =
    map.values.filter(_.code.equals(code)) match {
      case Seq(e) => Success(e)
      case _ => Failure(new Exception("Not found"))
    }

  override def nameLike(pattern: String) =
    Success(map.values.filter(_.name.startsWith(pattern)).toSeq)
}

object ProductMemoryRepo extends ProductMemoryRepo
