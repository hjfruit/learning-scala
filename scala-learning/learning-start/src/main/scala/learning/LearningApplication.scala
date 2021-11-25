package learning

import learning.service.LearningService

/**
 * @author Yang Jing <a href="mailto:yang.xunjing@qq.com">yangbajing</a>
 * @since 2021-11-09 16:25:32
 */
object LearningApplication {
  def main(args: Array[String]): Unit = {
    val learningService = new LearningService
    println(learningService.echo("Scala!"))
  }
}
