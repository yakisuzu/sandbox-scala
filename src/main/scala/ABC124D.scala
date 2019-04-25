/*
import scala.io.{StdIn => in}
import scala.collection.{mutable => mu}
import java.lang.{Character => char}

object Main extends App {
  val Array(n,k) = in.readLine.split(" ").map(_.toInt)
  val s = in.readLine.map(char.getNumericValue)

  val table = mu.ArrayBuffer.empty[Int]
  s./:(-1)( (b, i) => {
    val v = if(i == 1) 1 else -1
    if(i != b) table.append(v)
    else table(table.size-1) += v
    i
  })

  val sums = table.scanLeft(0)((acc,i) => acc + i.abs)
  0 +=: table

  def rec(acc:Int, cnt:Int, left:Int, right:Int, now:Int):Int = {
    if(right == table.size) acc max (sums(right-1) - sums(left))
    else {
      val leftCnt = if(table(left) < 0) 1 else 0
      if(cnt-leftCnt == k && now == 1)
        rec(acc max (sums(right) - sums(left)), cnt-leftCnt, left+1, right, now)
      else
        rec(acc, cnt+(now^1), left, right+1, now^1)
    }
  }

  val ans = rec(0,0,0,1,s.head)
  println(ans)
}
*/

// 提出時はMainに変更
object ABC124D extends App {
  val (_, count, nums) = {
    val s = new java.util.Scanner(System.in)
    (s.nextInt, s.nextInt, s.next.toList.map(_.asDigit))
  }

  // スコア
  val table = nums./:((List[Int](), -1))((b, currentValue) => {
    val (result, beforeValue) = b
    val v = if (currentValue == 1) 1 else -1

    (currentValue match {
      case `beforeValue` => result.dropRight(1) :+ (result.last + v)
      case _ => result :+ v
    }, currentValue)
  })._1
  println(table)

  // スイッチ後の期待値含めたスコア
  val sums = table.scanLeft(0)((acc, i) => acc + i.abs)
  println(sums)

  // TODO acc なにかの合計
  // TODO cnt よくわからん
  // TODO left どこまで右みるか
  // TODO right どこまで左みるか
  // TODO now XORよくわからん
  @scala.annotation.tailrec
  def rec(acc: Int = 0, cnt: Int = 0, left: Int = 0, right: Int = 1, now: Boolean = false): Int = {
    println(s"$acc, $cnt, $left, $right, $now")

    // 右端に到達した
    if (right == table.size) return acc max (sums(right - 1) - sums(left))


    // 左側の長さ
    // マイナスだったらまだいける？
    val range = cnt - (if (table(left) < 0) 1 else 0)
    val isCheck = range == count && now
    val leftRange = if (isCheck) range else if (now) cnt else cnt + 1

    // 回数が上限になるまでは、右に伸ばして確認
    if (isCheck)
      rec(acc max (sums(right) - sums(left)), leftRange, left + 1, right, now)
    else
      rec(acc, leftRange, left, right + 1, !now)
  }

  println(rec())
}

object ABC124D_fail extends App {
  val (len, count, nums) = {
    val s = new java.util.Scanner(System.in)
    (s.nextInt, s.nextInt, s.next.toList.map(_.asDigit))
  }
  /*

  // 次のスタート位置
  def find0(nums: List[Int], from: Int = 0): Int =
    nums.indexWhere(_ == 0, from)

  // 次のエンド位置
  @scala.annotation.tailrec
  def find0last(nums: List[Int], first: Int): Int = {
    val next = find0(nums, first + 1)
    next match {
      case -1 => first
      case `first` + 1 => find0last(nums, next)
      case _ => next
    }
  }

  // 連続する0のindexのレンジ
  def findRange(nums: List[Int], from: Int = 0): (Int, Int) = {
    val first = find0(nums, from)
    first match {
      case -1 => (-1, -1)
      case _ => (first, find0last(nums, first))
    }
  }

  // 連続する0のindexのレンジの次
  def findRangeNext(nums: List[Int], first: (Int, Int)): (Int, Int) =
    findRange(nums, first._2 + 1)

  // 連続する0のindexたち
    def rangeList(nums: List[Int], before: List[(Int, Int)] = Nil): List[(Int, Int)] = {
//   TODO 重複外す
      nums.indices.foldLeft(Nil){
        (b, c) => {
        }
        findRange(nums, _))
      }
    }

  // 一番連続する0のindex


  // - 隣接する0うち、近いほうをN回探す
  // - 端っこの優先度は下げる
  // - 探したindexをひっくり返した1の長さ



  //  println(result)
   */
}
