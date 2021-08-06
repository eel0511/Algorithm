package today;

import java.util.Scanner;

public class sw1216 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int num = sc.nextInt();
			int arrsize = 100;
			int cnt = 0;
			boolean check = false;
			int[] temparr = new int[100];
			String[][] board = new String[arrsize][arrsize];
			for (int i = 0; i < arrsize; i++) {
				board[i] = sc.next().split("");
			}
			for (int T = 2; T < 100; T++) {
				int range = T / 2;
				cnt = 0;
				for (int i = 0; i < arrsize; i++) {
					for (int j = 0; j < arrsize - T + 1; j++) {
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
				for (int i = 0; i < arrsize - T + 1; i++) {
					for (int j = 0; j < arrsize; j++) {
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
				temparr[T] = cnt;

			}
			for (int i = 99; i > 0; i--) {
				if (temparr[i] != 0) {
					System.out.println("#" + num + " " + i);
					break;
				}

			}

		}
	}

}
