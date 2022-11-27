import scala.collection.mutable.ListBuffer

/*
Попробуйте рассчитать новую зарплату сотрудника, добавив(или отняв, если сотрудник плохо себя вел) необходимую сумму
с учетом результатов прошлого задания. Добавьте его зарплату в список и вычислите значение
самой высокой зарплаты и самой низкой.
 */

object hw3d {
  def main(args: Array[String]): Unit = {
    val inputData = hw3b.input()
    val yearSal = inputData(0)
    val bonus = inputData(1)
    val foodComp = inputData(2)
    val listOfSalaries = ListBuffer(100000f, 150000f, 200000f, 80000f, 120000f, 75000f)
    val salary = hw3b.fullSalary(yearSal, bonus, foodComp)
    println(s"Зарплата сотрудника: $salary")
    print("Введите %, на который нужно скорректировать ЗП: ")
    val percent = hw3b.readBonus()
    val newSalary = {
      if (percent > 0) {
        salary + salary * percent
      }
      else {
        salary - salary * math.abs(percent)
      }
    }
    println(s"Зарплата до корректировки - $salary, после: $newSalary")
    listOfSalaries.addOne(newSalary)
    println(s"Минимальная зарплата в отделе: ${listOfSalaries.min}, а максимальная: ${listOfSalaries.max}")
  }
}
