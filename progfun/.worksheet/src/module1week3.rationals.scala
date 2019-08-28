package module1week3

object rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(84); 
  println("Welcome to the Scala worksheet");$skip(36); 
  
  
  val r1 = new Rational(1, 2);System.out.println("""r1  : module1week3.Rational = """ + $show(r1 ));$skip(30); 
  var r2 = new Rational(2, 3);System.out.println("""r2  : module1week3.Rational = """ + $show(r2 ));$skip(16); val res$0 = 
  
  r2.sub(r1);System.out.println("""res0: module1week3.Rational = """ + $show(res$0));$skip(13); val res$1 = 
  r1.max(r2);System.out.println("""res1: module1week3.Rational = """ + $show(res$1));$skip(14); val res$2 = 
  r1.less(r2);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(10); val res$3 = 
  r1 < r2;System.out.println("""res3: Boolean = """ + $show(res$3))}
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
