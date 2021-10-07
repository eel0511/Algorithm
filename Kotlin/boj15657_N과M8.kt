import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

private var N = 0
private var M = 0
private lateinit var arr: Array<Int>
private lateinit var check: Array<Boolean>
private var sb = StringBuilder()
fun main() = with(Scanner(System.`in`)) {
    N = nextInt()
    M = nextInt()
    arr = Array<Int>(N) { nextInt() }.sortedArray()
    check = Array<Boolean>(N) { false }
    dfs(0, 0, arrayListOf())
    println(sb)
}

fun dfs(start: Int, cnt: Int, answer: ArrayList<Int>) {
    if (cnt == M) {
        printarr(answer)
        return
    }
    for (i in start until N) {
        if (answer.size == 0 || arr[i] >= answer.last()) {
            answer.add(arr[i])
            dfs(i, cnt + 1, answer)
            answer.remove(arr[i])
        }
    }
}

fun printarr(answer: ArrayList<Int>) {
    answer.forEach { sb.append("$it ") }
    sb.append("\n")
}