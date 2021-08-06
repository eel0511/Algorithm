package today;

import java.util.Scanner;

public class sw1861 {

	static int N;
	static int[][] board;
	static boolean[][] check;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int result;
	static int[][] save;
	static int max;
	static int dirx, diry;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int test_case = sc.nextInt();
		for (int t = 1; t <= test_case; t++) {

			N = sc.nextInt();
			board = new int[N][N];
			save = new int[N][N];
			check = new boolean[N][N];
			result = 0;
			max = 0;
			dirx = 0;
			diry = 0;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					board[i][j] = sc.nextInt();
				}

			}
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					init();
					dfs(i, j, 0);
					save[i][j] = result + 1;
					result=0;
				}
			}
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					if (save[i][j] > max) {
						max = save[i][j];
						dirx = i;
						diry = j;

					} else if (save[i][j] == max) {
						if (board[dirx][diry] > board[i][j]) {							
							dirx = i;
							diry = j;
						}
					}
				}
			}
			System.out.println("#" + t + " " + (board[dirx][diry]) + " " + max);

		}
	}

	public static void dfs(int x, int y, int cnt) {
		check[x][y] = true;
		result = Math.max(result, cnt);

		for (int i = 0; i < dx.length; i++) {

			int newX = x + dx[i];
			int newY = y + dy[i];

			if (isNotWall(newX, newY) && !check[newX][newY] && ((board[newX][newY] - board[x][y]) == 1)) {
				check[newX][newY] = true;
				dfs(newX, newY, cnt + 1);
				check[newX][newY] = false;
			}
		}

	}

	public static boolean isNotWall(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		}
		return false;
	}

	public static void init() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				check[i][j] = false;
			}
		}
	}
}
