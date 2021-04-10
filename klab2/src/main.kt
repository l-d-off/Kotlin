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

/* Задание 3-4-5. Произведение, максимум, минимум. Рекурсия вверх. Хвостовая рекурсия.
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
 */

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

/* Задание 7. Работа с числами. Хвостовая рекурсия и тело-выражение.
// проверка числа на простоту
fun simpleNumber(number: Int, del: Int = number - 1) : Boolean =
    when
    {
        number == 1 -> true
        del == 1 -> true
        number % del == 0 -> false
        else -> simpleNumber(number, del - 1)
    }

// Подзадание 1. Сумма непростых делителей числа.
fun sumOfNoSimpleDelOfNumber(number: Int, del: Int = number, sum: Int = 0) : Int =
    when
    {
        (number == 0) -> 0
        (del == 0) -> sum
        (number % del == 0 && !simpleNumber(del)) -> sumOfNoSimpleDelOfNumber(number, del - 1, sum + del)
        else -> sumOfNoSimpleDelOfNumber(number, del - 1, sum)
    }

// Подзадание 2. Количество цифр числа, меньших 3.
fun countDigitsLess3(number: Int, count: Int = 0) : Int =
    when
    {
        (number == 0) -> count
        (number % 10 < 3) -> countDigitsLess3(number / 10, count + 1)
        else -> countDigitsLess3(number / 10, count)
    }

// Подзадание 3. Количество чисел, которые
// не являются делителями исходного числа
// не взаимно простые с ним
// взаимно простые с суммой простых цифр этого числа

// НОД двух чисел
fun nodTwoNumbers(number1: Int, number2: Int, nod: Int = (if (number1 > number2) number2 else number1)) : Int =
    when
    {
        (number1 == 0 || number2 == 0) -> -1
        (number1 % nod == 0 && number2 % nod == 0) -> nod
        else -> nodTwoNumbers(number1, number2, nod - 1)
    }

// Сумма простых цифр числа
fun sumOfSimpleDigitsOfNumber(number: Int, sum: Int = 0) : Int =
    when
    {
        (number == 0) -> sum
        simpleNumber(number % 10) -> sumOfSimpleDigitsOfNumber(number / 10, sum + (number % 10))
        else -> sumOfSimpleDigitsOfNumber(number / 10, sum)
    }

// Основное подзадание 3
fun task8method3(number: Int, del: Int = number - 1, count: Int = 0) : Int =
    when
    {
        (del == -1 || del == 0) -> 0
        (del == 1) -> count
        (
                number % del != 0 &&
                        nodTwoNumbers(number, del) != 1 &&
                        nodTwoNumbers(sumOfSimpleDigitsOfNumber(number), del) == 1
                ) -> task8method3(number, del - 1, count + 1)
        else -> task8method3(number, del - 1, count)
    }

fun continueMode() : String
{
    print("Continue? y/n -> ")
    return when (readLine()) {
        "y" -> "mainRelease"
        "n" -> "return"
        else -> continueMode()
    }
}

fun mainRelease()
{
    print("Number -> ")
    try {
        val number = readLine()?.toInt() ?: 0
        print("Method 1/2/3 -> ")
        when(readLine()?.toInt() ?: 1)
        {
            1 -> println("Сумма непростых делителей числа $number: ${sumOfNoSimpleDelOfNumber(number)}")
            2 -> println("Количество цифр числа $number, меньших 3: ${countDigitsLess3(number)}")
            3 -> println("Количество чисел по заданию 3: ${task8method3(number)}")
            else -> println("Такого метода нет в списке")
        }
    }
    catch (ex: NumberFormatException)
    {
        println("Некорректный ввод")
    }

    when(continueMode())
    {
        "mainRelease" -> mainRelease()
        "return" -> return
    }
}

fun main(args: Array<String>)
{
    mainRelease()
}
 */

// Задание 8.
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

// Функция op
fun op(method: Int) : (Int, (Int) -> Boolean) -> Int =
    when(method)
    {
        1 -> ::sumOfNumber
        2 -> ::prodOfDigitsUp
        3 -> ::minDigitUp
        4 -> ::maxDigitUp
        else -> ::sumOfNumber
    }

// Функция для вывода
fun opDescription(method: Int, number: Int) : String =
    when(method)
    {
        1 -> "Сумма цифр числа $number равна "
        2 -> "Произведение цифр числа $number равно "
        3 -> "Минимальная цифра числа $number равна "
        4 -> "Максимальная цифра числа $number равна "
        else -> "Сумма цифр числа $number равна "
    }

fun main(args: Array<String>)
{
    // :: - ссылка на функцию
    val conditionForDigit = {digit: Int -> digit < 5}
    print("Number -> ")
    try {
        val number = readLine()?.toInt() ?: 0
        print("Method sum - 1, prod - 2, min - 3, max - 4 -> ")
        val methodChoose = readLine()?.toInt() ?: 0
        println(opDescription(methodChoose, number) +
                "${numberTraversal(number, conditionForDigit, op(methodChoose))}")
    }
    catch (ex: NumberFormatException)
    {
        println("Некорректный ввод")
    }
}