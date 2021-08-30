package today;

import java.util.Scanner;

public class sw2805_농작물수확하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++) {
			int N = sc.nextInt();
			int[][] board = new int[N][N];
			for (int i = 0; i < board.length; i++) {
				String[] temp = sc.next().split("");
				for (int j = 0; j < board.length; j++) {
					board[i][j] = Integer.parseInt(temp[j]);
				}
			}
			int center = N / 2;
			int start = N / 2 ;
			int end = N / 2;
			int sum = 0;
			for (int x = 0; x < center; x++) {
				for (int y = 0; y < N; y++) {
					if (y >= start && y <= end) {
						sum += board[x][y];
					}
				}
				start--;
				end++;
			}
			for (int x = center; x < N; x++) {
				for (int y = 0; y < N; y++) {
					if (y >= start && y <= end) {
						sum += board[x][y];
					}
				}
				start++;
				end--;
			}
			System.out.println(sum);
		}

	}

}
