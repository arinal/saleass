package com.saleass.infra.repo.memory

import com.saleass.domain.interpreter.employee.{Employee, EmployeeRepository}

import scala.util.{Failure, Success, Try}
import com.lamedh.common.domain.{Entity, Repository}
import com.lamedh.common.infra.repo.MemoryRepo

trait EmployeeMemoryRepo extends MemoryRepo[Employee] with EmployeeRepository {
  override def byCode(code: String) =
    map.values.filter(_.code.equals(code)) match {
      case Seq(e) => Success(e)
      case _ => Failure(new Exception("Not found"))
    }

  override def nameLike(pattern: String) =
    Success(map.values.filter(_.name.startsWith(pattern)).toSeq)
}

object EmployeeMemoryRepo extends EmployeeMemoryRepo
