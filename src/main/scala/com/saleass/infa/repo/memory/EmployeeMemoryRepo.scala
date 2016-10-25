package com.saleass.infa.repo.memory

import com.saleass.domain.interpreter.{Employee, EmployeeRepository}

import scala.collection.mutable
import scala.util.{Failure, Success, Try}

trait EmployeeMemoryRepo extends EmployeeRepository {
  lazy val map = mutable.Map.empty[Long, Employee]

  override def count = Success(map.size)
  override def byId(id: Long) = Success(map.get(id))

  override def byCode(code: String) =
    map.values.filter(_.code.equals(code)) match {
      case Seq(e) => Success(e)
      case _ => Failure(new Exception("Not found"))
    }

  override def nameLike(pattern: String) =
    Success(map.values.filter(_.name.startsWith(pattern)).toSeq)

  override def store(entity: Employee) = {
    map += (entity.id -> entity)
    Success(entity)
  }
}

object EmployeeMemoryRepo extends EmployeeMemoryRepo
