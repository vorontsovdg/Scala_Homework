import scala.collection.mutable.ListBuffer
/*
 Также в вашу команду пришли два специалиста с окладами 350 и 90 тысяч рублей.
 Попробуйте отсортировать список сотрудников по уровню оклада от меньшего к большему.
 */
object hw3e_f {
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
    val newEmpSal = 4130000f
    for (i <- 0 until listOfSalaries.length) {
      if (newEmpSal <= listOfSalaries(i)){
        listOfSalaries.insert(i, newEmpSal)
      }
      else {
        if (i == listOfSalaries.length - 1) {listOfSalaries.addOne(newEmpSal)}
      }
    }

    println(listOfSalaries)

  }
}
