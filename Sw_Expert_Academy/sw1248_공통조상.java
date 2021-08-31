package today;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sw1248_공통조상 {

	static LinkedList<Integer> list[];
	static int[] parents;
	static int[] depths;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			list = new LinkedList[V + 1];
			parents = new int[V + 1];
			depths = new int[V + 1];
			for (int i = 0; i < list.length; i++) {
				list[i] = new LinkedList<Integer>();
			}
			for (int i = 0; i < E; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				list[a].add(b);
			}
			dfs(1, 1, 0);
			int result = LCA(c1, c2);
			System.out.println("#" + t + " " + result + " " + bfs(result));
		}
	}
	public static int bfs(int start) {
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		while (!q.isEmpty()) {
			int temp = q.poll();
			cnt++;
			q.addAll(list[temp]);
		}
		return cnt;
	}
	public static void dfs(int current, int depth, int parent) {
		depths[current] = depth;
		parents[current] = parent;
		for (int nextNode : list[current]) {
			if (nextNode != parent) {
				dfs(nextNode, depth + 1, current);
			}
		}
	}
	public static int LCA(int a, int b) {
		int aDepth = depths[a];
		int bDepth = depths[b];
		while (aDepth > bDepth) {
			a = parents[a];
			aDepth--;
		}
		while (bDepth > aDepth) {
			b = parents[b];
			bDepth--;
		}
		while (a != b) {
			a = parents[a];
			b = parents[b];
		}
		return a;
	}

}
