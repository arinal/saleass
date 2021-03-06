package com.saleass.domain.interpreter.employee

import com.lamedh.common.pattern.Reader
import com.saleass.domain.algebra.EmployeeService

object EmployeeService extends EmployeeService[Employee, EmployeeRepo] {
  override def count = Reader(repo => repo.count)
  override def store(employee: Employee) = Reader(repo => repo.store(employee))

  override def create = for (tc <- generateCode)
    yield for (c <- tc)
      yield Employee(id = 0, code = c, name = "")
}
