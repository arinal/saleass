package com.saleass.domain.interpreter.product

import org.scalatest._
import com.saleass.infra.repo.memory.ProductMemoryRepo

class ProductServiceSpec extends FlatSpec with Matchers {

  "adding 3 products and then create new" should
  "generate 'P4' as new product code" in {
    val prodService = ProductService
    val createProd = for {
      _ <- prodService.store(Product(1, "P01", "Momogi"))
      _ <- prodService.store(Product(2, "P02", "Pepsi"))
      _ <- prodService.store(Product(3, "P03", "Ajam"))
      p <- prodService.create
    } yield p

    val p = createProd.run(ProductMemoryRepo).get
    p.code should be ("P4")
  }
}
