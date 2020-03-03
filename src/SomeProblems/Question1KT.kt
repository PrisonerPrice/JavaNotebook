package SomeProblems

import java.util.*

fun main(args: Array<String>) {
    Solution.print(399);
}

object Solution {

    fun print(n: Int) {
        val stack = ArrayDeque<LinkedList<Int>>()
        var remainder = n
        var minus = 1000000
        while (minus > 0) {
            val curr = LinkedList<Int>()
            while (remainder - minus >= 0) {
                curr.add(minus)
                remainder -= minus
            }
            if (!curr.isEmpty()) stack.push(curr)
            minus /= 10
        }
        while (!stack.isEmpty()) {
            val small = stack.pop()
            if (!stack.isEmpty()) {
                val large = stack.pop()
                val lenS = small.size
                val lenL = large.size
                var i = 0
                while (i < lenS && i < lenL) {
                    large[i] = small[i] + large[i]
                    i++
                }
                if (lenS > lenL) {
                    for (x in i until lenS) large.add(small[i])
                }
                stack.push(large)
            } else {
                stack.push(small)
                break
            }
        }
        val result = StringBuilder()
        var count = 0

        val curr = stack.pop()
        count += curr.size
        for (x in curr.size - 1 downTo 0) {
            result.append(curr[x])
            result.append(" ")
        }

        println(count)
        println(result.toString().trim())
    }
}