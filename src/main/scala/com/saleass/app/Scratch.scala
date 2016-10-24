package com.saleass.app

import com.saleass.domain.interpreter._
import com.saleass.infa.repo.memory.EmployeeMemoryRepo

object Scratch extends App {

  val service = EmployeeService
  val newEmployee = for {
    _ <- service.store(Employee(1, "E01", "Michael Suyama"), EmployeeMemoryRepo)
    _ <- service.store(Employee(2, "E02", "Nancy DaVolio"), EmployeeMemoryRepo)
    _ <- service.store(Employee(3, "E03", "David Buchanan"), EmployeeMemoryRepo)
    e <- service.create(EmployeeMemoryRepo)
  } yield e

  println(newEmployee)

}