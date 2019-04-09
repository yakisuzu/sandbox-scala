// 提出時はMainに変更
object ABC083B extends App {
  val i = {
    val s = new java.util.Scanner(System.in)
    (s.nextInt, s.nextInt, s.nextInt)
  }

  def sumStr(num: Int): Int =
    num.toString.toCharArray./:(0)(_ + _.asDigit)


  def sumMatch(sum: Int, a: Int, b: Int): Boolean =
    a <= sum && sum <= b

  def successSum(num: Int, a: Int, b: Int): Int =
    (1 to num)
      .filter(c => sumMatch(sumStr(c), a, b))
      .sum

  val result = successSum(i._1, i._2, i._3)

  println(result)
}
