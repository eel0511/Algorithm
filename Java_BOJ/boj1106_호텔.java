package today2;

import java.util.Arrays;
import java.util.Scanner;

public class boj1106_호텔 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int C = sc.nextInt();
		int N = sc.nextInt();

		int[] dp = new int[C + 101];
		Arrays.fill(dp, 999999);
		dp[0] = 0;
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int cost = sc.nextInt();
			int customer = sc.nextInt();
			for (int j = customer; j < dp.length; j++) {
				dp[j] = Integer.min(dp[j], cost + dp[j - customer]);
			}
		}
		for (int i = C; i < dp.length; i++) {
			result = Integer.min(result, dp[i]);
		}
		System.out.println(result);

	}

}
