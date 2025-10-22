package ex2_expr

import ex2_expr._

object ExprApp {

  def main(args: Array[String]): Unit = {
    println("asserting exercise tasks...")


    // Task 2.1 & 2.2
    assertEquals(Lit(123), "123.0")
    assertEquals(Var("velocity"), "velocity")

    assertEquals(Add(Lit(10), Var("x")), "(10.0+x)")
    assertEquals(Mul(Lit(10), Var("x")), "(10.0*x)")
    assertEquals(Neg(Lit(10)), "(-10.0)")
    assertEquals(Recip(Lit(10)), "(1/10.0)")

    // Task 2.2(b)
    assertEquals(Lit(10), Map(), 10.0)
    assertEquals(Var("x"), Map("x" -> 20), 20.0)
    assertEquals(Add(Lit(1), Lit(2)), Map(), 3.0)
    assertEquals(Mul(Lit(2), Lit(3)), Map(), 6.0)
    assertEquals(Neg(Lit(3)), Map(), -3.0)
    assertEquals(Recip(Lit(3)), Map(), 1.0/3)

    // Task 2.3
    assertEquals(simplify(Add(Lit(1), Var("x"))), "(1.0+x)")
    assertEquals(simplify(Add(Var("x"), Lit(1))), "(x+1.0)")
    assertEquals(simplify(Add(Lit(0), Lit(2))), "2.0")
    assertEquals(simplify(Add(Lit(1), Lit(0))), "1.0")

    assertEquals(simplify(Mul(Lit(2), Var("x"))), "(2.0*x)")
    assertEquals(simplify(Mul(Var("x"), Lit(2))), "(x*2.0)")
    assertEquals(simplify(Mul(Lit(0), Lit(3))), "0.0")
    assertEquals(simplify(Mul(Lit(1), Lit(3))), "3.0")
    assertEquals(simplify(Mul(Lit(2), Lit(0))), "0.0")
    assertEquals(simplify(Mul(Lit(2), Lit(1))), "2.0")

    assertEquals(simplify(Neg(Lit(3))), "-3.0")
    assertEquals(simplify(Neg(Neg(Lit(3)))), "3.0")

    assertEquals(simplify(Recip(Lit(2))), "0.5")
    assertEquals(simplify(Recip(Recip(Lit(2)))), "2.0")


    println("...all assertions passed.")
  }

}
