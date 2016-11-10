package com.saleass.domain.algebra

import scala.util.{Success, Try}
import com.lamedh.common.pattern.Reader
import com.lamedh.common.domain.EntityService

trait EmployeeService[Employee, EmployeeRepo] extends EntityService[Employee, EmployeeRepo] {
  def generateCode: Reader[EmployeeRepo, Try[String]] =
    for (tc <- count) yield
    for (c <- tc) yield(s"E$c")
}
