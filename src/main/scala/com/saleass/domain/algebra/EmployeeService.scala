package com.saleass.domain.algebra

import scala.util.Try

trait EmployeeService[Employee, EmployeeRepository] {
  def create: EmployeeRepository => Try[Employee]
  def count : EmployeeRepository => Try[Int]
  def store(employee: Employee): EmployeeRepository => Try[Employee]

  def generateCode: EmployeeRepository => Try[String] =
    (repo) => count(repo).map(c => s"E$c")
}
