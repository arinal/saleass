package com.lamedh.common.domain

import util.Try

trait Repository[Entity, Id] {
  def count: Try[Int]
  def byId(id: Id): Try[Option[Entity]]
  def store(entity: Entity): Try[Entity]
}
