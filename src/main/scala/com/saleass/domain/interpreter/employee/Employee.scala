package com.saleass.domain.interpreter.employee

import com.lamedh.common.pattern.Lens
import com.lamedh.common.domain.Entity

case class Employee(id: Long, code: String, name: String,
                    address: Address = Address("", "", "", "", "")) extends Entity[Long]

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
