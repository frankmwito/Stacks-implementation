import sun.util.locale.LocaleUtils.isEmpty
import java.util.Scanner


// reverse a string using stack
class Stack<T> (
    private val elements: MutableList<T> = mutableListOf()
){
    fun push(item: T){
        elements.add(item)
    }
    fun pop(): T?{
        if (isEmpty()){
            println("Stack is empty")
            return null
        }
        return elements.removeAt(elements.size-1)
    }
    fun isEmpty():Boolean{
        return elements.isEmpty()
    }
    fun peek(): T?{
        return elements.lastOrNull()
    }
    override fun toString(): String {
        return elements.toString()
    }
}
fun reverseStringUsingStack(input: String): String{
    val stack = Stack<Char>()
    for (char in input){
        stack.push(char)
    }
    val reversedString = StringBuilder()
    while (!stack.isEmpty()){
        reversedString.append(stack.pop())
    }
    return reversedString.toString()
}
fun main() {
    val reader = Scanner(System.`in`)
    println("Enter any string of choice:")
    val inputString = reader.next()

    val reversedString = reverseStringUsingStack(inputString)
    println("Reversed String is: $reversedString")
}