package today;

import java.util.Scanner;

public class sw1226 {
	static int[][] board;

	static int result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {

			int num = sc.nextInt();
			board = new int[16][16];
			result = 0;

			for (int i = 0; i < board.length; i++) {
				String[] temp = sc.next().split("");
				for (int j = 0; j < board.length; j++) {
					board[i][j] = Integer.parseInt(temp[j]);
				}
			}

			find(1, 1);
			System.out.println("#" + test_case + " " + result);

		}
	}

	public static void find(int x, int y) {
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { -1, 1, 0, 0 };

		for (int i = 0; i < 4; i++) {
			if (result == 1) {
				return;
			}
			int newX = x + dx[i];
			int newY = y + dy[i];

			if (board[newX][newY] == 1 || isWall(newX, newY)) {
				continue;
			}

			if (board[newX][newY] == 3) {
				result = 1;
				return;
			}
			if (board[newX][newY] == 0) {
				board[newX][newY] = 1;
				find(newX, newY);
			}

		}

	}

	public static boolean isWall(int x, int y) {
		if (x < 0 || x >= 16 || y < 0 || y >= 16) {
			return true;
		}
		return false;
	}

}
