package com.saleass.infra.repo.memory

import com.lamedh.common.infra.repo.MemoryRepo
import com.saleass.domain.interpreter.product.{Product, ProductRepo}

import scala.util.{Failure, Success}

trait ProductMemoryRepo extends MemoryRepo[Product] with ProductRepo {

  override def byCode(code: String) =
    map.values.filter(_.code == code) match {
      case Seq(e) => Success(e)
      case _ => Failure(new Exception("Not found"))
    }

  override def nameLike(pattern: String) =
    Success(map.values.filter(_.name.startsWith(pattern)).toSeq)
}

object ProductMemoryRepo extends ProductMemoryRepo
