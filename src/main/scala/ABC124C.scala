// 提出時はMainに変更
object ABC124C extends App {
  val i = {
    val s = new java.util.Scanner(System.in)
    s.next.toList.map(_.asDigit)
  }

  val c1 = i.zipWithIndex.count(n => (n._2 % 2 == 0 && n._1 == 0) || (n._2 % 2 == 1 && n._1 == 1))
  val c2 = i.zipWithIndex.count(n => (n._2 % 2 == 0 && n._1 == 1) || (n._2 % 2 == 1 && n._1 == 0))
  val result = i.length - Seq(c1, c2).max

  println(result)
}

object ABC124Cex extends App {
  val i = {
    val s = new java.util.Scanner(System.in)
    s.next.toList.map(_.asDigit)
  }

  val (oddList, evenList) = i.zipWithIndex.partition(_._2 % 2 == 0)
  val startWithZeroCount = oddList.count(_._1 == 1) + evenList.count(_._1 == 0)
  val startWithOneCount = oddList.count(_._1 == 0) + evenList.count(_._1 == 1)
  val result = Seq(startWithZeroCount, startWithOneCount).min

  println(result)
}
