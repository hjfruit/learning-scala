package learning.test

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

/**
 * @author Yang Jing <a href="mailto:yang.xunjing@qq.com">yangbajing</a>
 * @since 2021-11-16 19:50:41
 */
class FunSuiteTest extends AnyFunSuite with Matchers {
  test("1 == 1") {
//    assert(1 == 0)
//    1 should be(0)

//    1 should be(1)

//    val l = List(1, 2, 3, 4)
//    l should contain (5)

    assertThrows[IllegalArgumentException] {
      maybeThrow(-1)
    }
    val r = intercept[IllegalArgumentException] {
      maybeThrow(-1)
    }
    r.getMessage shouldBe "n < 0"
    println(r)
  }

  def maybeThrow(n: Int): Int = {
    if (n < 0) throw new IllegalArgumentException("n < 0")

    n + 1
  }
}
