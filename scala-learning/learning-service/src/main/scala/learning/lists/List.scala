package learning.lists

abstract class List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]

  def headOption: Option[T] = if (isEmpty) None else Some(head)

  def length: Int = if (isEmpty) 0 else 1 + tail.length

  def ::[B >: T](x: B): List[B] = new ::(x, this)

  def map[B](f: T => B): List[B] = {
    if (this eq Nil) Nil
    else {
      val h = new ::[B](f(head), Nil)
      var t: ::[B] = h
      var rest = tail
      while (rest ne Nil) {
        val nx = new ::(f(rest.head), Nil)
        t.next = nx
        t = nx
        rest = rest.tail
      }
      h
    }
  }
}

object List {}

final case class ::[A](head: A, var tail: List[A], private[lists] var next: List[A] = Nil)
    extends List[A] {
  override def isEmpty: Boolean = false
}
