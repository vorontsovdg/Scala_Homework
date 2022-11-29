import java.text.Bidi
import scala.annotation.tailrec
object hw3o {
  def main(args: Array[String]): Unit = {
    //обычная рекурсия
    def powerOfTwo(n: Int): BigInt = {
      if (n==0) {
        1
      }
      else {
        if (n==1) {
          2
        }
        else {
          2 * powerOfTwo(n-1)
        }
      }
    }

//Хвостовая
    def powerOfTwoTailrec(n: Int): BigInt = {
      @tailrec
      def loop(x: Int, acc:BigInt = 2): BigInt = {
        if (x==0) {
          1
        }
        else {
          if (x == 1) {
            acc
          }
          else {
            loop(x - 1, acc * 2)
          }
        }
      }
      loop(n)
    }


    println(powerOfTwoTailrec(0))
  }
}
