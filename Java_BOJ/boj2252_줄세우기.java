package today4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj2252_줄세우기 {

	static int N, M;
	static boolean[] check;
	static int[] indegree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		check = new boolean[N + 1];
		indegree = new int[N + 1];
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			list[num1].add(num2);
			indegree[num2]++;
		}
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i < list.length; i++) {
			if (indegree[i] == 0) {
				q.add(i);

			}
		}
		while (!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp + " ");
			for (int next : list[temp]) {
				indegree[next]--;
				if (indegree[next] == 0) {
					q.add(next);

				}
			}
		}
	}
}
