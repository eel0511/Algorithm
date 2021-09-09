package today3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj14567_선수과목 {

	static int[] dp;
	static ArrayList<Integer>[] arr;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		dp = new int[N + 1];
		arr = new ArrayList[N + 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			arr[num2].add(num1);
		}

		for (int i = 1; i < arr.length; i++) {
			System.out.print(d(i) + " ");
		}

	}

	public static int d(int start) {
		for (int j : arr[start]) {
			dp[start] = Integer.max(dp[start], dp[j]);
		}
		return ++dp[start];
	}

}
