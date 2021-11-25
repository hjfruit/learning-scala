package learning.test

/**
 * @author Yang Jing <a href="mailto:yang.xunjing@qq.com">yangbajing</a>
 * @since 2021-11-16 19:46:09
 */
object TestDemo extends App {
  def above(n: Int): Int = {
//    val result = n + 1
//    assert(result > 0)
//    result

    val r = n + 1
    r.ensuring(_ > 0)
  }

  above(-1)
}
