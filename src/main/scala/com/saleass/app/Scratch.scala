package com.saleass.app

import com.saleass.domain.interpreter._
import com.saleass.infra.repo.memory.EmployeeMemoryRepo

object Scratch extends App {

  val service = EmployeeService
  val createNew = for {
    _ <- service.store(Employee(1, "E01", "Michael Suyama"))
    _ <- service.store(Employee(2, "E02", "Nancy DaVolio"))
    _ <- service.store(Employee(3, "E03", "David Buchanan"))
    e <- service.create
  } yield e

  val employee = createNew.run(EmployeeMemoryRepo)
  println(employee)
}
