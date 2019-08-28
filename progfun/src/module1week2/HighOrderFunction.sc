package module1week2

import math.abs

object HighOrderFunction {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //fix point f(x) = x
  val tolerance = 0.001                           //> tolerance  : Double = 0.001
  def isCloseEnough(x: Double, y: Double) = {
  	abs((x-y) / x) / x < tolerance
  }                                               //> isCloseEnough: (x: Double, y: Double)Boolean
  def fixPoint(f: Double => Double)(firstGuess: Double) = {
  	def iterate(guess: Double): Double = {
  		val next = f(guess)
  		if(isCloseEnough(guess, next)) next
  		else iterate(next)
  	}
  	iterate(firstGuess)
  }                                               //> fixPoint: (f: Double => Double)(firstGuess: Double)Double
  
  fixPoint(x => 1 + x/2)(1)                       //> res0: Double = 1.99609375
  
  
  //sqrt(x) is a fixed point of the function f: y => x/y
  //square root of 2 equal the fix point of f: y = 2/y
  //but it jump 1 and 2 infinitely
  //so you have use the stabilizing by averaging
  fixPoint(y => (y + 2/y)/2)(1)                   //> res1: Double = 1.4142135623746899
  
  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2
                                                  //> averageDamp: (f: Double => Double)(x: Double)Double
  
  def sqrt(x: Double): Double = {
  	fixPoint(averageDamp(y => x/y))(1)
  }                                               //> sqrt: (x: Double)Double
  
  sqrt(2)                                         //> res2: Double = 1.4142135623746899
}