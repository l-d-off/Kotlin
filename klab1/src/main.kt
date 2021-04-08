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

/* Задание 7. Работа с числами.
// сумма цифр числа
fun sumOfNumber(number: Int, sum: Int = 0) : Int
= if (number == 0)
    sum
else
    sumOfNumber(number / 10, sum + (number % 10))

// произведение цифр числа
fun prodOfNumber(number: Int, prod: Int = 1) : Int
= if (number == 0)
    prod
else
    prodOfNumber(number / 10, prod * (number % 10))

// минимальная цифра числа
fun minDigitInNumber(number: Int, min: Int = 9) : Int
= if (number == 0)
    min
else
    minDigitInNumber(number / 10, (if (number % 10 < min) number % 10 else min))

// максимальная цифра числа
fun maxDigitInNumber(number: Int, max: Int = 0) : Int
= if (number == 0)
    max
else
    maxDigitInNumber(number / 10, (if (number % 10 > max) number % 10 else max))

fun main(args: Array<String>)
{
    print("Number -> ")
    try {
        val number = readLine()?.toInt() ?: 0
        println("Сумма цифр числа $number равна ${sumOfNumber(number)}")
        println("Произведение цифр числа $number равно ${
            if (number != 0) prodOfNumber(number) else 0}")
        println("Минимальная цифра числа $number равна ${
            if (number != 0) minDigitInNumber(number) else 0}")
        println("Максимальная цифра числа $number равна ${maxDigitInNumber(number)}")
    }
    catch (ex: NumberFormatException)
    {
        println("Некорректный ввод")
    }
}
*/

// Задание 8. Работа с числами.
// проверка числа на простоту
fun simpleNumber(number: Int, del: Int = number - 1) : Boolean =
    when
    {
        number == 1 -> true
        del == 1 -> true
        number % del == 0 -> false
        else -> simpleNumber(number, del - 1)
    }

// сумма непростых делителей числа
fun sumOfNoSimpleDelOfNumber(number: Int, del: Int = number, sum: Int = 0) : Int =
    when
    {
        (number == 0) -> 0
        (del == 0) -> sum
        (number % del == 0 && !simpleNumber(del)) -> sumOfNoSimpleDelOfNumber(number, del - 1, sum + del)
        else -> sumOfNoSimpleDelOfNumber(number, del - 1, sum)
    }

fun main(args: Array<String>)
{
    print("Number -> ")
    try {
        val number = readLine()?.toInt() ?: 0
        println("Сумма непростых делителей числа $number равна ${sumOfNoSimpleDelOfNumber(number)}")
    }
    catch (ex: NumberFormatException)
    {
        println("Некорректный ввод")
    }
}