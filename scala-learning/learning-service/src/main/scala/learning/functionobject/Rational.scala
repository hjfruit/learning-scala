package learning.functionobject

/**
 * @author Yang Jing <a href="mailto:yang.xunjing@qq.com">yangbajing</a>
 * @since 2021-11-10 15:19:34
 */
class Rational(val n: Int, val d: Int) {
  self =>
//  require(n > 0, "N must be great 0.")

  def this(n: Int) {
    this(n, 3)
  }

  val `class` = "dfsdf"

  println(s"Created $n / $d")

  def add(that: Rational): Rational = {
    new Rational(n + that.d + that.n * d, d * that.d)
  }

  def +(that: Rational): Rational = add(that)

  def *(i: Int): Rational = new Rational(n * i, d * i)

  def *(r: Rational): Rational = new Rational(n * r.n, d * r.d)

  override def toString() = s"$n / $d"
}

object RationalMain extends App {
  implicit def intToRational(x: Int) = new Rational(x)

  //  implicit class RationalRich(x: Int) {
  //    def *(that: Rational) = that
  //  }

  val r = new Rational(1, 2)
  println(r)

  println(new Rational(0, 2))

  r * 2

  2.*(r)

  val b = false

  var ss = ""
  val s = if (b) {
//    ss = "true"
    "true"
  } else {
//    ss = "false"
    "false"
  }

  println("==============")

  val l = List(1, 2, 3, 4, 5)

  for (i <- l if i % 2 == 0)
    println(i)

  l.filter(i => i % 2 == 0).foreach(println)
}
