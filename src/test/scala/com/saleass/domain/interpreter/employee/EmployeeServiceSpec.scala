package com.saleass.domain.interpreter.employee

import org.scalatest._
import com.saleass.infra.repo.memory.EmployeeMemoryRepo

class EmployeeServiceSpec extends FlatSpec with Matchers {

  "adding 3 employees and then create new" should "generate 'E4' as new employee code" in {
    val empService = EmployeeService
    val createEmp = for {
      _ <- empService.store(Employee(1, "E01", "Michael Suyama"))
      _ <- empService.store(Employee(2, "E02", "Nancy DaVolio"))
      _ <- empService.store(Employee(3, "E03", "David Buchanan"))
      e <- empService.create
    } yield e

    val e = createEmp.run(EmployeeMemoryRepo).get
    e.code should be ("E4")
  }
}
