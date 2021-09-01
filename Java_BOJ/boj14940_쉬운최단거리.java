package today2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj14940_쉬운최단거리 {
	static int[][] board;
	static boolean[][] check;
	static int[][] result;
	static int N;
	static int M;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[N][M];
		check = new boolean[N][M];
		result = new int[N][M];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int temp = sc.nextInt();
				board[i][j] = temp;
				result[i][j] = temp;
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 2) {
					result[i][j] = 0;
					bfs(i, j);
				}

			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j]!=0&&!check[i][j])
					System.out.print(-1 + " ");
				else
					System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		check[x][y] = true;
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int newx = temp[0] + dx[i];
				int newy = temp[1] + dy[i];

				if (isNotWall(newx, newy) && !check[newx][newy] && board[newx][newy] == 1) {
					result[newx][newy] = result[temp[0]][temp[1]] + 1;
					check[newx][newy] = true;
					q.add(new int[] { newx, newy });
				}
			}
		}

	}

	public static boolean isNotWall(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M)
			return true;
		return false;
	}

}
