package com.saleass.domain.interpreter

import com.lamedh.common._

case class Employee(id: Long, code: String, name: String, address: Address = Address("", "", "", "", ""))
case class Address(no: String, street: String, city: String, state: String, zip: String)

trait AddressLenses {
  val noLens = Lens[Address, String](
    get = _.no,
    set = (e, no) => e.copy(no = no)
  )

  val streetLens = Lens[Address, String](
    get = _.street,
    set = (e, street) => e.copy(street = street)
  )

  val cityLens = Lens[Address, String](
    get = _.city,
    set = (e, city) => e.copy(city = city)
  )

  val stateLens = Lens[Address, String](
    get = _.state,
    set = (e, state) => e.copy(state = state)
  )

  val zipLens = Lens[Address, String](
    get = _.zip,
    set = (e, zip) => e.copy(zip = zip)
  )
}

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
