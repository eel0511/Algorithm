package today3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj13549_숨바꼭질3 {
	static int N, K, min;
	static boolean[] check;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		K = Integer.parseInt(temp[1]);
		check = new boolean[200001];
		min = Integer.MAX_VALUE;
		bfs();
		System.out.println(min);
	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { N, 0 });
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			System.out.println(temp[0]+" "+temp[1]);
			check[temp[0]] = true;

			if (temp[0] == K) {
				min = Integer.min(min, temp[1]);
			}
			if (isNotWall(temp[0] * 2) && !check[temp[0] * 2]) {
				q.add(new int[] { temp[0] * 2, temp[1] });
			}
			if (isNotWall(temp[0] + 1) && !check[temp[0] + 1]) {
				q.add(new int[] { temp[0] + 1, temp[1] + 1 });
			}
			if (isNotWall(temp[0] - 1) && !check[temp[0] - 1]) {
				q.add(new int[] { temp[0] - 1, temp[1] + 1 });
			}

		}
	}

	public static boolean isNotWall(int x) {
		if (x >= 0 && x <= 100000)
			return true;
		return false;
	}
}
