package today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2563_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[101][101];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = Integer.parseInt(temp[0]); j < Integer.parseInt(temp[0]) + 10; j++) {
				for (int k = Integer.parseInt(temp[1]); k < Integer.parseInt(temp[1]) + 10; k++) {
					board[k][j]++;
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {

				if (board[i][j] >= 1) {
					cnt ++;
					continue;
				}
				if (board[i][j] == 1) {
					cnt++;
				}

			}
		}
		System.out.println(cnt);

	}

}
