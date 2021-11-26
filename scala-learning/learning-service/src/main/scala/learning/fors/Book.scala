package learning.fors

case class Book(title: String, authors: String*)

object Book extends App {
  val books: List[Book] =
    List(
      Book(
        "Structure and Interpretation of Computer Programs",
        "Abelson, Harold",
        "Sussman, Gerald J."
      ),
      Book(
        "Principles of Compiler Design",
        "Aho, Alfred",
        "Ullman, Jeffrey"
      ),
      Book(
        "Programming in Modula-2",
        "Wirth, Niklaus"
      ),
      Book(
        "Elements of ML Programming",
        "Ullman, Jeffrey"
      ),
      Book(
        "The Java Language Specification",
        "Gosling, James",
        "Joy, Bill",
        "Steele, Guy",
        "Bracha, Gilad"
      )
    )

  val authors =
    for {
      b1 <- books
      b2 <- books if b1 != b2
      a1 <- b1.authors
      a2 <- b2.authors if a1 == a2
    } yield a1

  println(authors.distinct)

  val lists = for {
    b1 <- books
    b2 <- books if b1 != b2
  } yield (b1.title, b2.title)
//  lists.foreach(println)

  val lists2 = books.flatMap { b1 =>
    books
      .filter(b2 => b2 != b1)
      .map(b2 => b1.title -> b2.title)
  }
//  lists2.foreach(println)
}
