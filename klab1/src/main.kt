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

/* Задание 8-9. Работа с числами.
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