abstract class Tree
case class Sum(l: Tree, r: Tree) extends Tree
case class Div(l: Tree, r: Tree) extends Tree
case class Var(n: String) extends Tree
case class Const(v: Int) extends Tree

object PatternMatchingLab {
    type Environment = String => Int

    def eval(t: Tree, env: Environment): Int = t match {
        case Sum(l, r) => eval(l, env) + eval(r, env)
        case Div(l, r) => eval(l, env) - eval(r, env)
        case Var(n) => env(n)
        case Const(v) => v
    }

    def main(args: Array[String]): Unit = {
        val exp: Tree = Div(Sum(Var("x"), Var("x")), Sum(Const(7), Var("y")))
        val env: Environment = { case "x" => 5 case "y" => 7 }
        println("Expression: " + exp)
        println("Evaluation with x=5, y=7: " + eval(exp, env))
    }
}