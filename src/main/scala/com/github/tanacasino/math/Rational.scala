package com.github.tanacasino.math

/**
 * Created by shinsuke.sugaya on 2014/12/05.
 */
case class Rational(n: Int, d: Int) {
  def +(that: Rational): Rational = {
    require(this.d == that.d) // TODO
    Rational(this.n + that.n, this.d)
  }

  def <(that: Rational): Boolean = {
    that.d * this.n < this.d * that.n
  }

  def >(that: Rational): Boolean = {
    that.d * this.n > this.d * that.n
    // that<this
  }

  def <=(that: Rational): Boolean = {
    that.d * this.n <= this.d * that.n
    // (this< that)||(this==that)
  }

  def >=(that: Rational): Boolean = {
    that.d * this.n >= this.d * that.n
    // (this>that)||(this==that)
  }

}

// TODO Ordered
trait Comparable[A] {
  def <(that: A): Boolean

  def >(that: A): Boolean

  def <=(that: A): Boolean

  def >=(that: A): Boolean

}