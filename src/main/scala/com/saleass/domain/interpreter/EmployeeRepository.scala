package com.saleass.domain.interpreter

import com.lamedh.common.Repository

import scala.util.Try

trait EmployeeRepository extends Repository[Employee, Long] {
  def byCode(code: String): Try[Employee]
  def nameLike(pattern: String): Try[Seq[Employee]]
}
