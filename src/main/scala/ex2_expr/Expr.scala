package ex2_expr

sealed trait Expr
// object oriented toString's
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

sealed trait BinExpr(val left: Expr, val right: Expr) extends Expr
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

def eval(expr: Expr, bds: Map[String, Double]): Double = {
  def eval(expr: Expr): Double = {
    expr match {
      case Lit(v) => v
      case Var(n) => bds(n)
      case Add(l, r) => eval(l) + eval(r)
      case Mul(l, r) => eval(l) * eval(r)
      case Neg(s) => -eval(s)
      case Recip(s) => 1/eval(s)
    }
  }

  eval(expr)
}

def simplify(expr: Expr): Expr = {
  expr match {
    case e@Lit(_) => e
    case e@Var(_) => e
    case Add(l, r) =>
      (simplify(l), simplify(r)) match {
        case (Lit(v1), Lit(v2)) => Lit(v1 + v2)
        case (Lit(0), a) => a
        case (a, Lit(0)) => a
        case (ls, rs) => Add(ls, rs)
      }
    case Mul(l, r) =>
      (simplify(l), simplify(r)) match {
        case (Lit(v1), Lit(v2)) => Lit(v1 * v2)
        case (Lit(0), _) => Lit(0)
        case (_, Lit(0)) => Lit(0)
        case (Lit(1), a) => a
        case (a, Lit(1)) => a
        case (ls, rs) => Mul(ls, rs)
      }
    case Neg(s) =>
      simplify(s) match {
        case Lit(v) => Lit(-v)
        case Neg(e) => e
        case simplifiedInner@_ => Neg(simplifiedInner)
      }
    case Recip(s) =>
      simplify(s) match {
        case Lit(v) => Lit(1/v)
        case Recip(e) => e
        case simplifiedInner@_ => Recip(simplifiedInner)
      }
  }
}
  
def assertEquals(expr: Expr, expected: String): Unit = {
  val actual: String = infix(expr)
  val success: Boolean = actual == expected
  if (!success)
  {
    println(s"ERROR! actual \"$actual\" != expected \"$expected\"")
    assert(success)
  }
}

def assertEquals(expr: Expr, bds: Map[String, Double], expected: Double): Unit = {
  val actual: Double = eval(expr, bds)
  val success: Boolean = actual == expected
  if (!success) {
    println(s"ERROR! actual evaluation result \"$actual\" of expression \"${infix(expr)}\" != expected \"$expected\"")
    assert(success)
  }
}