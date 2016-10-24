package com.lamedh.common

import util.Try

trait Repository[Entity, Id] {
  def byId(id: Id): Try[Option[Entity]]
  def store(entity: Entity): Try[Entity]
}
