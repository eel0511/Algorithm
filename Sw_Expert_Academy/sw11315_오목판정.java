package today;

import java.util.Scanner;

public class sw11315_오목판정 {

	static String[][] board;
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();

		for (int t = 1; t <= testcase; t++) {
			N = sc.nextInt();
			board = new String[N][N];
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				String[] temp = sc.next().split("");
				for (int j = 0; j < N; j++) {
					board[i][j] = temp[j];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!flag) {
						if (find1(i, j))
							flag = true;
						if (find2(i, j))
							flag = true;
						if (find3(i, j))
							flag = true;
						if (find4(i, j))
							flag = true;
					}
				}
			}
			if (flag)
				System.out.println("#" + t + " YES");
			else
				System.out.println("#" + t + " NO");

		}
	}

	public static boolean find1(int x, int y) {
		if (x + 2 < N && x - 2 >= 0) {
			if (board[x - 2][y].equals("o") && board[x - 1][y].equals("o") && board[x][y].equals("o")
					&& board[x + 1][y].equals("o") && board[x + 2][y].equals("o")) {
				return true;
			}
		}
		return false;

	}

	public static boolean find2(int x, int y) {

		if (y + 2 < N && y - 2 >= 0) {
			if (board[x][y - 2].equals("o") && board[x][y - 1].equals("o") && board[x][y].equals("o")
					&& board[x][y + 1].equals("o") && board[x][y + 2].equals("o")) {
				return true;
			}
		}
		return false;

	}

	public static boolean find3(int x, int y) {

		if (x + 2 < N && x - 2 >= 0 && y + 2 < N && y - 2 >= 0) {
			if (board[x - 2][y - 2].equals("o") && board[x - 1][y - 1].equals("o") && board[x][y].equals("o")
					&& board[x + 1][y + 1].equals("o") && board[x + 2][y + 2].equals("o")) {
				return true;
			}
		}
		return false;

	}

	public static boolean find4(int x, int y) {

		if (x + 2 < N && x - 2 >= 0 && y + 2 < N && y - 2 >= 0) {
			if (board[x + 2][y - 2].equals("o") && board[x + 1][y - 1].equals("o") && board[x][y].equals("o")
					&& board[x - 1][y + 1].equals("o") && board[x - 2][y + 2].equals("o")) {
				return true;
			}
		}
		return false;

	}

}
