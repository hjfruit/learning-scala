package learning.highkinder

/**
 * @author Yang Jing <a href="mailto:yang.xunjing@qq.com">yangbajing</a>
 * @since 2021-11-12 14:18:32
 */
class HighKinderDemo {
  val name = "out name"

  def func(f: String => String): Unit = {
    val result = f(name)
    println(result)
  }
}

object HighKinderDemo extends App {
  //   val hkd = new HighKinderDemo
  //   println(HighKinderDemo)
  //   hkd.func( name => {
  //     println(this)
  //     name + "hjfruit"
  //   })

  //  List(1, 2, 3).foreach{e =>
  //    val r = e * 2
  //    println(r)
  //  }

  //  def fileList = new File("/data/Documents").listFiles()
  //
  //  def filesContain(query: String, matcher: (String, String) => Boolean) = for (file <- fileList if matcher(file.getName, query)) yield file
  //  def filesContaining(matcher: (String) => Boolean) = for (file <- fileList if matcher(file.getName)) yield file

  //  filesContain(".zip", (filename, query) => filename.endsWith(query)).foreach(println)
  //  filesContain("""We""", (filename, query) => filename.startsWith(query)).foreach(println)
  //  val NAME = "We"
  //  filesContaining( (filename) => filename.startsWith(NAME)).foreach(println)

  def byname(text: => String): Unit = {
    println(text)
    println(text)
  }

  def nonbyname(text: String): Unit = {
    println(text)
    println(text)
  }

  nonbyname({
    println("nonbyname")
    "nonbyname"
  })
  byname( {
    println("byname")
    "byname"
  })
}
