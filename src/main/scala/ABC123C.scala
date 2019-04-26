// 提出時はMainに変更
object ABC123C extends App {
  val (us, limits) = {
    val s = new java.util.Scanner(System.in)
    (s.nextDouble(), (1 to 5).map(_ => s.nextLong()))
  }

  // ボトルネックで切り上げ + 残りの移動回数
  val ans = (us / limits.min).ceil.toLong + 4
  println(ans)
}

object ABC123C_fail2 extends App {
  val (us, limits) = {
    val s = new java.util.Scanner(System.in)
    (s.nextLong(), (1 to 5).map(_ => s.nextLong()))
  }

  def moveStep(current: Long, movable: Long): (Long, Long) =
    current match {
      case 0 => (0, 0)
      case c if c > movable => (c - movable, movable)
      case c => (0, c)
    }

  def move(before: Seq[Long]): Seq[Long] = {
    val after = (0 to 4).map(i => moveStep(before(i), limits(i)))
    Seq(
      after(0)._1,
      after(0)._2 + after(1)._1,
      after(1)._2 + after(2)._1,
      after(2)._2 + after(3)._1,
      after(3)._2 + after(4)._1,
      after(4)._2
    )
  }

  @scala.annotation.tailrec
  def calc(before: Seq[Long], count: Long = 0): Long = {
    before match {
      case Seq(0, 0, 0, 0, 0, _) => count
      case b => calc(move(b), count + 1)
    }
  }

  val init = Seq(us, 0, 0, 0, 0, 0)
  println(calc(init))
}

/*
1 1 1 1 1 1
5
*/

/*
5 3 2 4 3 5
7
*/

/*
10 123 123 123 123 123
5
 */

/*
10000000007 2 3 5 7 11
5000000008
 */

/*
5 5 4 3 2 1
  5 54321
=> 5 00000
=> 0 50000
=> 0 14000
=> 0 02300
=> 0 00320
=> 0 00131
=> 0 00032
=> 0 00023
=> 0 00014
=> 0 00005
9
 */

object ABC123Cex extends App {

  import scala.util.control.Exception._

  val a: Either[Throwable, Seq[Int]] = allCatch either {
    1 to 10
  }

  val b = ({
    case Right(b) => Map(1 -> b)
    case Left(_) => Map()
  }: Either[Throwable, Seq[Int]] => Map[Int, Seq[Int]]) (a)

  val c = a.fold(_ => Seq(), b => b)
  println(a)
  println(b)
  println(c)
}

object ABC123C_fail1 extends App {
  val (us, limits) = {
    val s = new java.util.Scanner(System.in)
    (s.nextLong(), (1 to 5).map(_ => s.nextLong()).toList)
  }

  // ボトルネックで切り上げ + 残りの移動回数
  val ans = ({
    case m if m >= `us` => limits.length
    case d => (us + d - 1l) / 2l + 4l
  }: Long => Long) (limits.min)

  println(ans)
}
