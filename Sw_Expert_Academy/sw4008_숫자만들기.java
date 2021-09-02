package today2;

import java.util.Scanner;

public class sw4008_숫자만들기 {
	static int[] arr;
	static int N;
	static int min;
	static int max;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++) {
			N = sc.nextInt();
			int plus = sc.nextInt();
			int minus = sc.nextInt();
			int multi = sc.nextInt();
			int div = sc.nextInt();
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			arr = new int[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			int total = arr[0];
			dfs(1, plus, minus, multi, div, total);
			System.out.println("#"+t+" "+(max-min));
		}
	}

	public static void dfs(int start, int plus, int minus, int multi, int div, int total) {
		if (start == N) {
			max = Integer.max(max, total);
			min = Integer.min(min, total);
			return;
		}

		if (plus > 0) {
			dfs(start + 1, plus - 1, minus, multi, div, total + arr[start]);
		}
		if (minus > 0) {
			dfs(start + 1, plus, minus - 1, multi, div, total - arr[start]);
		}
		if (multi > 0) {
			dfs(start + 1, plus, minus, multi - 1, div, total * arr[start]);
		}
		if (div > 0) {
			dfs(start + 1, plus, minus, multi, div - 1, total / arr[start]);
		}

	}

}
