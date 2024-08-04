import java.util.*

// Class for Balanced Parenthesis check using Stack
class BalancedParenthesis<T>(
    private val elements: MutableList<T> = mutableListOf()
) {
    fun push(item: T) {
        elements.add(item)
    }

    fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    fun pop(): T? {
        if (isEmpty()) {
            return null
        }
        return elements.removeAt(elements.size - 1)
    }

    fun peek(): T? {
        return elements.lastOrNull()
    }

    override fun toString(): String {
        return elements.toString()
    }
}

// Function to check if parentheses are balanced
fun isBalancedParenthesis(input: String): Boolean {
    val stack = BalancedParenthesis<Char>()
    val parenthesesMap = mapOf(')' to '(', '}' to '{', ']' to '[')

    for (char in input) {
        if (char in parenthesesMap.values) {
            stack.push(char)
        } else if (char in parenthesesMap.keys) {
            if (stack.isEmpty() || stack.pop() != parenthesesMap[char]) {
                return false
            }
        }
    }
    return stack.isEmpty()
}

fun main() {
    val reader = Scanner(System.`in`)
    println("Enter a string with or without parenthesis:")
    val inputString = reader.nextLine()

    val isBalanced = isBalancedParenthesis(inputString)
    if (isBalanced) {
        println("The string has balanced parentheses.")
    } else {
        println("The string does not have balanced parentheses.")
    }
}
