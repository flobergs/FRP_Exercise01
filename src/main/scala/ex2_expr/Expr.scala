package ex2_expr

sealed trait Expr
case class Lit(value: Double) extends Expr {

  override def toString: String = value.toString

//  // bonus
//  override def toString: String = {
//    val label = value.toString
//
//    if (label.endsWith(".0")) label.substring(0, label.length-".0".length)
//    else label
//  }
}
case class Var(name: String) extends Expr {
  override def toString: String = name
}

sealed trait BinExpr(left: Expr, right: Expr) extends Expr
case class Add(l: Expr, r: Expr) extends BinExpr(l, r) {
  override def toString: String = s"($l+$r)"
}
case class Mul(l: Expr, r: Expr) extends BinExpr(l, r) {
  override def toString: String = s"($l*$r)"
}

sealed trait UnyExpr(sub: Expr) extends Expr
case class Neg(s: Expr) extends UnyExpr(s) {
  override def toString: String = s"(-$s)"
}
case class Recip(s: Expr) extends UnyExpr(s) {
  override def toString: String = s"(1/$s)"
}

def infix(expr: Expr): String = ??? // TODO:

def eval(expr: Expr, bds: Map[String, Double]): Double = ???

def simplify(expr: Expr): Expr = ???
  
def assertEquals(expr: Expr, expected: String): Unit = {
  val actual: String = expr.toString
  val success: Boolean = actual == expected
  if (!success)
  {
    println(s"ERROR! actual \"$actual\" != expected \"$expected\"")
    assert(success)
  }
}