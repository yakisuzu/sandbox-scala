// 提出時はMainに変更
object ABC088B extends App {
  val i = {
    val s = new java.util.Scanner(System.in)
    val count = s.nextInt
    val nums = (0 until count).map(_ => s.nextInt).toList
    (nums)
  }


  def splitCards(cards: List[Int]): (List[Int], List[Int]) = {
    val t = cards.sortWith(_ > _).zipWithIndex.partition(_._2 % 2 == 0)
    (t._1.map(_._1), t._2.map(_._1))
  }

  def calcScore(aliceCards: List[Int], bobCards: List[Int]): Int =
    aliceCards.sum - bobCards.sum

  val (aliceCards, bobCards) = splitCards(i)
  val result = calcScore(aliceCards, bobCards)

  println(result)
}
