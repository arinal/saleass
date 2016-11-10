package com.saleass.infra.repo.memory

import com.saleass.domain.interpreter.product.{Product, ProductRepository}

import scala.collection.mutable
import scala.util.{Failure, Success, Try}

trait ProductMemoryRepo extends ProductRepository {
  lazy val map = mutable.Map.empty[Long, Product]

  override def count = Success(map.size)
  override def byId(id: Long) = Success(map.get(id))

  override def byCode(code: String) =
    map.values.filter(_.code.equals(code)) match {
      case Seq(e) => Success(e)
      case _ => Failure(new Exception("Not found"))
    }

  override def nameLike(pattern: String) =
    Success(map.values.filter(_.name.startsWith(pattern)).toSeq)

  override def store(entity: Product) = {
    map += (entity.id -> entity)
    Success(entity)
  }
}

object ProductMemoryRepo extends ProductMemoryRepo
