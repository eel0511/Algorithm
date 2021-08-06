package today;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Stack;

public class sw1267 {
	static Stack<Integer> stack = new Stack<>();
	static Stack<Integer> resultstack = new Stack<>();
	static LinkedHashSet<Integer> set = new LinkedHashSet<>();
	static int[][] board = new int[1001][1001];
	static int[] check = new int[1001 * 1000];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {

			int V = sc.nextInt();
			int E = sc.nextInt();
			//초기화
			stack.clear();
			resultstack.clear();
			set.clear();
			for (int i = 1; i < V + 1; i++) {
				for (int j = 0; j < V + 1; j++) {
					board[i][j] = 0;
					check[i] = 0;
				}
			}
			//값 받음
			for (int i = 1; i < E + 1; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				board[x][y] = 1;
				check[y]++;
			}

			
			for (int k = 1; k < V+1; k++) {
				for (int i = 1; i < V+1; i++) {
					for (int j = 1; j < V+1; j++) {
						path(board, check, i, j, V + 1);

					}

				}
			}
			//출력
			Iterator<Integer> iter = set.iterator();
			System.out.print("#" + test_case);
			while (iter.hasNext()) {
				System.out.print(" "+iter.next() );
			}
			System.out.println();
		}
	}

	public static void path(int[][] board, int[] check, int start, int end, int N) {

		if (check[start] == 0) {
			stack.push(start);
			check[start] = -1;
			while (!stack.isEmpty()) {
				resultstack.push(stack.pop());
				int temp = resultstack.pop();
				set.add(temp);
			}
			for (int i = 1; i < N; i++) {
				if (board[start][i] == 1) {

					stack.push(i);
					check[i]--;
				}
			}

		}

	}
}
