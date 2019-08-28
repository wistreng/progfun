package funsets


/**
 * 2. Purely Functional Sets.
 */
object FunSets {
  
  def s = Array(1,2,3)
  s(2)
  
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  type Set = Int => Boolean

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem) //Set is a function f:(elem: Int):Boolean, so this actually returns a function

  /**
   * Returns the set of the one given element.
   */
    def singletonSet(elem: Int): Set = {x: Int => x == elem} //Set is a function f: Int => Boolean
  

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
    def union(s: Set, t: Set): Set = {x: Int => contains(s, x) || contains(t, x)}
  
  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
    def intersect(s: Set, t: Set): Set = {x: Int => contains(s, x) && contains(t, x)}
  
  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
    def diff(s: Set, t: Set): Set = {x: Int => contains(s, x) && !contains(t, x)}
  
  /**
   * Returns the subset of `s` for which `p` holds.
   */
    def filter(s: Set, p: Int => Boolean): Set = intersect(s, p)
  

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > 1000 || a < -1000) true //out of bound, loop finish
      else if (contains(s, a) && !p(a)) false //any elem obey the condition, return false
      else iter(a - 1)
    }
    iter(bound)
  }
  
  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
    def exists(s: Set, p: Int => Boolean): Boolean = {
//      def iter(a: Int): Boolean = {
//        if( a>1000 || a<-1000) false
//        else if (contains(s, a) && p(a)) true
//        else iter(a - 1)
//      }
//      iter(bound)
      !forall(s, (x => !p(x))) // forall = false, not all elements do not satisfy p, which equals certain e exists.
    }
  
  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
    def map(s: Set, f: Int => Int): Set = {x: Int => exists(s, (y: Int) => f(y) == x)}
    //for any x in result set, there exists a y in set s, where f(y) = x
  
  /**
   * Displays the contents of a set
   */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(toString(s))
  }
}
