package today;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj2589_보물섬 {
	static int N, M;
	static int[][] board;
	static boolean[][] check;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int cnt;
	static int max;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[N][M];
		check = new boolean[N][M];
		max = 0;
		for (int i = 0; i < board.length; i++) {
			String[] temp = sc.next().split("");
			for (int j = 0; j < board[0].length; j++) {
				if (temp[j].equals("L")) {
					board[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 1) {
					cnt = 0;
					init();
					bfs(i, j);
					max = Integer.max(max, cnt);
				}
			}

		}
		System.out.println(max);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		check[x][y] = true;
		int[][] save = new int[N][M];

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int newx = temp[0] + dx[i];
				int newy = temp[1] + dy[i];
				if (isNotWall(newx, newy) && board[newx][newy] == 1 && !check[newx][newy]) {
					q.add(new int[] { newx, newy });
					check[newx][newy] = true;
					save[newx][newy] += save[temp[0]][temp[1]] + 1;
				}

			}
		}
		for (int i = 0; i < save.length; i++) {
			for (int j = 0; j < save[0].length; j++) {
				if (cnt < save[i][j])
					cnt = save[i][j];
			}
		}
	}

	public static boolean isNotWall(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M) {
			return true;
		}
		return false;
	}

	public static void init() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				check[i][j] = false;
			}
		}
	}

}
