package ex1_fract

import ex1_fract.Fract._

object FractApp {

  def main(args: Array[String]): Unit = {
    assert(Fract(1,2).toString == "1 \\ 2")
    assert(Fract(1,-2).toString == "-1 \\ 2")
    assert(Fract(-1,2).toString == "-1 \\ 2")
    assert(Fract(20,25).toString == "4 \\ 5")
    assert(Fract(1,2) equals Fract(2,4))
    assert(!(Fract(1,2) equals Fract(3,4)))
    assert((Fract(1,2) + Fract(3,4)).toString == "5 \\ 4")
    assert((Fract(1,2) - Fract(3,4)).toString == "-1 \\ 4")
    assert((Fract(1,2) * Fract(3,4)).toString == "3 \\ 8")
    assert((Fract(1,2) / Fract(1,4)).toString == "2")

  }

}
