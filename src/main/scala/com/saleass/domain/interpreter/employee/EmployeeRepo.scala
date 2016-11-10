package com.saleass.domain.interpreter.employee

import com.lamedh.common.domain.Repository

import scala.util.Try

trait EmployeeRepo extends Repository[Employee, Long] {
  def byCode(code: String): Try[Employee]
  def nameLike(pattern: String): Try[Seq[Employee]]
}
