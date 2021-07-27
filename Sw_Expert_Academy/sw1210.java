package today;

import java.util.Scanner;

public class sw1210 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int start = 0;

		for (int test_case = 1; test_case <= 10; test_case++) {
			int num = sc.nextInt();
			int[][] board = new int[101][101];

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < 100; i++) {
				if (board[99][i] == 2) {
					start = i;
					break;
				}
			}
			System.out.println("#" + num + " " + search(board, start));
		}

	}

	public static int search(int Map[][], int start) {
		int y = 99;
		int x = start;

		while (y != 0) {
			if (x - 1 > 0 && Map[y][x - 1] == 1) {
				while (x - 1 > 0 && Map[y][x - 1] != 0) {
					x--;
				}
				y--;
			} else if (x + 1 < 100 && Map[y][x + 1] == 1) {
				while (x + 1 < 100 && Map[y][x + 1] != 0) {
					x++;
				}
				y--;
			} else {
				y--;
			}
		}
		return x;
	}
}
