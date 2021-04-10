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

// Задание 3-4-5. Произведение, максимум, минимум. Рекурсия вверх. Хвостовая рекурсия.
// Сумма цифр числа. Рекурсия вниз. Хвостовая рекурсия.
fun sumOfNumber(number: Int, conditionFor: (Int) -> Boolean, sum: Int = 0) : Int
= if (number == 0)
    sum
else {
    if (conditionFor(number % 10))
        sumOfNumber(number / 10, conditionFor, sum + number % 10)
    else
        sumOfNumber(number / 10, conditionFor, sum)
}

// Произведение цифр числа. Рекурсия вверх.
fun prodOfDigitsUp(number: Int, conditionFor: (Int) -> Boolean) : Int
= if (number == 0)
    1
else {
    if (conditionFor(number % 10))
        prodOfDigitsUp(number / 10, conditionFor) * (number % 10)
    else
        prodOfDigitsUp(number / 10, conditionFor)
}

// Произведение цифр числа. Хвостовая рекурсия.
fun prodOfDigitsTail(number: Int, conditionFor: (Int) -> Boolean, prod: Int = 1) : Int
= if (number == 0)
    prod
else {
    if (conditionFor(number % 10))
        prodOfDigitsTail(number / 10, conditionFor, prod * (number % 10))
    else
        prodOfDigitsTail(number / 10, conditionFor, prod)
}

// Минимум. Рекурсия вверх.
fun minDigitUp(number: Int, conditionFor: (Int) -> Boolean) : Int
= if (number == 0)
    9
else
{
    val min = minDigitUp(number / 10, conditionFor)
    if (number % 10 < min && conditionFor(number % 10)) number % 10 else min
}

// Минимум. Хвостовая рекурсия.
fun minDigitTail(number: Int, conditionFor: (Int) -> Boolean, min: Int = 9) : Int
= if (number == 0)
    min
else
    minDigitTail(number / 10, conditionFor,
        (if (number % 10 < min && conditionFor(number % 10)) number % 10 else min))

// Максимум. Рекурсия вверх.
fun maxDigitUp(number: Int, conditionFor: (Int) -> Boolean) : Int
= if (number == 0)
    0
else
{
    val max = maxDigitUp(number / 10, conditionFor)
    if (number % 10 > max && conditionFor(number % 10)) number % 10 else max
}

// Максимум. Хвостовая рекурсия.
fun maxDigitTail(number: Int, conditionFor: (Int) -> Boolean, max: Int = 0) : Int
= if (number == 0)
    max
else
    maxDigitTail(number / 10, conditionFor,
        (if (number % 10 > max && conditionFor(number % 10)) number % 10 else max))

// Обход числа
fun numberTraversal(number: Int, conditionFor: (Int) -> Boolean,
                    functionTraversal: (Int, (Int) -> Boolean) -> Int) : Int =
    functionTraversal(number, conditionFor)

// Дополнительная функция-корректор для правильного вывода результата
// false, если все цифры не удовлетворяют условию
fun corrector(number: Int, conditionFor: (Int) -> Boolean) : Boolean =
    when
    {
        number == 0 -> false
        conditionFor(number % 10) -> true
        else -> corrector(number / 10, conditionFor)
    }

fun main(args: Array<String>)
{
    // :: - ссылка на функцию
    val conditionForDigit = {digit: Int -> digit < 5}
    print("Number -> ")
    try {
        val number = readLine()?.toInt() ?: 0
        println("Сумма цифр числа $number равна " +
                "${numberTraversal(number, conditionForDigit, ::sumOfNumber)}")
        println("Произведение цифр числа $number равно ${
            if (corrector(number, conditionForDigit))
                numberTraversal(number, conditionForDigit, ::prodOfDigitsUp) else 0}")
        println("Минимальная цифра числа $number равна ${
            if (corrector(number, conditionForDigit))
                numberTraversal(number, conditionForDigit, ::minDigitUp) else 0}")
        println("Максимальная цифра числа $number равна " +
                "${numberTraversal(number, conditionForDigit, ::maxDigitUp)}")
    }
    catch (ex: NumberFormatException)
    {
        println("Некорректный ввод")
    }
}

/* Задание 6. Проверка.
Функция-фильтр: цифра < 5

Пример 1.
Число: 198232455
Функция: сумма
Результат: 12
Пояснение: 1 + 2 + 3 + 2 + 4 = 12

Пример 2.
Число: 101010109
Функция: максимум
Результат: 1
Пояснение: первая цифра числа равна 1 - это и есть максимум, далее нет совпадения условий

Пример 3.
Число: 4848962
Функция: произведение
Результат: 32
Пояснение: 4 * 4 * 2 = 32
*/