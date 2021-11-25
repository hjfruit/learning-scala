package learning.service

import learning.common.util.LearningUtils

/**
 * @author Yang Jing <a href="mailto:yang.xunjing@qq.com">yangbajing</a>
 * @since 2021-11-09 16:25:48
 */
class LearningService {
  def echo(msg: String): String = {
    s"Received message is ${LearningUtils.toUpperCase(msg)}"
  }
}
