/*
*Попробуйте деанонимизировать ваших сотрудников – составьте структуру, которая позволит иметь знания о том,
* сколько зарабатывает каждый сотрудник(Фамилия и имя).
 */

import scala.collection.mutable.ListBuffer
import scala.util.Random
object hw3k {
  def main(args: Array[String]): Unit = {
    val listOfSalaries = ListBuffer(100000f, 150000f, 200000f, 80000f, 120000f, 75000f, 350000f, 90000f, 130000f)
    val listOfFirstNames = List("Andrei", "Semen", "Igor", "Anton", "Aleksei", "Viktor", "Stas", "Ivan", "Petr")
    val listOfLastNames = List("Ivanov", "Petrov", "Sidorov", "Vorontsov", "Laskov", "Krotov", "Galkin", "Plesnikov", "Sharipov")
    //здесь мы генерим список сотрудников
    val employees = new ListBuffer[employee]
    for (i <- listOfSalaries) {
      var name = Random.shuffle(listOfFirstNames).head
      var surname = Random.shuffle(listOfLastNames).head
      var lvl = {
        if (i < 120000) {"Junior"}
        else if (i >= 120000 && i <= 180000) {"Middle"}
        else {"Senior"}
      }
      employees.addOne(new employee(name,
        surname,
        lvl = lvl, salary = i))
    }
    //Здесь выводим инфо о нашем списке сотрудников
    for (emp <- employees){println(emp.info())}

  }
  def setLvl(salary: Float): String = {
    if (salary < 120000) {"Junion"}
    else if (salary >= 120000 && salary <= 180000) {"Middle"}
    else {"Senior"}
  }

}
//это наш класс сотрудник
class employee(val firstName: String, val lastName: String, var lvl: String, var salary: Float) {
  def giveRize(percent: Double): Unit = {
    this.salary = (this.salary + this.salary * percent).toFloat
  }
  def info():String = {
    s"${this.firstName} ${this.lastName} - ${this.lvl}, salary = ${this.salary}"
  }
}
