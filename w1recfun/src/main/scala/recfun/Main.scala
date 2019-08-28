package recfun

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
    def pascal(c: Int, r: Int): Int = {
      //all the spot at the edge are all 1
      if(c == 0 || c == r) 1
      //otherwise, p(i,j) = p(i,j-1) + p(i-1,J-1)
      else pascal(c, r - 1) + pascal(c - 1, r - 1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def loop(str: List[Char], flag: Boolean): Boolean = {
        if(str.tail.isEmpty) changeFlag(str.head, flag)
        else loop(str.tail, changeFlag(str.head, flag))
      }

      def changeFlag(chr: Char, currflag: Boolean): Boolean = {
        if(chr == '(' && currflag == true) false
        else if(chr == ')' && currflag == false) true
        else currflag
      }

      loop(chars, true)
    }

    import common._
    import scala.annotation.tailrec
    def balance1(chars: List[Char]): Boolean = {
      @tailrec
      def loop(chars: List[Char], open: Int): Boolean = {
        chars match {
          case Nil => open == 0
          case '(' :: xs => loop(xs, open + 1)
          case ')' :: xs => (open > 0) && loop(xs, open - 1)
          case any => loop(chars.tail, open)
        }
      }
      loop(chars, 0)
    }
    
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      def count(coin:Int): Int =
        if(coin>money) 0
        else if(coin==money) 1
        else /*if(coin<money)*/ countChange(money-coin, coins)

      def countCoins(cs: List[Int]): Int =
        if(cs.isEmpty) 0
        else count(cs.head) + countChange(money, cs.tail)

      countCoins(coins)
    }
  }
