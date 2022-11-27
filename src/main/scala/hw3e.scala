import scala.collection.mutable.ListBuffer
/*
 Также в вашу команду пришли два специалиста с окладами 350 и 90 тысяч рублей.
 Попробуйте отсортировать список сотрудников по уровню оклада от меньшего к большему.
 */
object hw3e {
  def main(args: Array[String]): Unit = {
    val listOfSalaries = ListBuffer(100000f, 150000f, 200000f, 80000f, 120000f, 75000f)
    listOfSalaries.addAll(List(350000f, 90000f))
    //Сортируем и выводим все зарплаты по возрастанию
    for (i <- listOfSalaries.sorted) {
      println(i)
    }

  }
}
