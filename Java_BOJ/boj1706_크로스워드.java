package today;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class boj1706_크로스워드 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		String[][] board = new String[R][C];
		List<String> list = new LinkedList<>();
		for (int i = 0; i < board.length; i++) {
			String[] temp = sc.next().split("");
			for (int j = 0; j < temp.length; j++) {
				board[i][j] = temp[j];
			}
		}
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				String temp = "";
				for (int k = j; k < R; k++) {

					if (k == R - 1 || board[k][i].equals("#")) {
						if (!board[k][i].equals("#"))
							temp += board[k][i];
						if (temp.length() > 1) {
							list.add(temp);
							j = k - 1;
						}

						break;
					}
					temp += board[k][i];
				}

			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				String temp = "";

				for (int k = j; k < C; k++) {
					if (!board[i][k].equals("#"))
						temp += board[i][k];
					if (k == C - 1 || board[i][k].equals("#")) {
						if (temp.length() > 1) {
							list.add(temp);
							j = k - 1;
						}

						break;
					}

				}

			}
		}
		Collections.sort(list);
		System.out.println(list);
		System.out.println(list.get(0));
	}
}
