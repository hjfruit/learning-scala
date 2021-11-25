package learning.common.test

import org.scalatest.OptionValues
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

/**
 * @author Yang Jing <a href="mailto:yang.xunjing@qq.com">yangbajing</a>
 * @since 2021-11-09 16:50:11
 */
trait LearningTest extends AnyWordSpec with Matchers with OptionValues with ScalaFutures {

}
