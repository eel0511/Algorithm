package today4

import java.util.*

private var R = 0
private var C = 0
private lateinit var board: Array<Array<Char>>
private var jh = Array(2) { 0 }
private lateinit var fire: ArrayList<Array<Int>>
private var dx = arrayOf(0, 0, 1, -1)
private var dy = arrayOf(1, -1, 0, 0)
private var time = 0
fun main() = with(Scanner(System.`in`)) {
    R = nextInt()
    C = nextInt()
    board = Array(R) { Array(C) { ' ' } }
    fire = ArrayList()
    for (i in 0 until R) {
        val temp = next()
        for (j in 0 until C) {
            board[i][j] = temp[j]
            if (board[i][j] == 'J') {
                jh[0] = i
                jh[1] = j
            }
            if (board[i][j] == 'F') {
                fire.add(arrayOf(i, j))
            }
        }
    }
    bfs()
}

fun bfs() {
    var q = LinkedList<Array<Int>>()
    var fireq = LinkedList<Array<Int>>()
    q.add(jh)
    fireq.addAll(fire)
    while (q.isNotEmpty()) {
        val firesize = fireq.size
        repeat(firesize) {
            val temp = fireq.poll()
            for (i in dx.indices) {
                val newx = temp[0] + dx[i]
                val newy = temp[1] + dy[i]
                if (isNotWall(newx, newy) && board[newx][newy] != '#' && board[newx][newy] != 'F') {
                    board[newx][newy] = 'F'
                    fireq.add(arrayOf(newx, newy))
                }
            }
        }

        val jhsize = q.size
        repeat(jhsize){
            val jhtemp = q.poll()
            for (i in dx.indices) {
                val newx = jhtemp[0] + dx[i]
                val newy = jhtemp[1] + dy[i]
                if (!isNotWall(newx, newy)) {
                    print(time + 1)
                    return
                }
                if (isNotWall(newx, newy) && board[newx][newy] == '.') {

                    board[newx][newy] = 'J'
                    q.add(arrayOf(newx, newy))
                }
            }
        }

        time++
    }
    println("IMPOSSIBLE")

}

fun isNotWall(x: Int, y: Int): Boolean = x in 0 until R && y in 0 until C

