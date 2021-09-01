package today2;

import java.util.Scanner;

public class boj2293_동전1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] coin = new int[N];
		for (int i = 0; i < coin.length; i++) {
			coin[i] = sc.nextInt();
		}
		int[] dp = new int[K+1];

		dp[0]=1;
		for (int i = 0; i < N; i++) {
			for (int j = coin[i]; j <K+1; j++) {
				dp[j] += dp[j-coin[i]];
			}
		}
		System.out.println(dp[K]);

	}

}
