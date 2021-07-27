package today;

import java.util.Scanner;

public class sw1215 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			int cnt = 0;
			boolean check = false;
			int range = T / 2;
			String[][] board = new String[8][8];
			for (int i = 0; i < 8; i++) {
				board[i] = sc.next().split("");
			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8 - T + 1; j++) {
					check = false;
					for (int k = 0; k < range; k++) {
						if (!board[i][j + k].equals(board[i][j + T - k - 1])) {
							check = true;
						}
					}
					if (!check) {
						cnt++;
					}
				}

			}
			for (int i = 0; i < 8 - T + 1; i++) {
				for (int j = 0; j < 8; j++) {
					check = false;
					for (int k = 0; k < range; k++) {
						if (!board[i + k][j].equals(board[i + T - k - 1][j])) {
							check = true;
						}
					}
					if (!check) {
						cnt++;
					}
				}

			}

			System.out.println("#"+test_case+" "+cnt);

		}
	}

}
