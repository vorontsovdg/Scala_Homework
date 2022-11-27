/*
Напишите программу, которая вычисляет ежемесячный оклад сотрудника после вычета налогов.
На вход вашей программе подается значение годового дохода до вычета налогов,
размер премии – в процентах от годового дохода и компенсация питания.
 */
import scala.io.StdIn

object hw3b {
  def main(args: Array[String]): Unit = {
    print("Укажите размер годовой зарплаты: ")
    val yearSal = StdIn.readFloat()
    print("Укажите процент премии: ")
    val bonus = readBonus()
    print("Укажите размер компенсации питания: ")
    val foodComp = StdIn.readFloat()
    println(s"Ежемесячный оклад сотрудника после вычета налогов: ${fullSalary(yearSal, bonus, foodComp)}")
  }

  def fullSalary(yearlySalary: Float, bonus: Float, foodCompensation: Float): Float = {
    //подразумевается, что компенсация питанию также за год
    (yearlySalary + yearlySalary * bonus + foodCompensation) / 12 * 0.87f
  }

  def readBonus(): Float = {
    var B = StdIn.readLine()
    if (B.trim.last == '%') {B = B.init}
    if (B.toFloat > 1) {
      B.toFloat / 100
   }
    else {
      B.toFloat
    }


  }
}
