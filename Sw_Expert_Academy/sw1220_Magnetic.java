package today;

import java.util.Scanner;

public class sw1220 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			int[][] board = new int[T][T];
			int cnt = 0;

			for (int i = 0; i < T; i++) {
				for (int j = 0; j < T; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < T; i++) {
				int save = board[0][i];
				for (int j = 1; j < T; j++) {
					if (board[j][i] == 0) {
						continue;
					}
					if (save == 1 && board[j][i] == 2) {
						cnt++;
					}
					save = board[j][i];
				}
			}
			System.out.println("#"+test_case+" "+cnt);

		}
	}

}
