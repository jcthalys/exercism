object SumOfMultiples {

  def sum(factors: Set[Int], limit: Int): Int = {


    val numbers = for {
      factor <- factors
      n <- 1 until limit
      if n % factor == 0
    } yield n

    numbers sum
  }
}