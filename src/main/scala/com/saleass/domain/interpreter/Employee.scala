package com.saleass.domain.interpreter

import com.lamedh.common._

case class Employee(id: Long, code: String, name: String,
                    address: Address = Address("", "", "", "", ""))

trait EmployeeLenses {
  val codeLens = Lens[Employee, String](
    get = _.code,
    set = (e, code) => e.copy(code = code)
  )

  val addressLens = Lens[Employee, Address](
    get = _.address,
    set = (e, a) => e.copy(address = a)
  )
}
