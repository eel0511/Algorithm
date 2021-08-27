package today;

import java.util.*;

public class sw5603_건초더미 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();

		for (int t = 1; t <= testcase; t++) {

			int N = sc.nextInt();
			int[] board = new int[N];
			int avg = 0;
			for (int i = 0; i < N; i++) {
				int temp = sc.nextInt();
				board[i] = temp;
				avg += temp;
			}
			avg /= N;
			Arrays.sort(board);
			int cnt = 0;
			for (int i = 0; i < board.length; i++) {
				if (board[i] < avg) {
					for (int j = board.length - 1; j > i; j--) {

						if (board[j] - (avg - board[i]) > avg) {
							cnt += avg - board[i];
							board[j] -= (avg - board[i]);
							board[i] += avg - board[i];

							break;
						}
						if (board[j] > avg && board[i] < avg) {
							cnt += board[j] - avg;
							board[i] += (board[j] - avg);
							board[j] = avg;

						}

					}
					for (int j2 = 0; j2 < board.length; j2++) {
						System.out.print(board[j2] + " ");
					}
					System.out.println();
				}
			}
			System.out.println(cnt);
		}

	}

}
