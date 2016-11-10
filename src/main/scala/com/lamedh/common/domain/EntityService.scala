package com.lamedh.common.domain

import com.lamedh.common.pattern.Reader

import scala.util.Try

trait EntityService[Entity, Repository] {
  def count: Reader[Repository, Try[Int]]
  def create: Reader[Repository, Try[Entity]]
  def store(entity: Entity): Reader[Repository, Try[Entity]]
}
