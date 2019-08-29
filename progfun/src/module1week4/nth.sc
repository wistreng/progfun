package module1week4
import List._

object nth {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def nth[T](n: Int, list: List[T]): T =
  	if(list.isEmpty || n<0) throw new IndexOutOfBoundsException
  	else if (n==0) list.head
  	else nth(n-1, list.tail)                  //> nth: [T](n: Int, list: module1week4.List[T])T
  	
  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
                                                  //> list  : module1week4.Cons[Int] = module1week4.Cons@6b71769e
  nth(2, list)                                    //> res0: Int = 3
  nth(-1, list)                                   //> java.lang.IndexOutOfBoundsException
                                                  //| 	at module1week4.nth$.nth$1(module1week4.nth.scala:8)
                                                  //| 	at module1week4.nth$.$anonfun$main$1(module1week4.nth.scala:14)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$anonfun$$ex
                                                  //| ecute$1(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:76)
                                                  //| 	at module1week4.nth$.main(module1week4.nth.scala:4)
                                                  //| 	at module1week4.nth.main(module1week4.nth.scala)
  nth(4, list)
}