package today;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sw_보급로 {
	static int[][] board;
	static boolean[][] check;
	static int N;
	static int min;
	static int[][] result;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++) {
			N = sc.nextInt();
			board = new int[N][N];
			check = new boolean[N][N];
			result = new int[N][N];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < board.length; i++) {
				String[] temp = sc.next().split("");
				for (int j = 0; j < board.length; j++) {
					board[i][j] = Integer.parseInt(temp[j]);
					result[i][j] = Integer.MAX_VALUE;
				}
			}
			result[0][0]=0;
			bfs(0, 0);
			System.out.println(min);
		}
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		check[x][y] = true;
		q.add(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] temp = q.poll();

			if (temp[0] == N - 1 && temp[1] == N - 1) {
				if (min > result[N - 1][N - 1])
					min = result[N - 1][N - 1];
			}
			if (min <= result[temp[0]][temp[1]])
				continue;

			for (int i = 0; i < dx.length; i++) {
				int newx = temp[0] + dx[i];
				int newy = temp[1] + dy[i];

				if (isNotWall(newx, newy) && (!check[newx][newy]
						|| result[newx][newy] > result[temp[0]][temp[1]] + board[newx][newy])) {
					check[newx][newy] = true;
					result[newx][newy] = result[temp[0]][temp[1]] + board[newx][newy];
					q.add(new int[] {newx,newy});
				}
			}
		}

	}

	public static boolean isNotWall(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		}
		return false;
	}

}
