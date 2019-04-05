// 提出時はMainに変更
object ABC081B extends App {
  val i = {
    val s = new java.util.Scanner(System.in)
    val count = s.nextInt
    val nums = Stream.from(0).take(count).map(_ => s.nextInt)
    (nums)
  }

  // 整数がすべて偶数であるとき，整数すべてを，2 で割ったものに置き換える
  // 最大で何回操作を行うことができるか
  def canHalf =
    (s: Stream[Int]) => s.forall(_.toString.last.toInt % 2 == 0)

  def toHalf =
    (s: Stream[Int]) => s.map(_ / 2)

  def check: (Stream[Int], Int) => Int =
    (s: Stream[Int], success: Int) => if (canHalf(s)) check(toHalf(s), success + 1) else success

  println(check(i, 0))
}

object ABC081Bex extends App {
  val i = {
    val s = new java.util.Scanner(System.in)
    val count = s.nextInt
    val nums = (0 until count).map(_ => s.nextInt).toList
    (nums)
  }

  // 整数がすべて偶数であるとき，整数すべてを，2 で割ったものに置き換える
  // 最大で何回操作を行うことができるか
  def canHalf(s: List[Int]): Boolean =
    s.forall {
      _.toString.last.toInt % 2 match {
        case 0 => true
        case _ => false
      }
    }

  def toHalf(s: List[Int]): List[Int] =
    s.map(_ / 2)

  @scala.annotation.tailrec
  def countHalf(s: List[Int], success: Int = 0): Int =
    if (canHalf(s)) countHalf(toHalf(s), success + 1)
    else success

  println(countHalf(i))
}
