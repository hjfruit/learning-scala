package learning.types

class Queue[+T](private[this] var items: List[T]) {

  def enqueue[U >: T](x: U): Queue[U] = new Queue(x :: items)

  def head: T = items.head
}

class StrangeIntQueue extends Queue[Int](Nil) {
//  override def enqueue(x: Int): Unit = super.enqueue(x)
}

class Top

class Middle extends Top

class Bottom extends Middle

object ContravarianceDemo extends App {
  class CellCovariant[+T]

  class CellContravariant[-T]

  def covariant(coll: CellCovariant[Middle]): Unit = {
    println(coll)
  }

  def contravariant(coll: CellContravariant[Middle]): Unit = {
    println(coll)
  }

//  covariant(new CellCovariant[Top])
  covariant(new CellCovariant[Middle])
  covariant(new CellCovariant[Bottom])

  contravariant(new CellContravariant[Top])
  contravariant(new CellContravariant[Middle])
//  contravariant(new CellContravariant[Bottom])

  var iq: Queue[Int] = new StrangeIntQueue
  iq = iq.enqueue(2)
  println(iq.head.getClass)

  iq.enqueue(3.asInstanceOf[Number])
//
//  val s: Int = iq.head
//
//  var anyq: Queue[Any] = new StrangeIntQueue
//  anyq = anyq.enqueue("adb")
//  println(anyq.head.getClass)
//
//  val i: Int = anyq.head.asInstanceOf[Int]

//  val x2: Queue[String] = iq.enqueue("abc")
//
//  val a = x2.head
//  println(a)


  def getTitle(str: CharSequence): String = str.toString.toUpperCase
  def getTitle2(str: String): CharSequence = str.toUpperCase

  val f: Function1[String, CharSequence] = getTitle
  val f1: Function1[String, CharSequence] = getTitle2

  val l = List("aaa", "bbb")
  println(l.map(f))
  println(l.map(getTitle))
}
