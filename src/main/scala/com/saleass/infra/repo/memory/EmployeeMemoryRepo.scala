package com.saleass.infra.repo.memory

import com.lamedh.common.infra.repo.MemoryRepo
import com.saleass.domain.interpreter.employee.{Employee, EmployeeRepo}

import scala.util.{Failure, Success}

trait EmployeeMemoryRepo extends MemoryRepo[Employee] with EmployeeRepo {
  override def byCode(code: String) =
    map.values.filter(_.code == code) match {
      case Seq(e) => Success(e)
      case _ => Failure(new Exception("Not found"))
    }

  override def nameLike(pattern: String) =
    Success(map.values.filter(_.name.startsWith(pattern)).toSeq)
}

object EmployeeMemoryRepo extends EmployeeMemoryRepo
