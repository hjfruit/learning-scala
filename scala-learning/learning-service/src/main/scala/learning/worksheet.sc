abstract class Expr

case class Var(name: String) extends Expr

case class Number(num: Double) extends Expr

case class UnOp(operator: String, arg: Expr) extends Expr

case class BinOp(operator: String, left: Expr, right: Expr) extends Expr
  
val v = Var("x")

val op = BinOp("+", Number(1), v)

def simplifyTop(expr: Expr): Expr = expr match {
  case a @ UnOp("-", b @ UnOp(_, e)) =>
    println("Double negation")

    e // Double negation

  case BinOp("+", e, Number(0)) =>
    println("Adding zero")
    e // Adding zero

  case BinOp("*", e, Number(1)) =>
    println("Multiplying by one")
    e // Multiplying by one

//  case _ => expr
}

//simplifyTop(UnOp("-", UnOp("-", Var("x"))))
simplifyTop(BinOp("+", Number(1), Number(0)))


val pi = math.Pi
math.E

//math.E match {
//  case `pi` => "strange math ? Pi = " + pi
//}

def matchList(l: List[Int]) = l match {
  case List(0, _, _) => println("found it")
  case a :: 1 :: Nil => println(s"$a and 1 and Nil")
  case a :: 1 :: _ => println(s"$a and 1")
  case other => println(s"other is $other")
}

matchList(List(0, 11, 2))
matchList(List(0, 11, 2, 3))
matchList(List(0, 1, 2, 3))
matchList(List(2, 1, 2))
matchList(List(4, 1, 2, 3, 4))
matchList(List(6, 1))
matchList(List(5))