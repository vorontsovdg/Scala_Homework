import scala.collection.mutable.ListBuffer
import scala.io.StdIn

/*
 Также в вашу команду пришли два специалиста с окладами 350 и 90 тысяч рублей.
 Попробуйте отсортировать список сотрудников по уровню оклада от меньшего к большему.
 */
object hw3e_f_g {
  def main(args: Array[String]): Unit = {
    var listOfSalaries = ListBuffer(100000f, 150000f, 200000f, 80000f, 120000f, 75000f)
    listOfSalaries.addAll(List(350000f, 90000f))
    //Сортируем и выводим все зарплаты по возрастанию
    listOfSalaries = listOfSalaries.sorted
    for (i <- listOfSalaries) {
      println(i)
    }
    /*
    Кажется, вы взяли в вашу команду еще одного сотрудника и предложили ему оклад 130 тысяч.
    Вычислите самостоятельно номер сотрудника в списке так, чтобы сортировка не нарушилась и добавьте его на это место.
     */
    val newEmpSal = 130000f
    for (i <- 0 until listOfSalaries.length) {
      if (newEmpSal <= listOfSalaries(i)){
        listOfSalaries.insert(i, newEmpSal)
      }
      else {
        if (i == listOfSalaries.length - 1) {listOfSalaries.addOne(newEmpSal)}
      }
    }
    //выводим отсортированный список с добавленной зп
    println(listOfSalaries)
    /*
    Попробуйте вывести номера сотрудников из полученного списка, которые попадают под категорию middle.
    На входе программе подается «вилка» зарплаты специалистов уровня middle.
     */
    print("Введите нижнюю границу ЗП для миддла ")
    val low = StdIn.readFloat()
    print("Введите верхнюю границу ЗП для миддла ")
    val high = StdIn.readFloat()
    for (i <- 0 until listOfSalaries.length) {
      if (listOfSalaries(i) >= low && listOfSalaries(i) <= high) {
        println(i)
      }
    }

  }
}
