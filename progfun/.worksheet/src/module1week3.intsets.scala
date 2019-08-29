package module1week3

object intsets {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(88); 
  val t1 = new NonEmpty(3, new Empty, new Empty);System.out.println("""t1  : module1week3#31.NonEmpty#15595 = """ + $show(t1 ));$skip(21); 
  val t2 = t1 incl 4;System.out.println("""t2  : module1week3#31.IntSet#15593 = """ + $show(t2 ));$skip(25); 
  
  val ept = new Empty;System.out.println("""ept  : module1week3#31.Empty#15594 = """ + $show(ept ));$skip(18); val res$0 = 
  ept.contains(1);System.out.println("""res0: Boolean#1719 = """ + $show(res$0));$skip(17); val res$1 = 
  ept contains 1;System.out.println("""res1: Boolean#1719 = """ + $show(res$1))}
  
  
}

//use binary tree to model the int set, where left hand sub-node smaller, right hand sub-node bigger

//3.1 class hierarchies

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}
//sub implement


class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  override def toString = "."
  def union(other: IntSet): IntSet = other
}
//implement
class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  
  def contains(x: Int): Boolean =
    if (x < elem) left contains x //travel left tree
    else if (x > elem) right contains x //travel right
    else true //x = elem
    
  def incl(x: Int): IntSet = //should be call add
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
    
  override def toString = "{" + left + elem + right + "}"
  def union(other: IntSet): IntSet =
  	((left union right) union other) incl elem
}

//3.2
