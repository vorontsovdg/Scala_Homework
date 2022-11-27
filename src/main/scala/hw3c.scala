/*
Напишите программу, которая рассчитывает для каждого сотрудника отклонение(в процентах) от среднего значения оклада
на уровень всего отдела. В итоговом значении должно учитываться в большую или меньшую сторону отклоняется размер оклада.
На вход вышей программе подаются все значения, аналогичные предыдущей программе, а также список со значениями окладов
сотрудников отдела 100, 150, 200, 80, 120, 75.
 */
import io.StdIn
object hw3c {
  def main(args: Array[String]): Unit = {
    print("Укажите размер годовой зарплаты: ")
    val yearSal = StdIn.readFloat()
    print("Укажите процент премии: ")
    val bonus = hw3b.readBonus()
    print("Укажите размер компенсации питания: ")
    val foodComp = StdIn.readFloat()
    val salary = hw3b.fullSalary(yearSal, bonus, foodComp)
    val listOfSalaries = List(100000f, 150000f, 200000f, 80000f, 120000f, 75000f)
    val salDeviation = salaryDeviation(salary, listOfSalaries)
    val diff = {
      if (salDeviation > 0) {
        s"в большую сторону"
      }
      else {
        s"в меньшую сторону"
      }
    }

    val result = s"Зп сотрудника= $salary, отличается от средней по отделу на ${math.abs(salDeviation)}% $diff "
    println(result)
  }

  def salaryDeviation(salary: Float, listOfSalaries: List[Float]): Float = {
    val avgSalary = listOfSalaries.sum / listOfSalaries.size
    (salary - avgSalary) / avgSalary * 100
  }

}
