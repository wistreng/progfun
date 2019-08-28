package module1week3

object rationals {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  val r1 = new Rational(1, 2)                     //> r1  : module1week3.Rational = 1/2
  var r2 = new Rational(2, 3)                     //> r2  : module1week3.Rational = 2/3
  
  r2.sub(r1)                                      //> res0: module1week3.Rational = 1/6
  r1.max(r2)                                      //> res1: module1week3.Rational = 2/3
  r1.less(r2)                                     //> res2: Boolean = true
  r1 < r2                                         //> res3: Boolean = true
}

class Rational(x: Int, y: Int) {
		require(y != 0, "denominator must be nonzero")
		
		private def gcd(a: Int, b: Int): Int = if( b == 0) a else gcd(b, a % b)
		private def g = gcd(x ,y)
		def numer = x / g
		def denom = y / g
		
		def add(that: Rational) = {new Rational(numer * that.denom + denom * that.numer, denom * that.denom)}
		def neg = new Rational(-numer, denom)
		override def toString = numer + "/" + denom
		//more function with Rational
		def sub(that: Rational) = add(that.neg)
		def less(that: Rational): Boolean = numer * that.denom < denom * that.numer
		def max(that: Rational) = if(this.less(that)) that else this
		
		//evaluation and operator
		def < (that: Rational): Boolean = numer * that.denom < denom * that.numer
}