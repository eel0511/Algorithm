package today;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj2636_치즈 {

	static int N, M;
	static int[][] board;
	static boolean[][] check;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int cnt = 0;
	static int total = 0;
	static int time = 0;
	static int sum = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = sc.nextInt();
				if (board[i][j] == 1) {
					total++;
				}
			}
		}

		while (cnt != total) {
			time++;
			sum = cnt;
			bfs(0, 0);
		}
		System.out.println(time);
		System.out.println(total - sum);

	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		check = new boolean[N][M];
		check[x][y] = true;

		while (!q.isEmpty()) {
			int[] temp = q.poll();

			for (int i = 0; i < dx.length; i++) {
				int newx = temp[0] + dx[i];
				int newy = temp[1] + dy[i];

				if (isNotWall(newx, newy) && !check[newx][newy] && board[newx][newy] == 1) {
					board[newx][newy] = 0;
					check[newx][newy] = true;
					cnt++;
				} else if (isNotWall(newx, newy) && !check[newx][newy] && board[newx][newy] == 0) {
					q.add(new int[] { newx, newy });
					check[newx][newy] = true;
				}

			}
		}

	}

	public static boolean isNotWall(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M) {
			return true;
		}
		return false;
	}

	public static void printboard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
