// 提出時はMainに変更
object ABC085B extends App {
  val i = {
    val s = new java.util.Scanner(System.in)
    val count = s.nextInt
    val nums = (0 until count).map(_ => s.nextInt).toList
    (nums)
  }

  println(i.distinct.length)
}
