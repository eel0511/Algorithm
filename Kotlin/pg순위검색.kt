import java.util.*

class Solution {
    fun setMap(map: HashMap<String?, ArrayList<Int>>) {
        val language = arrayOf("cpp", "java", "python", "-")
        val position = arrayOf("backend", "frontend", "-")
        val career = arrayOf("junior", "senior", "-")
        val soulfood = arrayOf("chicken", "pizza", "-")
        for (i in language.indices) {
            for (j in position.indices) {
                for (k in career.indices) {
                    for (l in soulfood.indices) {
                        map[language[i] + position[j] + career[k] + soulfood[l]] = ArrayList()
                    }
                }
            }
        }
    }

    fun inputVal(map: HashMap<String?, ArrayList<Int>>, info: String, value: Int) {
        val st = info.split(" ")
        map[st[0] + st[1] + st[2] + st[3]]!!.add(value)
        map["-" + st[1] + st[2] + st[3]]!!.add(value)
        map[st[0] + "-" + st[2] + st[3]]!!.add(value)
        map[st[0] + st[1] + "-" + st[3]]!!.add(value)
        map[st[0] + st[1] + st[2] + "-"]!!.add(value)

        map["-" + "-" + st[2] + st[3]]!!.add(value)
        map["-" + st[1] + "-" + st[3]]!!.add(value)
        map["-" + st[1] + st[2] + "-"]!!.add(value)
        map[st[0] + "-" + "-" + st[3]]!!.add(value)
        map[st[0] + "-" + st[2] + "-"]!!.add(value)
        map[st[0] + st[1] + "-" + "-"]!!.add(value)

        map["-" + "-" + "-" + st[3]]!!.add(value)
        map["-" + "-" + st[2] + "-"]!!.add(value)
        map["-" + st[1] + "-" + "-"]!!.add(value)
        map[st[0] + "-" + "-" + "-"]!!.add(value)

        map["-" + "-" + "-" + "-"]!!.add(value)

    }

    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val answer = IntArray(query.size)
        val infoMap = HashMap<String?, ArrayList<Int>>()
        setMap(infoMap)
        for (i in info.indices) {
            val value = info[i].split(" ")
            inputVal(infoMap, info[i], value[4].toInt())
        }
        for ((_, value) in infoMap) {
            value.sort()
        }
        for (i in query.indices) {
            val st = query[i].split(" ")
            val value = st[7].toInt()
            val key = st[0] + st[2] + st[4] + st[6]
            val result = infoMap[key]!!


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