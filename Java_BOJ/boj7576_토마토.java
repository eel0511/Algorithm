package today;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj7576_토마토 {

	static int M, N;
	static int[][] board;
	static boolean[][] check;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int cnt;
	static int max;
	static int minday;
	static boolean flag;
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();
		board = new int[N][M];
		check = new boolean[N][M];
		cnt = 0;
		max = 0;
		minday = Integer.MAX_VALUE;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int temp = sc.nextInt();
				board[i][j] = temp;
			}
		}
		bfs();
		if (flag) {
			System.out.println("-1");
		} else {
			System.out.println(max - 1);
		}

	}

	public static void bfs() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 1) {
					q.add(new int[] { i, j });
					check[i][j] = true;
				}
			}
		}
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int newx = temp[0] + dx[i];
				int newy = temp[1] + dy[i];

				if (isNotWall(newx, newy) && board[newx][newy] == 0 && !check[newx][newy]) {
					q.add(new int[] { newx, newy });
					check[newx][newy] = true;
					board[newx][newy] = board[temp[0]][temp[1]] + 1;
				}
			}

		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (!flag && board[i][j] > max) {
					max = board[i][j];
				}
				if (board[i][j] == 0) {
					flag = true;
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

}
