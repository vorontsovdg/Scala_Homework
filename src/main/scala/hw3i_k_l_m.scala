/*
*Попробуйте деанонимизировать ваших сотрудников – составьте структуру, которая позволит иметь знания о том,
* сколько зарабатывает каждый сотрудник(Фамилия и имя).
 */
/*
*Ваши сотрудники остались недовольны и просят индексацию на уровень рынка. Попробуйте повторить ту же операцию,
* как и в предыдущем задании, но теперь вам нужно проиндексировать зарплаты на процент отклонения от среднего по рынку
* с учетом уровня специалиста. На вход вашей программе подается 3 значения – среднее значение зарплаты на рынке для
* каждого уровня специалистов(junior, middle и senior)
 */
/*
*Выведите фамилию и имя сотрудников с самой высокой и самой низкой зарплатой(только не рассказывайте им об этом факте).
 */



import scala.collection.mutable.ListBuffer
import scala.util.Random
object hw3i_k_l_m {
  def main(args: Array[String]): Unit = {
    val listOfSalaries = ListBuffer(100000f, 150000f, 200000f, 80000f, 120000f, 75000f, 350000f, 90000f, 130000f)
    val listOfFirstNames = List("Andrei", "Semen", "Igor", "Anton", "Aleksei", "Viktor", "Stas", "Ivan", "Petr")
    val listOfLastNames = List("Ivanov", "Petrov", "Sidorov", "Vorontsov", "Laskov", "Krotov", "Galkin", "Plesnikov", "Sharipov")

    //здесь мы генерим список сотрудников
    val employees = new ListBuffer[employee]
    for (i <- listOfSalaries) {
      var name = Random.shuffle(listOfFirstNames).head
      var surname = Random.shuffle(listOfLastNames).head
      var lvl = setLvl(i)
      employees.addOne(new employee(name,
        surname,
        lvl = lvl, salary = i))
    }
    //Здесь выводим инфо о нашем списке сотрудников
    println("Список сотрудников")
    for (emp <- employees){println(emp.info())}

    //Пробуем поднять зп на отклонение от рынка
    val salaryMarket: Map[String, Float] = List("Junior" -> 90000f,
      "Middle" -> 160000f,
      "Senior" -> 210000f).toMap

    println(salaryMarket("Junior"))
    //Для каждого специалиста пробуем пересчитать зарплату
    for (emp <- employees) {
      var percent = rizePercent(emp, salaryMarket, employees)
      emp.giveRise(percent)
    }
    //выводим обновленную инфо
    println("Сотрудники после повышения зарплаты")
    for (emp <- employees) {println(emp.info())}

    //Выводим сотрудников с самой высокой и низкой ЗП
    val lowSalary = s"Сотрудник с самой низкой ЗП:\n${employees.minBy(x=>x.salary).info()}"
    val highSalary = s"Сотрудник с самой высокой ЗП:\n${employees.maxBy(x=>x.salary).info()}"
    println(lowSalary)
    println(highSalary)

    /*
    *Попробуйте запутать тех, кто может случайно наткнуться на эти данные – удалите для каждого сотрудника имя,
    * переведите строку в нижний регистр,
    * удалите гласные
    * и разверните оставшиеся символы справа налево(abc -> cb).
     */
    //Сделал ч\з метод fuzz в классе
    for (emp <- employees) {println(s"Сотрудник: ${emp.info()}, после запутывания: ${emp.fuzz()}")}

  }




  def rizePercent(employee: employee, salaryMarket: Map[String, Float], listOfEmployees: ListBuffer[employee]): Float = {
    val avgDepartmentSalary: Float = {
      val groupedLvl = listOfEmployees.groupBy(_.lvl)(employee.lvl)
      groupedLvl.toList.map(x => x.salary).sum / groupedLvl.toList.map(x => x.salary).size
    }
    if (avgDepartmentSalary >= salaryMarket(employee.lvl)) {
      0f
    }
    else {
      salaryMarket(employee.lvl) / avgDepartmentSalary - 1
    }
  }

  def setLvl(salary: Float): String = {
    if (salary < 120000) {"Junior"}
    else if (salary >= 120000 && salary <= 180000) {"Middle"}
    else {"Senior"}
  }

}
//это наш класс сотрудник
class employee(val firstName: String, val lastName: String, var lvl: String, var salary: Float) {
  def giveRise(percent: Double): Unit = {
    this.salary = (this.salary + this.salary * percent).toFloat
  }
  def info():String = {
    s"${this.firstName} ${this.lastName} - ${this.lvl}, salary = ${this.salary}"
  }
  def fullName:String = {
    s"${this.firstName} ${this.lastName}"
  }
  def fuzz(): String = {
    val vowels = "aeiouy"
    val x = for (i <- this.lastName.toLowerCase if !vowels.contains(i)) yield i
    x.reverse
  }
}
