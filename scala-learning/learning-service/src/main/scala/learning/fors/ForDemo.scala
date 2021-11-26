package learning.fors

case class Person(name: String)

object ForDemo extends App {

  val persons = List(Person("羊八井"), Person("yangbajing"))

  val ns: List[String] = for {
    p <- persons
    n = p.name if n.startsWith("羊")
    c <- n
  } yield p.name + " " + c
  println(ns)

  val xs = for {
    p <- persons if p.name.startsWith("羊")
  } yield p.name + " - "

  println(xs)

  val ms: List[String] = persons
    .filter { p =>
      val n = p.name
      n.startsWith("羊")
    }
    .flatMap { p =>
      p.name.map{ c =>
        p.name + " " + c
      }
    }

  println(ms)
}
