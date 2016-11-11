package com.saleass.app

import com.saleass.domain.interpreter.employee.{Employee, EmployeeService}
import com.saleass.domain.interpreter.product.{Product, ProductService}
import com.saleass.infra.repo.memory.{EmployeeMemoryRepo, ProductMemoryRepo}

object Scratch extends App {

  val empService = EmployeeService
  val createEmp = for {
    _ <- empService.store(Employee(1, "E01", "Michael Suyama"))
    _ <- empService.store(Employee(2, "E02", "Nancy DaVolio"))
    _ <- empService.store(Employee(3, "E03", "David Buchanan"))
    e <- empService.create
  } yield e

  val prodService = ProductService
  val createProd = for {
    _ <- prodService.store(Product(1, "P01", "Momogi"))
    _ <- prodService.store(Product(2, "P02", "Pepsi"))
    _ <- prodService.store(Product(3, "P03", "Ajam"))
    p <- prodService.create
  } yield p

  for {
    e <- createEmp.run(EmployeeMemoryRepo)
    p <- createProd.run(ProductMemoryRepo)
  } {
    println(e)
    println(p)
  }
}
