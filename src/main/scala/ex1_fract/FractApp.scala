package ex1_fract

import ex1_fract.Fract._

object FractApp {

  def main(args: Array[String]): Unit = {
    println("asserting exercise tasks...")

    // Task 1.1
    assert(Fract(1,2).toString == "1\\2")
    assert(Fract(1,-2).toString == "-1\\2")
    assert(Fract(-1,2).toString == "-1\\2")
    assert(Fract(20,25).toString == "4\\5")
    assert(Fract(1,2) equals Fract(2,4))
    assert(!(Fract(1,2) equals Fract(3,4)))
    assert(Fract(1,2) + Fract(3,4) == Fract(5, 4))
    assert(Fract(1,2) - Fract(3,4) == Fract(-1, 4))
    assert(Fract(1,2) * Fract(3,4) == Fract(3, 8))
    assert(Fract(1,2) / Fract(1,4) == Fract(2))
    assert(Fract(1,2) + Fract(2, 3) * Fract(4, 1).rec() == Fract(2, 3))

    // Task 1.2
    assert(Fract(1,2).compareTo(Fract(2,4)) == 0)
    assert(Fract(1,2).compareTo(Fract(2,4)) <= 0)
    assert(Fract(1,2).compareTo(Fract(2,4)) >= 0)
    assert(Fract(1,2).compareTo(Fract(3,4)) < 0)
    assert(Fract(1,2).compareTo(Fract(3,4)) <= 0)
    assert(Fract(1,2).compareTo(Fract(1,4)) > 0)
    assert(Fract(1,2).compareTo(Fract(1,4)) >= 0)
    assert(Fract(1,2).compare(Fract(2,4)) == 0)
    assert(Fract(1,2).compare(Fract(3,4)) < 0)
    assert(Fract(1, 4) < Fract(2, 5))

    // Task 1.3
    assert(Fract(1,2) + 1 == Fract(3,2))
    assert(Fract(1,2) - 3 == Fract(-5,2))
    assert(Fract(1,2) * 5 == Fract(5,2))
    assert(Fract(1,2) / 2 == Fract(1,4))
    assert(1 + Fract(1,2) == Fract(3,2))
    assert(3 - Fract(1,2) == Fract(5,2))
    assert(5 * Fract(1,2) == Fract(5,2))
    assert(2 / Fract(1,2) == 4)
    assert(Fract(1,2) * 4 == 2)
    assert(((1 + Fract(1,2)) * 3) == Fract(9,2))

    // Task 1.4
    assert(1\2 == Fract(1,2))
    assert(1\2 + 1\4 == Fract(3,4))
    assert(1\2 - 1\3 == Fract(1,6))
    assert(1 + 1\2 + 2\3 * (4\1).rec() == 5\3)

    println("...all assertions passed.")
  }
}
