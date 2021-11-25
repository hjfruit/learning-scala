package learning.clazz

/**
 * @author Yang Jing <a href="mailto:yang.xunjing@qq.com">yangbajing</a>
 * @since 2021-11-10 14:53:24
 */
class ChecksumAccumulator {
  // private
  private val priv: String = ""
  // public
  var sum = ChecksumAccumulator.ZERO
  // package access
  private[clazz] val packAcs: Double = 0.0

  val `aa-bb` = "lkdsf"

  def sqls() = {
//    val sqls = sql"select * from test"
  }

  def add(b: Byte) : Int = {
//    b = 1
    sum += b //sum
    val num = 324_343
    sum
  }
}

object ChecksumAccumulator {
  private val ZERO = 0
}
