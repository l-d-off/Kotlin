/* задание 3
fun main(args: Array<String>)
{
    println("Hello, ${args[0]}!")
}
*/

/* Задание 5
fun main(args: Array<String>)
{
    print("Your favourite language -> ")
    val language = readLine()
    /*
    // first type (if)
    if (language.equals("Kotlin") ||
        language.equals("Prolog"))
        println("Ты подлиза!")
    else
        println("Ты надлиза!")
        */
    /*
    // second type (when)
    when (language)
    {
        "Kotlin", "Prolog" -> println("Ты подлиза!")
        else -> println("Ты надлиза!")
    }
    */
    // third type (when)
    val output =
        when (language) // или when(readLine())
        {
            "Kotlin", "Prolog" -> "Ты подлиза!"
            else -> "Ты надлиза!"
        }
    println(output)
}
*/

/* Задание 6. Работа с числами. Операторы ?. и ?:
fun sumOfNumber(number: Int, sum: Int = 0) : Int
= if (number == 0)
        sum
    else
    {
        val digit = number % 10
        sumOfNumber(number / 10, sum + digit)
    }

fun main(args: Array<String>)
{
    /*
    Использование ?. вызывает метод только в том случае, если значение не равно null,
    в противном случае он просто передает null.
    Использование ?: означает, что значение слева возвращается, если оно не является null,
    в противном случае возвращается значение справа
     */
    print("Number -> ")
    try {
        val number = readLine()?.toInt() ?: 0
        println("Сумма цифр числа $number равна ${sumOfNumber(number)}")
    }
    catch (ex: NumberFormatException)
    {
        println("Некорректный ввод")
    }
}
*/

fun sumOfNumber(number: Int, sum: Int = 0) : Int
        = if (number == 0)
    sum
else
{
    val digit = number % 10
    sumOfNumber(number / 10, sum + digit)
}

fun main(args: Array<String>)
{
    
}