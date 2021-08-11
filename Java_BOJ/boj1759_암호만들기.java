package today;

import java.util.Arrays;
import java.util.Scanner;

public class boj1759_암호만들기 {
	static boolean[] check;
	static String[] code;
	static int L, C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		check = new boolean[C];
		code = new String[C];
		sc.nextLine();
		code = sc.nextLine().split(" ");
		Arrays.sort(code);

		backtracking(0, 0);
	}

	public static void backtracking(int start, int cnt) {
		if (cnt == L) {
			int mo = 0, ja = 0;
			String result = "";
			for (int i = 0; i < C; i++) {
				if (check[i]) {
					result += code[i];
					if (code[i].equals("a") || code[i].equals("e") || code[i].equals("i") || code[i].equals("o")
							|| code[i].equals("u"))
						mo++;
					else
						ja++;
				}
			}
			if (mo >= 1 && ja >= 2)
				System.out.println(result);
			return;
		}

		for (int i = start; i < C; i++) {
			check[i] = true;
			backtracking(i + 1, cnt + 1);
			check[i] = false;
		}
	}

}