import java.util.*
import kotlin.collections.HashMap

fun main() {
    //트리셋을 사용하는 문제 처음써보았다
    val set = TreeSet<Node>()
    val map = HashMap<Int, Int>()
    repeat(readLine()!!.toInt()) {
        val temp = readLine()!!.split(" ")
        set.add(Node(temp[0].toInt(), temp[1].toInt()))
        map[temp[0].toInt()] = temp[1].toInt()
    }
    repeat(readLine()!!.toInt()) {
        val temp = readLine()!!.split(" ")
        val num = temp[1].toInt()
        when (temp[0]) {
            "add" -> {
                val diff = temp[2].toInt()
                set.add(Node(num, diff))
                map[num] = diff
            }
            "recommend" -> println(if (num == 1) set.last().num1 else set.first().num1)
            "solved" -> {
                set.remove(Node(num, map[num]!!))
                map.remove(num)
            }
        }
    }
}
//트리셋에 class를 넣으려면 자바처럼 Comparable을 구현해야함
//코틀린은 class생성시 var로 파라미터를 주면 바로 getter setter도 됨
class Node(var num1: Int, var num2: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int = if (num2 - other.num2 == 0) { num1 - other.num1 } else { num2 - other.num2 }
}
