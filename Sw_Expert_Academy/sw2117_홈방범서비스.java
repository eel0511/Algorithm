package today3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class sw2117_홈방범서비스 {
	static int N, M;
	static int board[][];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			String[] temp = br.readLine().split(" ");
			N = Integer.parseInt(temp[0]);
			M = Integer.parseInt(temp[1]);
			board = new int[N][N];
			for (int i = 0; i < N; i++) {
				temp = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(temp[j]);
				}
			}
			int save = 0;
			int max = Integer.MIN_VALUE;
			int cnt = 0;
			for (int k = 1; k <= N + 1; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						cnt = calc(i, j, k);
						if (cnt >= ((k * k) + (k - 1) * (k - 1))) {
							if (max < (cnt)) {
								max = cnt;
							}
						}
					}
				}
			}
			System.out.println("#"+t+" "+(max / M));

		}
	}

	public static int calc(int x, int y, int num) {
		int start = x - (num - 1);
		int end = x + (num - 1);
		int sum = 0;

		for (int j = y; j >= y - (num - 1); j--) {
			for (int i = start; i <= end; i++) {
				if (isNotWall(j, i) && board[j][i] == 1) {
					sum += M;
				}
			}
			start++;
			end--;
		}
		start = x - (num - 2);
		end = x + (num - 2);

		for (int j = y + 1; j <= y + (num - 1); j++) {
			for (int i = start; i <= end; i++) {
				if (isNotWall(j, i) && board[j][i] == 1) {
					sum += M;
				}
			}
			start++;
			end--;
		}
		return sum;
	}

	public static boolean isNotWall(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N)
			return true;
		return false;
	}

}
