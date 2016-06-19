package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  
  val s1 = singletonSet(1)
  val s2 = singletonSet(2)
  val s3 = singletonSet(3)
  val s12 = union(s1, s2)
  val s13 = union(s1, s3)
  val s23 = union(s2, s3)
  val s123 = union(s12, s3)
  val s149 = map(s123, x => x * x)
  val s1234	= union(s123, singletonSet(4))
  val s12345	= union(s1234, singletonSet(5))
  val s123457	= union(s12345, singletonSet(7))
  val s1000	= union(s123457, singletonSet(1000))
  printSet(s123)
  printSet(s149)
  
  val s = diff(s1000, s1234)
  FunSets.toString(s)
  
  
}
