object hw3a {
  def main(args: Array[String]): Unit = {
    val greeting = "Hello, Scala!"
    //выводим фразу "Hello Scala" справа налево
    println(greeting.reverse)
    //переводит всю фразу в нижний регистр
    println(greeting.toLowerCase())
    //удаляет символ !
    println(greeting.replace("!", ""))
    //Добавляет в конец фразу "and goodbye python!"
    println(s"$greeting and goodbye python!")
  }
}
