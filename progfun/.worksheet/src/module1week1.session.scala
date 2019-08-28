package module1week1

object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(83); 
  def abs(x: Double) = if (x < 0) -x else x;System.out.println("""abs: (x: Double)Double""");$skip(142); 

  def sqrtIter(guess: Double, x: Double): Double = {
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improveGuess(guess, x), x)
  };System.out.println("""sqrtIter: (guess: Double, x: Double)Double""");$skip(88); 

  def isGoodEnough(guess: Double, x: Double) =
    abs(guess * guess - x) / x < 0.001;System.out.println("""isGoodEnough: (guess: Double, x: Double)Boolean""");$skip(83); 

  def improveGuess(guess: Double, x: Double) = {
    (guess + x / guess) / 2
  };System.out.println("""improveGuess: (guess: Double, x: Double)Double""");$skip(43); 

  def sqrt(x: Double) = sqrtIter(1.0, x);System.out.println("""sqrt: (x: Double)Double""");$skip(12); val res$0 = 

  sqrt(2);System.out.println("""res0: Double = """ + $show(res$0));$skip(10); val res$1 = 
  sqrt(4);System.out.println("""res1: Double = """ + $show(res$1));$skip(13); val res$2 = 
  sqrt(0.01);System.out.println("""res2: Double = """ + $show(res$2));$skip(16); val res$3 = 
  sqrt(0.1e-20);System.out.println("""res3: Double = """ + $show(res$3));$skip(15); val res$4 = 
  sqrt(1.0e50);System.out.println("""res4: Double = """ + $show(res$4));$skip(477); 

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
  };System.out.println("""sqrt1: (x: Double)Double""");$skip(437); 

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
  };System.out.println("""sqrt2: (x: Double)Double""");$skip(13); val res$5 = 

  sqrt2(4);System.out.println("""res5: Double = """ + $show(res$5));$skip(556); 

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
  };System.out.println("""gcd: (a: Int, b: Int)Int""");$skip(115); 

  //not tail recursion function
  def factorial(n: Int): Int = {
    if (n == 0) 1 else n * factorial(n - 1)
  };System.out.println("""factorial: (n: Int)Int""");$skip(173); 

  //tail recursion of factorial
  def factorial1(n: Int): Int = {
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc else loop(acc * n, n - 1)
    loop(1, n)
  };System.out.println("""factorial1: (n: Int)Int""")}
	
}
