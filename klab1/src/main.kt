/* задание 3
fun main(args: Array<String>)
{
    println("Hello, ${args[0]}!")
}
*/

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