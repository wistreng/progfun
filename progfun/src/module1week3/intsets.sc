package module1week3

object intsets {
  val t1 = new NonEmpty(3, new Empty, new Empty)
  val t2 = t1 incl 4
  
  val ept = new Empty
  ept.contains(1)
  ept contains 1
  
  
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