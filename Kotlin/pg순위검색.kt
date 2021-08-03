import java.util.*

class Solution {
    fun setMap(map: HashMap<String, ArrayList<Int>>) {
        val first = arrayOf("cpp", "java", "python", "-")
        val second = arrayOf("backend", "frontend", "-")
        val third = arrayOf("junior", "senior", "-")
        val fourth = arrayOf("chicken", "pizza", "-")

        for (i in first.indices) {
            for (j in second.indices) {
                for (k in third.indices) {
                    for (l in fourth.indices) {
                        map[first[i] + second[j] + third[k] + fourth[l]] = ArrayList()
                    }
                }
            }
        }
    }

    fun input(map: HashMap<String, ArrayList<Int>>, info: String, value: Int) {
        val st = info.split(" ")
        val first = arrayOf(st[0], "-")
        val second = arrayOf(st[1], "-")
        val third = arrayOf(st[2], "-")
        val fourth = arrayOf(st[3], "-")

        for (i in first.indices) {
            for (j in second.indices) {
                for (k in third.indices) {
                    for (l in fourth.indices) {
                        map[first[i] + second[j] + third[k] + fourth[l]]!!.add(value)
                    }
                }
            }
        }
    }

    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val answer = IntArray(query.size)
        val map = HashMap<String, ArrayList<Int>>()
        setMap(map)
        for (i in info.indices) {
            val value = info[i].split(" ")
            input(map, info[i], value[4].toInt())
        }
        for ((_, value) in map) {
            value.sort()
        }
        for (i in query.indices) {
            val st = query[i].split(" ")
            val value = st[7].toInt()
            val key = st[0] + st[2] + st[4] + st[6]
            val result = map[key]!!


            var num = Collections.binarySearch(result, value)
            if (num >= 0) {
                for (j in num - 1 downTo 0) {
                    num = if (result[num] > result[j]) break else j
                }
                answer[i] = result.size - num
            } else {
                answer[i] = result.size + num + 1
            }
        }
        return answer
    }
}