package com.lamedh.common.pattern

import scala.language.{higherKinds, implicitConversions}

trait Monad[M[_]] extends Functor[M] {
  def unit[A](a: => A): M[A]

  def flatMap[A, B](ma: M[A])(f: A => M[B]): M[B] =
    join(map(ma)(f))

  def map[A, B](ma: M[A])(f: A => B): M[B] =
    flatMap(ma)(a => unit(f(a)))

  def map2[A, B, C](ma: M[A], mb: M[B])(f: (A, B) => C): M[C] =
    flatMap(ma)(a => map(mb)(b => f(a, b)))

  def sequence[A](lma: List[M[A]]): M[List[A]] =
    lma.foldRight(unit(List[A]())) { (ma, mla) => println(s"from monad $ma"); map2(ma, mla)(_ :: _) }

  def traverse[A, B](la: List[A])(f: A => M[B]): M[List[B]] =
    la.foldRight(unit(List[B]()))((a, mlb) => map2(f(a), mlb)(_ :: _))

  def join[A](mma: M[M[A]]): M[A] = flatMap(mma)(ma => ma)
}

object Monad {
  def apply[M[_] : Monad]: Monad[M] = implicitly[Monad[M]]

  implicit val optionMonad = new Monad[Option] {
    override def unit[A](a: => A) = Some(a)
    override def flatMap[A, B](ma: Option[A])(f: A => Option[B]) = ma flatMap f
  }

  implicit val listMonad = new Monad[List] {
    override def unit[A](a: => A) = List(a)
    override def flatMap[A, B](ma: List[A])(f: A => List[B]) = ma flatMap f
  }

  implicit def function1Monad[A1]: Monad[({type f[x] = (A1) => x})#f] =
    new Monad[({type f[x] = (A1) => x})#f] {
      override def unit[A](a: => A) = (_: A1) => a
      override def flatMap[A, B](r: A1 => A)(f: A => A1 => B) = (t: A1) => f(r(t))(t)
    }
}
