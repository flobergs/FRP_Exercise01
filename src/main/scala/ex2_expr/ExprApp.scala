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

    // Task 2.3
    assertEquals(Lit(10), Map(), 10.0)
    assertEquals(Var("x"), Map("x" -> 20), 20.0)
    assertEquals(Add(Lit(1), Lit(2)), Map(), 3.0)
    assertEquals(Mul(Lit(2), Lit(3)), Map(), 6.0)
    assertEquals(Neg(Lit(3)), Map(), -3.0)
    assertEquals(Recip(Lit(3)), Map(), 1.0/3)



    println("...all assertions passed.")
  }

}
