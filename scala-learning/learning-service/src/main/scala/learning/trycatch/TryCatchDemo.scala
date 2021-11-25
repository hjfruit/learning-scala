package learning.trycatch

import java.io.{FileNotFoundException, FileReader, IOException}

/**
 * @author Yang Jing <a href="mailto:yang.xunjing@qq.com">yangbajing</a>
 * @since 2021-11-11 16:57:12
 */
object TryCatchDemo extends App {
  val n = 4

  val half: Int = if (n % 2 == 0) n / 2 else throw new RuntimeException(s"$n invalid")

  if (n % 2 != 0) {
    throw new RuntimeException(s"$n invalid")
  }

  val half2 = n / 2

  val f = new FileReader("/tmp/input.txt")
  val result: Int = try {
    1
  } catch {
    case e: FileNotFoundException => /*"FileNotFoundException"*/ 2
    case e: IOException => /*"FileNotFoundException"*/ 3
  } finally {
    f.close()
  }
  println(s"result is $result")

  def ff(): Int = try {
    return 1
  }  finally {
     2
  }

  println(ff())
}
