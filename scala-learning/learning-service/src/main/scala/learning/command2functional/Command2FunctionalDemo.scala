package learning.command2functional

/**
 * @author Yang Jing <a href="mailto:yang.xunjing@qq.com">yangbajing</a>
 * @since 2021-11-11 17:21:18
 */
object Command2FunctionalDemo extends App {
  def makeRowSeq(row: Int) = {
    for (col <- 1 to 10) yield {
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    }
    //    (1 to 10).map(col => s"${row * col}${" " * (4 - (row * col).toString.length)}")
  }

  def multiTable() = {
    //    val tableSeq = for (row <- 1 to 10) yield makeRowSeq(row).mkString
    //    tableSeq.mkString("\n")

    (1 to 10).map(i => makeRowSeq(i).mkString).mkString("\n")
  }

  val text = multiTable()
  println(text)
}
