package learning.tailrec

import scala.annotation.tailrec

/**
 * @author Yang Jing <a href="mailto:yang.xunjing@qq.com">yangbajing</a>
 * @since 2021-11-12 14:14:28
 */
object TailrecDemo extends App {
  @tailrec
  def boom(x: Int): Int =
    if (x == 0) throw new Exception("boom!")
    else boom(x - 1)
}
