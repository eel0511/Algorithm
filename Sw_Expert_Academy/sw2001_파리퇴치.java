package today;

import java.util.Scanner;

public class sw2001_파리퇴치 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testcase = sc.nextInt();

		for (int t = 1; t <= testcase; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] board = new int[N][N];
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			int max = 0;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					if (i + M <= N  && j + M <= N) {
						int result = 0;
						for (int t1 = i; t1 <i+ M; t1++) {
							for (int t2 = j; t2 <j+M; t2++) {
								result += board[t1][t2];							
							}
						}
						if (max < result) {
							max = result;
						}
					}
				}
			}
			System.out.println(max);
		}
	}
}
