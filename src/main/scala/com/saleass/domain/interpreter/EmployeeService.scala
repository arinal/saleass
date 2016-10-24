package com.saleass.domain.interpreter

import com.saleass.domain.algebra.EmployeeService
import scala.util.Try

object EmployeeService extends EmployeeService[Employee, EmployeeRepository] {
  def count(repo: EmployeeRepository): Try[Int] = repo.count
  def store(employee: Employee, repo: EmployeeRepository): Try[Employee] = repo.store(employee)
  def create(repo: EmployeeRepository): Try[Employee] =
    for (code <- generateCode(repo))
      yield Employee(0, code, "")
}
