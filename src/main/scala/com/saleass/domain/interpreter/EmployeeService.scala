package com.saleass.domain.interpreter

import com.saleass.domain.algebra.EmployeeService
import scala.util.Try

object EmployeeService extends EmployeeService[Employee, EmployeeRepository] {
  override def count = (repo) => repo.count
  override def store(employee: Employee) = repo => repo.store(employee)
  override def create = (repo) => for (code <- generateCode(repo))
                                  yield Employee(0, code, "")
}
