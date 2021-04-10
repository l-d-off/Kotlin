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

/* Задание 2. Работа с числами. Рекурсия вниз. Хвостовая рекурсия.
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
 */

// Задание 3-4. Произведение, максимум, минимум. Рекурсия вверх. Хвостовая рекурсия.
// Сумма цифр числа. Рекурсия вниз. Хвостовая рекурсия.
fun sumOfNumber(number: Int, sum: Int = 0) : Int
= if (number == 0)
    sum
else
    sumOfNumber(number / 10, sum + number % 10)

// Произведение цифр числа. Рекурсия вверх.
fun prodOfDigitsUp(number: Int) : Int
= if (number == 0)
    1
else
    prodOfDigitsUp(number / 10) * (number % 10)

// Произведение цифр числа. Хвостовая рекурсия.
fun prodOfDigitsTail(number: Int, prod: Int = 1) : Int
= if (number == 0)
    prod
else
    prodOfDigitsTail(number / 10, prod * (number % 10))

// Минимум. Рекурсия вверх.
fun minDigitUp(number: Int) : Int
= if (number == 0)
    9
else
{
    val min = minDigitUp(number / 10)
    if (number % 10 < min) number % 10 else min
}

// Минимум. Хвостовая рекурсия.
fun minDigitTail(number: Int, min: Int = 9) : Int
= if (number == 0)
    min
else
    minDigitTail(number / 10, (if (number % 10 < min) number % 10 else min))

// Максимум. Рекурсия вверх.
fun maxDigitUp(number: Int) : Int
= if (number == 0)
    0
else
{
    val max = maxDigitUp(number / 10)
    if (number % 10 > max) number % 10 else max
}

// Максимум. Хвостовая рекурсия.
fun maxDigitTail(number: Int, max: Int = 0) : Int
= if (number == 0)
    max
else
    maxDigitTail(number / 10, (if (number % 10 > max) number % 10 else max))

// Обход числа
fun numberTraversal(number: Int, functionTraversal: (Int) -> Int) : Int =
    functionTraversal(number)

fun main(args: Array<String>)
{
    // :: - ссылка на функцию
    print("Number -> ")
    try {
        val number = readLine()?.toInt() ?: 0
        println("Сумма цифр числа $number равна ${sumOfNumber(number)}")
        println("Произведение цифр числа $number равно ${
            if (number != 0) numberTraversal(number, ::prodOfDigitsUp) else 0}")
        println("Минимальная цифра числа $number равна ${
            if (number != 0) numberTraversal(number, ::minDigitUp) else 0}")
        println("Максимальная цифра числа $number равна ${numberTraversal(number, ::maxDigitUp)}")
    }
    catch (ex: NumberFormatException)
    {
        println("Некорректный ввод")
    }
}