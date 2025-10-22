package ex2_expr

sealed trait Expr
// object oriented toString's
case class Lit(value: Double) extends Expr {

  //Task 2.1:  override def toString: String = value.toString

//  // bonus
//  override def toString: String = {
//    val label = value.toString
//
//    if (label.endsWith(".0")) label.substring(0, label.length-".0".length)
//    else label
//  }
}
case class Var(name: String) extends Expr {
  //Task 2.1:  override def toString: String = name
}

sealed trait BinExpr(val left: Expr, val right: Expr) extends Expr
case class Add(l: Expr, r: Expr) extends BinExpr(l, r) {
  //Task 2.1:  override def toString: String = s"($l+$r)"
}
case class Mul(l: Expr, r: Expr) extends BinExpr(l, r) {
  //Task 2.1:  override def toString: String = s"($l*$r)"
}

sealed trait UnyExpr(sub: Expr) extends Expr
case class Neg(s: Expr) extends UnyExpr(s) {
  //Task 2.1:  override def toString: String = s"(-$s)"
}
case class Recip(s: Expr) extends UnyExpr(s) {
  //Task 2.1:   override def toString: String = s"(1/$s)"
}

// functional oriented toString's "infix"
def infix(expr: Expr): String = {
  def op(expr: BinExpr): String = {
    expr match {
      case Add(_, _) => "+"
      case Mul(_, _) => "*"
    }
  }

  expr match {
    case Lit(v) => v.toString
    case Var(n) => n
    case b: BinExpr => s"(${infix(b.left)}${op(b)}${infix(b.right)})"
    case Neg(x) => s"(-${infix(x)})"
    case Recip(x) => s"(1/${infix(x)})"
  }
}

def eval(expr: Expr, bds: Map[String, Double]): Double = ???

def simplify(expr: Expr): Expr = ???
  
def assertEquals(expr: Expr, expected: String): Unit = {
  val actual: String = infix(expr)
  val success: Boolean = actual == expected
  if (!success)
  {
    println(s"ERROR! actual \"$actual\" != expected \"$expected\"")
    assert(success)
  }
}