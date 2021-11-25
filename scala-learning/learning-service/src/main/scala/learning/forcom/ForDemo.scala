package learning.forcom

/**
 * @author Yang Jing <a href="mailto:yang.xunjing@qq.com">yangbajing</a>
 * @since 2021-11-11 16:52:34
 */
object ForDemo extends App {
  val lists: List[List[Int]] = List(
    List(1, 2, 3),
    List(4, 5, 6)
  )

 val newList: List[Int] = for {
    list <- lists // first
    elem <- list  // second
  } yield {
   elem * 2
 }

  println(s"new list is $newList")

  val newLists: List[Int] = lists.flatMap { list => list.map(elem => elem * 2)}
  println(s"new list 2 is $newLists")
}
