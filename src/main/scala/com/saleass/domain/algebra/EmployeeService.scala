package com.saleass.domain.algebra

import scala.util.Try

trait EmployeeService[Employee, EmployeeRepository] {
  def create(repo: EmployeeRepository): Try[Employee]
  def count(repo: EmployeeRepository): Try[Int]
  def store(employee: Employee, repo: EmployeeRepository): Try[Employee]

  def generateCode(repo: EmployeeRepository) = count(repo).map(c => s"E$c")
}
