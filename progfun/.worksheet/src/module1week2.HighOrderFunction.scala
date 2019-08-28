package module1week2

import math.abs

object HighOrderFunction {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(109); 
  println("Welcome to the Scala worksheet");$skip(50); 
  
  //fix point f(x) = x
  val tolerance = 0.001;System.out.println("""tolerance  : Double = """ + $show(tolerance ));$skip(84); 
  def isCloseEnough(x: Double, y: Double) = {
  	abs((x-y) / x) / x < tolerance
  };System.out.println("""isCloseEnough: (x: Double, y: Double)Boolean""");$skip(221); 
  def fixPoint(f: Double => Double)(firstGuess: Double) = {
  	def iterate(guess: Double): Double = {
  		val next = f(guess)
  		if(isCloseEnough(guess, next)) next
  		else iterate(next)
  	}
  	iterate(firstGuess)
  };System.out.println("""fixPoint: (f: Double => Double)(firstGuess: Double)Double""");$skip(31); val res$0 = 
  
  fixPoint(x => 1 + x/2)(1);System.out.println("""res0: Double = """ + $show(res$0));$skip(234); val res$1 = 
  
  
  //sqrt(x) is a fixed point of the function f: y => x/y
  //square root of 2 equal the fix point of f: y = 2/y
  //but it jump 1 and 2 infinitely
  //so you have use the stabilizing by averaging
  fixPoint(y => (y + 2/y)/2)(1);System.out.println("""res1: Double = """ + $show(res$1));$skip(70); 
  
  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2;System.out.println("""averageDamp: (f: Double => Double)(x: Double)Double""");$skip(79); 
  
  def sqrt(x: Double): Double = {
  	fixPoint(averageDamp(y => x/y))(1)
  };System.out.println("""sqrt: (x: Double)Double""");$skip(13); val res$2 = 
  
  sqrt(2);System.out.println("""res2: Double = """ + $show(res$2))}
}
