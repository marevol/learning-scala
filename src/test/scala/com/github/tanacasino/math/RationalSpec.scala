package com.github.tanacasino.math

import org.scalatest.{FunSpec, Matchers}

/**
 * Created by shinsuke.sugaya on 2014/12/05.
 */
class RationalSpec extends FunSpec with Matchers {
  describe("Rational") {
    it("should returns new rational") {
      val x = Rational(1, 3)
      val y = Rational(1, 2)
//      println(x, y)
//      x + y should be(Rational(2, 3))
      println(x < y)
      println(x > y)
      println(x <= y)
      println(x >= y)
    }
  }
}
