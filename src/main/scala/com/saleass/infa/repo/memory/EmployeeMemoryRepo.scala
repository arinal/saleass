package com.saleass.infa.repo.memory

import com.saleass.domain.interpreter.{Employee, EmployeeRepository}

import scala.collection.mutable
import scala.util.{Failure, Success, Try}

trait EmployeeMemoryRepo extends EmployeeRepository {
  lazy val map = mutable.Map.empty[Long, Employee]

  def count = Success(map.size)
  def byId(id: Long) = Success(map.get(id))

  def byCode(code: String): Try[Employee] =
    map.values.filter(_.code.equals(code)) match {
      case Seq(e) => Success(e)
      case _ => Failure(new Exception("Not found"))
    }

  def nameLike(pattern: String): Try[Seq[Employee]] =
    Success(map.values.filter(_.name.startsWith(pattern)).toSeq)

  def store(entity: Employee): Try[Employee] = {
    map += (entity.id -> entity)
    Success(entity)
  }
}

object EmployeeMemoryRepo extends EmployeeMemoryRepo
