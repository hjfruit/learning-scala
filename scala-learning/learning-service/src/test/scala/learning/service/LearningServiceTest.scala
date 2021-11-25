package learning.service

import learning.common.test.LearningTest

/**
 * @author Yang Jing <a href="mailto:yang.xunjing@qq.com">yangbajing</a>
 * @since 2021-11-09 16:29:28
 */
class LearningServiceTest extends LearningTest {

  "LearningServiceTest" should {
    "echo" in {
      val learningService = new LearningService

      learningService.echo("hello") should be("Received message is HELLO")
    }
  }
}
