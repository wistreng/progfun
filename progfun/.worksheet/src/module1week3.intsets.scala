package module1week3

object intsets {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(88); 
  val t1 = new NonEmpty(3, new Empty, new Empty);System.out.println("""t1  : module1week3.NonEmpty = """ + $show(t1 ));$skip(21); 
  val t2 = t1 incl 4;System.out.println("""t2  : module1week3.IntSet = """ + $show(t2 ));$skip(25); 
  
  val ept = new Empty;System.out.println("""ept  : module1week3.Empty = """ + $show(ept ));$skip(18); val res$0 = 
  ept.contains(1);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(19); val res$1 = 
  Empty contains 1;System.out.println("""res1: <error> = """ + $show(res$1))}
}

//use binary tree to model the int set, where left hand sub-node smaller, right hand sub-node bigger

//3.1 class hierarchies

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  override def toString = "."
  def union(other: IntSet): IntSet = other
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  override def toString = "{" + left + elem + right + "}"
  def union(other: IntSet): IntSet =
  	((left union right) union other) incl elem
}

//3.2
