package today;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sw1238 {
	static int[][] board;
	static boolean[] check;
	static int[] arr;
	static int cnt = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {

			int N = sc.nextInt();
			int start = sc.nextInt();
			board = new int[N + 1][N + 1];
			check = new boolean[N + 1];
			arr = new int[N + 1];
			sc.nextLine();
			String[] st = sc.nextLine().split(" ");
			for (int i = 0; i < st.length - 1; i = i + 2) {
				int x = Integer.parseInt(st[i]);
				int y = Integer.parseInt(st[i + 1]);
				if (board[x][y] != 1) {
					board[x][y] = 1;

				}
			}

			System.out.println("#"+test_case+" "+BFS(start));

		}
	}

	public static int BFS(int start) {
		Queue<Integer> qu = new LinkedList<>();
		qu.add(start);
		int result = 0;
		check[start] = true;
		arr[start] = 1;
		while (!qu.isEmpty()) {
			int temp = qu.poll();
			for (int i = 0; i < board.length; i++) {
				if (board[temp][i] == 1 && !check[i]) {
					arr[i] = arr[temp] + 1;
					qu.add(i);
					check[i] = true;
				}
			}
			cnt = arr[temp];
		}
		for (int i = 1; i < arr.length; i++) {
			if (cnt == arr[i]) {
				result = result > i ? result : i;
			}
			
		}
		return result;
	}
}
