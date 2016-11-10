package com.lamedh.common.pattern

import scala.language.{higherKinds, reflectiveCalls}

trait Functor[M[_]] {
  def map[A, B](ma: M[A])(f: A => B): M[B]
}

object Functor {
  def apply[M[_]: Functor]: Functor[M] = implicitly[Functor[M]]

  implicit def ListFunctor: Functor[List] =
    new Functor[List] {
      def map[A, B](ma: List[A])(f: (A) => B): List[B] = ma map f
    }

  implicit def Tuple2Functor[A1]: Functor[({type f[x] = (A1, x)})#f] =
    new Functor[({type f[x] = (A1, x)})#f] {
      def map[A, B](a: (A1, A))(f: A => B): (A1, B) = (a._1, f(a._2))
    }

  implicit def Function1Functor[A1]: Functor[({type f[x] = (A1) => x})#f] =
    new Functor[({type f[x] = (A1) => x})#f] {
      def map[A, B](ma: A1 => A)(f: A => B) = ma andThen f
    }
}
