package com.saleass.domain.interpreter.product

import com.lamedh.common.domain.Entity

case class Product(id: Long, code: String,
                   name: String, unitPrice: BigDecimal = BigDecimal(0)) extends Entity[Long]
