package today2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class sw1251_하나로 {
	static class island implements Comparable<island> {
		int x, y;
		double cost;

		island(int x, int y, double cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(island o) {
			return (int) (this.cost - o.cost);
		}
	}

	static double[][] board;
	static boolean[] check;
	static int N;
	static int[] root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++) {
			N = sc.nextInt();
			board = new double[N][2];
			check = new boolean[N];

			for (int i = 0; i < board.length; i++) {
				board[i][0] = sc.nextDouble();
			}
			for (int i = 0; i < board.length; i++) {
				board[i][1] = sc.nextDouble();
			}
			double E = sc.nextDouble();

			root = new int[N];
			for (int i = 0; i < N; ++i) {
				root[i] = i;
			}
			PriorityQueue<island> q = new PriorityQueue<>();
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					q.add(new island(i, j,
							Math.pow(board[i][0] - board[j][0], 2) + Math.pow(board[i][1] - board[j][1], 2)));
				}
			}
			double cost = 0;
			while(!q.isEmpty()) {
				island i = q.poll();
				int x = find(i.x);
				int y = find(i.y);
				if(x==y) continue;
				union(x,y);
				cost += E*i.cost;
			}
			System.out.print("#"+t+" ");
			System.out.printf("%.0f\n",cost);

		}
	}

	public static int find(int x) {
		if (x != root[x])
			return find(root[x]);
		return x;
	}

	public static void union(int x, int y) {
		if (x < y) {
			root[y] = root[x];
		} else {
			root[x] = root[y];
		}
	}

}
