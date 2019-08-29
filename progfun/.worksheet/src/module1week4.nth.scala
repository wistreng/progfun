package module1week4
import List._

object nth {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(92); 
  println("Welcome to the Scala worksheet");$skip(163); 
  
  def nth[T](n: Int, list: List[T]): T =
  	if(list.isEmpty || n<0) throw new IndexOutOfBoundsException
  	else if (n==0) list.head
  	else nth(n-1, list.tail);System.out.println("""nth: [T](n: Int, list: module1week4.List[T])T""");$skip(64); 
  	
  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)));System.out.println("""list  : module1week4.Cons[Int] = """ + $show(list ));$skip(15); val res$0 = 
  nth(2, list);System.out.println("""res0: Int = """ + $show(res$0));$skip(16); val res$1 = 
  nth(-1, list);System.out.println("""res1: Int = """ + $show(res$1));$skip(15); val res$2 = 
  nth(4, list);System.out.println("""res2: Int = """ + $show(res$2))}
}
