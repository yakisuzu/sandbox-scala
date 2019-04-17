// 提出時はMainに変更
object ABC086C extends App {
  val i = {
    val s = new java.util.Scanner(System.in)
    val count = s.nextInt
    val nums = (1 to count).map(_ => (s.nextInt, s.nextInt, s.nextInt))
    nums
  }

  val result = i.forall { r =>
    (r._1 % 2 == (r._2 + r._3) % 2) && (-r._1 <= (r._2 + r._3) && (r._2 + r._3) <= r._1)
  }

  println(if (result) "Yes" else "No")
}


// 提出時はMainに変更
object ABC086Cex1 extends App {
  val i = {
    val s = new java.util.Scanner(System.in)
    val count = s.nextInt
    val nums = (1 to count).map(_ => (s.nextInt, s.nextInt, s.nextInt))
    nums
  }

  val result = i.map { r =>
    (r._1 % 2 == (r._2 + r._3) % 2) && (-r._1 <= (r._2 + r._3) && (r._2 + r._3) <= r._1)
  }.collectFirst {
    case false => "No"
  }.getOrElse("Yes")

  println(result)
}

// 提出時はMainに変更
object ABC086Cex2 extends App {
  val i = {
    //    val s = new java.util.Scanner(System.in)
    //    val count = s.nextInt
    //    val nums = (1 to count).map(_ => (s.nextInt, s.nextInt, s.nextInt))
    //    nums
  }

  val r = 1 to 3

  //  val dp = r.permutations.toList
  //  List(Vector(1, 2, 3), Vector(1, 3, 2), Vector(2, 1, 3), Vector(2, 3, 1), Vector(3, 1, 2), Vector(3, 2, 1))

  //  val dp = r.combinations(2).toList
  //  List(Vector(1, 2), Vector(1, 3), Vector(2, 3))

  //  val dp = r.flatMap { r1 => r.map(r2 => List(r1, r2)) }.toList
  //  val dp = {
  //    for {
  //      r1 <- r
  //      r2 <- r
  //    } yield List(r1, r2)
  //  }.toList

  //  @scala.annotation.tailrec
  def duplicatedCombinations(o: List[Int], pick: Int, count: Int = 0): List[List[Int]] = {
    def nest(baseList: List[Int], editList: List[Int]): List[Int] =
      baseList.flatMap(base => editList :+ base)

    o.map(or => nest(o, List(or)))
  }

  //  println(dp)
  //  List(List(1, 1), List(1, 2), List(1, 3), List(2, 1), List(2, 2), List(2, 3), List(3, 1), List(3, 2), List(3, 3))


  //  println(List(1, 2) :+ 3) // List(1, 2, 3)
  //  println(0 +: List(1, 2)) // List(0, 1, 2)

  //  println(List(1, 2) ++ List(3)) // List(1, 2, 3)
  //  println(List(1, 2) ::: List(3)) // List(1, 2, 3)

  //  println(List(1, 2) :: List(3)) // List(List(1, 2), 3)
  //  println(1 :: 2 :: 3 :: Nil) // List(1, 2, 3)
}
