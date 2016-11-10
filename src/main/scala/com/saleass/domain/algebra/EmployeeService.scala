package com.saleass.domain.algebra

import com.lamedh.common.domain.EntityService
import com.lamedh.common.pattern.Reader

import scala.util.Try

trait EmployeeService[Employee, EmployeeRepo] extends EntityService[Employee, EmployeeRepo] {
  def generateCode: Reader[EmployeeRepo, Try[String]] =
    for (tc <- count) yield
      for (c <- tc) yield s"E$c"
}
