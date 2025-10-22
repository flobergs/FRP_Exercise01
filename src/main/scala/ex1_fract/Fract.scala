package ex1_fract

import java.util.Objects
import scala.runtime.ScalaRunTime

final class Fract(_n: Int, _d: Int) {
  // fields are public by default
  val (numer, denom) = normalize(_n, _d)

  def +(that: Fract) = Fract(numer * that.denom + that.numer * denom, denom * that.denom)
  def -(that: Fract) = Fract(numer * that.denom - that.numer * denom, denom * that.denom)
  def *(that: Fract) = Fract(numer * that.numer, denom * that.denom)
  def /(that: Fract) = this * that.rec()

  def neg() = Fract(-numer, denom)
  def rec() = Fract(denom, numer)

  override def toString: String = if (denom == 1) s"$numer" else s"$numer \\ $denom"

  override def equals(obj: Any): Boolean = obj match {
    case that: Fract => numer == that.numer && denom == that.denom
    case that: Int => numer == that && denom == 1
    case _ => false
  }

  override def hashCode(): Int = numer + denom
}

object Fract {
  def apply(n: Int, d: Int) = new Fract(n, d)
  def apply(n: Int) = new Fract(n, 1)
}

private def normalize(n: Int, d: Int):(Int, Int)={
  val gcd = computeGcd(n, d)
  if (d < 0) (-n/gcd, -d/gcd)
  else (n/gcd, d/gcd)
}

private def computeGcd(a: Int, b: Int): Int = {
  if (a < 0 || b < 0) computeGcd(a.abs, b.abs)

  // neugliedscher Algorithmus
  else if (b > a) computeGcd(b, a)
  else if (b == 0) a
  else computeGcd(b, a % b)
}