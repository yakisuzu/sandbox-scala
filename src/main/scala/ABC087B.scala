// 提出時はMainに変更
object ABC087B extends App {
  // 500 円玉を A 枚
  // 100 円玉を B 枚
  // 50 円玉を C 枚
  // 合計金額をちょうど X 円にする方法は何通り
  val i = {
    val s = new java.util.Scanner(System.in)
    (s.nextInt, s.nextInt, s.nextInt, s.nextInt)
  }

  def useableCount(currencyCount: Int, currencyVolume: Int, balance: Int): Int =
    Array(balance / currencyVolume, currencyCount).min

  def toInts(count: Int): List[Int] =
    (0 to count).toList

  case class Route(a: Int, b: Int, c: Int)

  val route500 = toInts(useableCount(i._1, 500, i._4))
  val route100 = toInts(useableCount(i._2, 100, i._4))
  val route50 = toInts(useableCount(i._3, 50, i._4))
  val routes = route500.flatMap { c500 =>
    route100.flatMap { c100 =>
      route50.map(c50 => Route(c500, c100, c50))
    }
  }

  val successCount = routes.count(r => r.a * 500 + r.b * 100 + r.c * 50 == i._4)

  println(successCount)
}

object ABC087Bex extends App {
  val i = {
    val s = new java.util.Scanner(System.in)
    (s.nextInt, s.nextInt, s.nextInt, s.nextInt)
  }

  def useAble(currencyCount: Int, currencyVolume: Int, balance: Int): Int =
    Seq(balance / currencyVolume, currencyCount).min

  val routes = for {
    a <- 0 to useAble(i._1, 500, i._4)
    b <- 0 to useAble(i._2, 100, i._4)
    c <- 0 to useAble(i._3, 50, i._4)
  } yield (a, b, c)

  val successCount = routes.count(r => r._1 * 500 + r._2 * 100 + r._3 * 50 == i._4)

  println(successCount)
}
