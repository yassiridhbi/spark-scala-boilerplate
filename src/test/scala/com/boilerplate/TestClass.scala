package com.boilerplate

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class TestClass extends AnyFlatSpec with should.Matchers {

  "test" should "pass" in {
    assert(true)
  }

}
