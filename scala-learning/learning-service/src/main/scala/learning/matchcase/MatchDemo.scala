package learning.matchcase

/**
 * @author Yang Jing <a href="mailto:yang.xunjing@qq.com">yangbajing</a>
 * @since 2021-11-11 17:09:25
 */
object MatchDemo extends App {
  def match1(value: Any): String = {
    val result: String = value match {
      case "salt" =>
        "salt 11"

      case i: Int if i % 2 == 0 =>
        val n = i + 5
        s"int is ${n}"

      case b: Boolean =>
        s"boolean is ${b}"

      case other =>
        s"unknown value is $other, class is ${other.getClass}"
    }
    result
  }

  println(match1("salt"))
  println(match1(32))
  println(match1(3))
  println(match1(true))
  println(match1(false))
  println(match1(234.32))
  //  match1("eggs")
  //  println(match1("slkdjf"))
}
