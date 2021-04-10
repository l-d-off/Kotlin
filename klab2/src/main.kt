/* Задание 1. Работа с числами. Рекурсия вверх.
fun sumOfNumber(number: Int) : Int
= if (number == 0)
    0
else
    sumOfNumber(number / 10) + number % 10

fun main(args: Array<String>)
{
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

// Задание 2. Работа с числами. Рекурсия вниз. Хвостовая рекурсия.
fun sumOfNumber(number: Int, sum: Int = 0) : Int
= if (number == 0)
    sum
else
    sumOfNumber(number / 10, sum + number % 10)

fun main(args: Array<String>)
{
    /*
    Хвостовая рекурсия - это особый случай рекурсии, когда вызывающая функция
    больше не выполняет вычисления после выполнения рекурсивного вызова.
    Пример:
    return 5
    return sumOfNumber(a, b)
    return sumOfNumber(a, b + number % 10)
    Антипример:
    return 5 * n
    return n * sumOfNumber(a, b)
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