

object Leap {

  def leapYear(year: Int): Boolean = {
    type DivisibleCheck = Int => Boolean

    def divisible(div: Int): DivisibleCheck = _ % div == 0

    val divisible400 = divisible(400)(year)
    val divisible100 = divisible(100)(year)
    val divisible4 = divisible(4)(year)

    divisible400 || divisible4(year) && !divisible100(year) && !divisible400(year)
  }
}