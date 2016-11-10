package com.saleass.domain.algebra

import scala.util.{Success, Try}
import com.lamedh.common.pattern.Reader

trait EmployeeService[Employee, EmployeeRepository] {
  def create: Reader[EmployeeRepository, Try[Employee]]
  def count: Reader[EmployeeRepository, Try[Int]]
  def store(employee: Employee): Reader[EmployeeRepository, Try[Employee]]

  def generateCode: Reader[EmployeeRepository, Try[String]] =
    for (tc <- count) yield
      for (c <- tc) yield(s"E$c")
}
