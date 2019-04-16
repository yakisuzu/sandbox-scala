// 提出時はMainに変更
object ABC049C extends App {
  val i = {
    val s = new java.util.Scanner(System.in)
    s.next()
  }

  val result = Seq("dream", "dreamer", "erase", "eraser")
    .permutations
    .map(_./:(i)(_.replace(_, "")))
    .collectFirst {
      case "" => "YES"
    }.getOrElse("NO")

  println(result)
}
