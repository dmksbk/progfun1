package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c == 0 || r == 0 || r == c) 1
    else pascal(c, r-1) + pascal(c-1, r-1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
      def weight(c: Char): Int = c match {
        case '('=>	1
        case ')'=>  -1
        case _	=>	0
      }
      
      def calc(acc: Int, chars: List[Char]): Int =
        if (acc < 0) -1
        else if (chars.isEmpty) acc
             else calc(acc + weight(chars.head), chars.tail)
      
      calc(0, chars) == 0
    }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def change(money: Int, minCoin: Int): Int = {
      money match {
        case 0			=> 1
        case n if n < 0	=> 0
        case n if n > 0	=> {
          val curCoinsSet: List[Int] = coins.filter((c: Int) => c >= minCoin)
          //println("money=" + money + ", minCoin=" + minCoin + ", curCoinsSet=" + curCoinsSet)
          curCoinsSet.map((coin: Int) => change(money - coin, coin)).sum
        }
      }}
      change(money, 0)
    }
}
