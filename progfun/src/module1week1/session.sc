package module1week1

object session {
  def abs(x: Double) = if (x < 0) -x else x       //> abs: (x: Double)Double

  def sqrtIter(guess: Double, x: Double): Double = {
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improveGuess(guess, x), x)
  }                                               //> sqrtIter: (guess: Double, x: Double)Double

  def isGoodEnough(guess: Double, x: Double) =
    abs(guess * guess - x) / x < 0.001            //> isGoodEnough: (guess: Double, x: Double)Boolean

  def improveGuess(guess: Double, x: Double) = {
    (guess + x / guess) / 2
  }                                               //> improveGuess: (guess: Double, x: Double)Double

  def sqrt(x: Double) = sqrtIter(1.0, x)          //> sqrt: (x: Double)Double

  sqrt(2)                                         //> res0: Double = 1.4142156862745097
  sqrt(4)                                         //> res1: Double = 2.000609756097561
  sqrt(0.01)                                      //> res2: Double = 0.10000052895642693
  sqrt(0.1e-20)                                   //> res3: Double = 3.1633394544890125E-11
  sqrt(1.0e50)                                    //> res4: Double = 1.0000003807575104E25

  // wrapped the above function into a BLOACK
  def sqrt1(x: Double) = {
    def abs(x: Double) = if (x < 0) -x else x

    def sqrtIter(guess: Double, x: Double): Double = {
      if (isGoodEnough(guess, x)) guess
      else sqrtIter(improveGuess(guess, x), x)
    }

    def isGoodEnough(guess: Double, x: Double) =
      abs(guess * guess - x) / x < 0.001

    def improveGuess(guess: Double, x: Double) = {
      (guess + x / guess) / 2
    }
    sqrtIter(1.0, x)
  }                                               //> sqrt1: (x: Double)Double

  //lexical scope, with the same defination of x
  def sqrt2(x: Double) = {
    //def abs(x: Double) = if (x < 0) -x else x

    def sqrtIter(guess: Double): Double = {
      if (isGoodEnough(guess)) guess
      else sqrtIter(improveGuess(guess))
    }

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.001

    def improveGuess(guess: Double) = {
      (guess + x / guess) / 2
    }
    sqrtIter(1.0)
  }                                               //> sqrt2: (x: Double)Double

  sqrt2(4)                                        //> res5: Double = 2.000609756097561

  //write the operate at the end of line

  //arithmetic and boolean expressions
  //conditional expression if-else
  //function with recursion
  //nesting and lexical scope
  //call-by-name or call-by-value strategies
  //reduce expression using the substitution model

  //tail recursion
  //if the last action of a funtion consists of calling a function ( which may be the same), one stack frame
  //would be sufficient for both functions, such calls are called tail-calls
  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }                                               //> gcd: (a: Int, b: Int)Int

  //not tail recursion function
  def factorial(n: Int): Int = {
    if (n == 0) 1 else n * factorial(n - 1)
  }                                               //> factorial: (n: Int)Int

  //tail recursion of factorial
  def factorial1(n: Int): Int = {
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc else loop(acc * n, n - 1)
    loop(1, n)
  }                                               //> factorial1: (n: Int)Int
	
}