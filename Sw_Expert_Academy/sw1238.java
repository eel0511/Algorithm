package today;

import java.util.Scanner;
import java.util.Stack;

public class sw1238 {
	static Stack<Integer> stack = new Stack<>();
	static int V;
	static int start;
	static int[][] board;
	static int[] check;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {

			V = sc.nextInt();
			start = sc.nextInt();
			sc.nextLine();
			String[] temp = sc.nextLine().split(" ");
			board = new int[V + 1][V + 1];
			check = new int[V + 1];

			// 값 받음
			for (int i = 0; i < temp.length - 1; i++) {
				int x = Integer.parseInt(temp[i++]);
				int y = Integer.parseInt(temp[i]);

				if (board[x][y] == 0) {
					board[x][y] = 1;
					check[y]++;
				}
			}

			find(start);

		}

	}

	public static void find(int start) {
		stack.push(start);
		if (start != 2)
			stack.pop();
		while (!stack.isEmpty()) {
			System.out.println(stack.toString());
			int save = stack.pop();
			System.out.print(save + " ");
			for (int i = 1; i < V + 1; i++) {
				if (board[save][i] == 1) {
					check[i]--;
					if (check[i] == 0)
						stack.push(i);
					find(i);
				}

			}

		}
		System.out.println();
	}

}
