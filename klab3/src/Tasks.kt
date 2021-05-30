import java.io.File
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main() {
//    val array: Array<Int> = inputArrayByConsole()
//    //val list = inputListByConsole()
//    println()
//
//    // task 1, 2
//    println("Min array element: ${min(array)}")
//    println("Max array element: ${max(array)}")
//    println("Sum of array elements: ${sum(array)}")
//    println("Mult of array elements: ${mult(array)}")
//
//    // task 3
//    val array = inputArray()
//    print("\nInput result: ")
//    outputArray<Int>(array)
}
// вывод массива
fun<T> outputArray(array: Array<T>) {
    print("${array.joinToString(" ")}")
}

// вывод списка
fun<T> outputList(list: List<T>) {
    print("${list.joinToString(" ")}")
}

// ввод списка с клавиатуры
fun inputListByConsole(): List<Int> {
    print("Input list (in one line, separated by space)\n>: ")

    return try {
        readLine()!!.split(" ").map { it.toInt() }
    }
    catch(e: NumberFormatException) {
        println()
        inputListByConsole()
    }
}

// ввод массива с клавиатуры
fun inputArrayByConsole(): Array<Int> {
    print("Input array (in one line, separated by space)\n>: ")

    return try {
        readLine()!!.split(" ").map { it.toInt() }.toTypedArray()
    }
    catch(e: NumberFormatException) {
        println()
        inputArrayByConsole()
    }
}

// ввод массива из файла (разделитель: пробел)
fun inputArrayByFile(path: String = "ExampleOfArray.txt"): Array<Int> =
    try {
        File(path).readText().split(" ").map { it.toInt() }.toTypedArray()
    }
    catch(e: NullPointerException) { throw e }
    catch(e: java.io.FileNotFoundException) { throw e }
    catch(e: NumberFormatException) { throw e }

// ввод массива из файла (разделитель: пробел)
// специально для задания 3: нужно, чтобы функция была без параметров
fun inputArrayByFileV2(): Array<Int> =
    try {
        File("ExampleOfArray.txt").readText().split(" ").map { it.toInt() }.toTypedArray()
    }
    catch(e: NullPointerException) { throw e }
    catch(e: java.io.FileNotFoundException) { throw e }
    catch(e: NumberFormatException) { throw e }

// ввод списка из файла (разделитель: пробел)
fun inputListByFile(path: String = "ExampleOfList.txt"): List<Int> =
    try {
        File(path).readText().split(" ").map { it.toInt() }
    }
    catch(e: NullPointerException) { throw e }
    catch(e: java.io.FileNotFoundException) { throw e }
    catch(e: NumberFormatException) { throw e }

// ввод списка из файла (разделитель: пробел)
// специально для задания 3: нужно, чтобы функция была без параметров
fun inputListByFileV2(): List<Int> =
    try {
        File("ExampleOfList.txt").readText().split(" ").map { it.toInt() }
    }
    catch(e: NullPointerException) { throw e }
    catch(e: java.io.FileNotFoundException) { throw e }
    catch(e: NumberFormatException) { throw e }

// task 3: спросить пользователя, откуда читать данные,
// в зависимости от ответа читать или с клавиатуры, или из файла,
// для выполнения данной задачи построить функцию,
// возвращающую функцию, возвращающую массив
fun selectArrayInputMethod(): () -> Array<Int> {
    println("How do you want to input array?")
    println("1. Console")
    println("2. Standard file\n")
    print(">: ")

    return when(readLine()) {
        "1" -> {
            println()
            ::inputArrayByConsole
        }
        "2" -> ::inputArrayByFileV2
        else -> {
            println("Invalid method. Try again!\n")
            selectArrayInputMethod()
        }
    }
}

// task 3: и для реализации чтения результат этой функции
fun inputArray(): Array<Int> {
    return try {
        selectArrayInputMethod()()
    }
    catch(e: Exception) {
        when(e) {
            is NullPointerException, is java.io.FileNotFoundException -> {
                println("\nError: ${e.message}! I'm sorry, select console :(\n")
                inputArray()
            }
            is NumberFormatException -> {
                println("\nError: ${e.message}! Check the file.\n")
                inputArray()
            }
            else -> throw e
        }
    }
}

// task 1, 2: написать одну функцию arrayOp() с применением
// хвостовой рекурсии, перебирающую элементы массива, принимающую
// как аргументы массив, лямбда выражение и инициализирующее значение
// *переименовала arrayOp в listOp для логичности*
tailrec fun arrayOp(array: Iterator<Int>, f : (Int, Int) -> Int, accum: Int = 0): Int =
    if (array.hasNext())
        arrayOp(array, f, f(array.next(), accum))
    else accum

// task 1, 2: написать 4 функции для суммы, произведения,
// мин и макс, использующих функцию arrayOp()

fun min(array: Array<Int>): Int =
    arrayOp(array.iterator(), { a: Int, b: Int -> if (a < b) a else b}, array.first())

fun max(array: Array<Int>): Int =
    arrayOp(array.iterator(), { a: Int, b: Int -> if (a > b) a else b}, array.first())

fun sum(array: Array<Int>): Int =
    arrayOp(array.iterator(), { a: Int, b: Int -> a + b})

fun mult(array: Array<Int>): Int =
    arrayOp(array.iterator(), { a: Int, b: Int -> a * b}, 1)
