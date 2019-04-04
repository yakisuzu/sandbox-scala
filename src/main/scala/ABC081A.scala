// 提出時はMainに変更
object ABC081A extends App {
  val i = {
    val s = new java.util.Scanner(System.in)
    s.next.split("")
  }

  // すぬけ君は 1 が書かれたマスにビー玉を置きます。 ビー玉が置かれるマスがいくつあるか求めてください。
  println(i.foldLeft(0)((b, a) => if (a == "1") b + 1 else b))
}

object ABC081Aex extends App {
  val i = {
    val s = new java.util.Scanner(System.in)
    s.next.split("")
  }

  val result = i./:(0) {
    case (b, "1") => b + 1
    case (b, _) => b
  }
  println(result)
}
