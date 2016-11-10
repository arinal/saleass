package com.lamedh.common.infra.repo

import com.lamedh.common.domain.{Entity, Repository}

import scala.collection.mutable
import scala.util.Success

trait MemoryRepo[E <: Entity[Long]] extends Repository[E, Long] {
  lazy val map = mutable.Map.empty[Long, E]

  override def count = Success(map.size)
  override def byId(id: Long) = Success(map.get(id))

  override def store(entity: E) = {
    map += (entity.id -> entity)
    Success(entity)
  }
}
