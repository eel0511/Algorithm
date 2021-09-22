package today3;

import java.util.Scanner;

public class boj9466_텀프로젝트 {
	static int[] arr;
	static boolean[] check, done;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {

			int N = sc.nextInt();
			cnt = 0;
			arr = new int[N + 1];
			check = new boolean[N + 1];
			done = new boolean[N + 1];

			for (int i = 1; i <= N; i++)
				arr[i] = sc.nextInt();
			for (int i = 1; i <= N; i++)
				if (!done[i])
					dfs(i);

			System.out.println(N - cnt);
		}
	}

	private static void dfs(int v) {
		if (check[v]) {
			done[v] = true;
			cnt++;
		} else
			check[v] = true;

		if (!done[arr[v]])
			dfs(arr[v]);
		check[v] = false;
		done[v] = true;
	}

}
