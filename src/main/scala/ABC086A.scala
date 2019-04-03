// 提出時はMainに変更
object ABC086A extends App {
  val i = {
    val s = new java.util.Scanner(System.in)
    (s.nextInt, s.nextInt)
  }

  // 積が奇数なら Odd と、 偶数なら Even と出力せよ。
  println(if (i._1 * i._2 % 2 == 1) "Odd" else "Even")
}

object ABC086Aex extends App {
  val i = {
    val s = new java.util.Scanner(System.in)
    (s.nextInt, s.nextInt)
  }

  println((i._1 * i._2).toString.last.toInt % 2 match {
    case 1 => "Odd"
    case _ => "Even"
  })
}
