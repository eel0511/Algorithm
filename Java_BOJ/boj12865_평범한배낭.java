package today2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj12865_평범한배낭 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int K = Integer.parseInt(temp[1]);
		int[][] arr = new int[N + 1][2];
		int[][] dp = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			temp = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(temp[0]);
			arr[i][1] = Integer.parseInt(temp[1]);
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {

				//담을수 없을때 이전값사용
				if (arr[i][0] > j) {
					dp[i][j] = dp[i - 1][j];
				}
				//담을수있으면 이전꺼랑 새로넣은거랑 비교해서 큰걸로
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i][0]] + arr[i][1]);
				}

			}
		}
		System.out.println(dp[N][K]);
	}

}
