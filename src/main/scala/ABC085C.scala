// 提出時はMainに変更
object ABC085C extends App {
  val i = {
    val s = new java.util.Scanner(System.in)
    (s.nextInt, s.nextInt)
  }

  // 10000x + 5000y + 1000z = Y
  def isOk(x: Int, y: Int, z: Int, Y: Int): Boolean =
    10 * x + 5 * y + z == Y / 1000

  // x + y + z = N
  val routes = for {
    x <- 0 to i._1
    y <- 0 to (i._1 - x) if isOk(x, y, i._1 - x - y, i._2)
  } yield (x, y, i._1 - x - y)

  val result = routes.headOption
    .getOrElse(-1, -1, -1)

  println(s"${result._1} ${result._2} ${result._3}")
}
