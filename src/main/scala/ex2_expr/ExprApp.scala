package ex2_expr

import ex2_expr._

object ExprApp {

  def main(args: Array[String]): Unit = {
    println ("Hello World")
    //val e1 = Add(Lit(1), Min(Var("x")))
    //println(infix(e1))




    println("asserting exercise tasks...")


    // Task 2.1 & 2.2
    assertEquals(Lit(123), "123.0")
    assertEquals(Var("velocity"), "velocity")

    assertEquals(Add(Lit(10), Var("x")), "(10.0+x)")
    assertEquals(Mul(Lit(10), Var("x")), "(10.0*x)")
    assertEquals(Neg(Lit(10)), "(-10.0)")
    assertEquals(Recip(Lit(10)), "(1/10.0)")

    // Task 2.3
    // TODO


    println("...all assertions passed.")
  }

}
