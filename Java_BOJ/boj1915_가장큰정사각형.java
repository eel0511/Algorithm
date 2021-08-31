package today2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1915_가장큰정사각형 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		int[][] board = new int[N][M];
		int[][] dp = new int[N][M];
		int result = 0;

		for (int i = 0; i < N; i++) {
			temp = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(temp[j]);
				dp[i][j] = Integer.parseInt(temp[j]);
				//이부분때문에 계속틀림 하나만있을때 처리해야함
				if(dp[i][j]==1)result=1;
			}
		}
		//뒤에서 부터 앞으로 오면서 dp정사각형을 갱신시켜나감
		for (int i = dp.length - 2; i >= 0; i--) {
			for (int j = dp[0].length - 2; j >= 0; j--) {
				if (board[i][j] == 1) {
					dp[i][j] = Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1])) + 1;
					result = Integer.max(result, dp[i][j] * dp[i][j]);
				}
			}
		}
		System.out.println(result);

	}

}
