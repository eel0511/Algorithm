package today;

import java.util.Scanner;
import java.util.Stack;

public class sw1267_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {

			int V = sc.nextInt();
			int E = sc.nextInt();
			//초기화
			int[][] board = new int[V + 1][V + 1];
			int[] check = new int[V + 1];
			Stack<Integer> stack = new Stack<>();

			// 값 받음
			for (int i = 1; i < E + 1; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				board[x][y] = 1;
				check[y]++;
			}

			for (int i = 1; i < V + 1; i++) {
				if (check[i] == 0) {
					stack.push(i);
				}
			}
			while (!stack.isEmpty()) {
				int temp = stack.pop();
				System.out.print(temp + " ");
				for (int i = 1; i < V + 1; i++) {
					if (board[temp][i] == 1) {
						check[i]--;
						if (check[i] == 0)
							stack.push(i);
					}
				}
			}
			System.out.println();
		}

	}

}
