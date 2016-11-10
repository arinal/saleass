package com.lamedh.common.domain

import scala.util.{Success, Try}
import com.lamedh.common.pattern.Reader

trait EntityService[Entity, Repository] {
  def count: Reader[Repository, Try[Int]]
  def create: Reader[Repository, Try[Entity]]
  def store(entity: Entity): Reader[Repository, Try[Entity]]
}
