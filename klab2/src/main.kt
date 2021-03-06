import java.io.File
import kotlin.math.pow

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

/* Задание 8.
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
 */

/* Задание 9.22
// читаем файл в строку
fun fWordsInStr(fileName: String) = File(fileName).readText()

// бьём строку на имена
fun splitStrToWords(wordsInStr: String) = wordsInStr.split(",")

// удаляем кавычки из имён
fun rmQuotesFromWords(wordsWithQuotes: List<String>) : MutableList<String>
{
    val words: MutableList<String> = mutableListOf()
    wordsWithQuotes.forEach {
        words.add(it.removeSuffix("\"").removePrefix("\""))
    }
    return words
}

// набор функций для получения набора слов из файла
fun listOfWords(fileName: String) : List<String>
{
    // читаем файл в строку
    val wordsInStr = fWordsInStr(fileName)

    // бьём строку на имена и сортируем
    var wordsWithQuotes = splitStrToWords(wordsInStr)
    wordsWithQuotes = wordsWithQuotes.sorted()

    // удаляем кавычки из имён
    return rmQuotesFromWords(wordsWithQuotes)
}

// получаем лист со значениями из суммы букв
fun fWordScores(words: List<String>) : MutableList<Int>
{
    val wordScores: MutableList<Int> = mutableListOf()
    words.forEachIndexed() {
            index: Int, s: String ->
        run {
            var wordScore = 0
            s.forEach {
                wordScore += it.toInt() - 64
            }
            wordScore *= (index + 1)
            wordScores.add(wordScore)
        }
    }
    return wordScores
}

// получаем общее значение
fun fTotalWordScores(wordScores: MutableList<Int>) : Long
{
    var totalWordScores = 0L
    wordScores.forEach {
        totalWordScores += it
    }
    return totalWordScores
}

fun task922(words: List<String>) : Long
{
    // получаем лист со значениями из суммы букв
    val wordScores = fWordScores(words)
/*
        wordScores.forEachIndexed() {
                index: Int, s: Int ->
            println("${index + 1}: $s")
        }
*/
    // получаем общее значение
    return fTotalWordScores(wordScores)
}

fun main(args: Array<String>) {
    val fileName = "names.txt"
    val words = listOfWords(fileName)

    println("Total score: ${task922(words)}")
}
 */

/* Задание 9.42
// читаем файл в строку
fun fWordsInStr(fileName: String) = File(fileName).readText()

// бьём строку на имена
fun splitStrToWords(wordsInStr: String) = wordsInStr.split(",")

// удаляем кавычки из имён
fun rmQuotesFromWords(wordsWithQuotes: List<String>) : MutableList<String>
{
    val words: MutableList<String> = mutableListOf()
    wordsWithQuotes.forEach {
        words.add(it.removeSuffix("\"").removePrefix("\""))
    }
    return words
}

// набор функций для получения набора слов из файла
fun listOfWords(fileName: String) : List<String>
{
    // читаем файл в строку
    val wordsInStr = fWordsInStr(fileName)

    // бьём строку на имена и сортируем
    var wordsWithQuotes = splitStrToWords(wordsInStr)
    wordsWithQuotes = wordsWithQuotes.sorted()

    // удаляем кавычки из имён
    return rmQuotesFromWords(wordsWithQuotes)
}

// получаем лист со значениями из суммы букв
fun fWordScores(words: List<String>) : MutableList<Int>
{
    val wordScores: MutableList<Int> = mutableListOf()
    words.forEach { itWords ->
        var wordScore = 0
            itWords.forEach {
                wordScore += it.toInt() - 64
            }
            wordScores.add(wordScore)
    }
    return wordScores
}

// проверка соответствия значения слова треугольному числу
fun isWordScoreEquivalentToNumber(score: Int, current: Int = 1) : Boolean =
    when
    {
        current * (current + 1) / 2 == score -> true
        current * (current + 1) / 2 > score -> false
        else -> isWordScoreEquivalentToNumber(score, current + 1)
    }

// получаем общее значение
fun fTotalWordScores(wordScores: MutableList<Int>) : Int
{
    var totalWordScores = 0
    wordScores.forEach {
        if (isWordScoreEquivalentToNumber(it))
            ++totalWordScores
    }
    return totalWordScores
}

fun task942(words: List<String>) : Int
{
    // получаем лист со значениями из суммы букв
    val wordScores = fWordScores(words)
/*
        wordScores.forEachIndexed() {
                index: Int, s: Int ->
            println("${index + 1}: $s")
        }
*/
    // получаем общее значение
    return fTotalWordScores(wordScores)
}

fun main(args: Array<String>) {
    val fileName = "words.txt"
    val words = listOfWords(fileName)

    println("Total score: ${task942(words)}")
}
 */

// Задание 9.62
// ищем факториал числа
fun factorial(number: Int) : Int =
    when (number)
    {
        0 -> 1
        1 -> 1
        else -> factorial(number - 1) * number
    }

// ищем куб числа
fun findNumber(number: Long = 5L) : Long
{
    val cube = number * number * number
    val listFromCube = splitNumberToList(cube)
    // уникальный list (set)
    val setFromCube = listFromCube.toSet()
    // величина, на которую поделим итог
    var keptFactorials = 1
    setFromCube.forEach {
        keptFactorials *= factorial(countOfEqualsInList(listFromCube, it))
    }
    val countOfPermutation = findCountOfPermutation(listFromCube, listFromCube.size - 1) / keptFactorials
    //println("$cube: -> $countOfPermutation")
    return if (countOfPermutation == 5)
        cube
    else
        findNumber(number + 1L)
}

// сколько раз в листе встретится элемент
fun countOfEqualsInList(list: List<Long>, el: Long) : Int
{
    var countOfEquals = 0
    list.forEach {
        if (el == it)
            ++countOfEquals
    }
    return countOfEquals
}

// бьём число на лист
fun splitNumberToList(number: Long, list: MutableList<Long> = mutableListOf()) : List<Long> =
    if (number == 0L)
        list
    else {
        list.add(0, number % 10)
        splitNumberToList(number / 10, list)
    }

// проверка на наличие у числа кубического корня
fun findCubeRoot(cube: Long, root: Long = 5) : Boolean
{
    val curCube = root * root * root
    return when
    {
        curCube == cube -> true
        curCube > cube -> false
        else -> findCubeRoot(cube, root + 1L)
    }
}

// ищем количество перестановок для заданного куба числа
fun findCountOfPermutation(list: List<Long>, powOf10: Int, cur: Long = 0) : Int
{
    val curCube = findCubeRoot(cur)
    var countOfPermutation = 0

    // если лист пустой, у числа есть куб и число при делении на степень числа 10 не равно 0
    if (list.isEmpty())
    {
        return if (curCube) {
            if (cur / (10.0).pow(powOf10).toLong() != 0L)
                1
            else
                0
        } else
            0
    }
    else {
        list.forEach {
            val cube = cur * 10L + it
            countOfPermutation += findCountOfPermutation(list.minus(it), powOf10, cube)
        }
    }

    return countOfPermutation
}

fun main(args: Array<String>)
{
    println("Wait for a minute")
    println(findNumber())
}