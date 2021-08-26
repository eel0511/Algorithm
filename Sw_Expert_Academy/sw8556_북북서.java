package today;

import java.util.Scanner;
import java.util.Stack;

public class sw8556_북북서 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int testcase = sc.nextInt();
		for (int t = 1; t <=testcase; t++) {
			String[] st = sc.next().split("");
			Stack<String> stack = new Stack<>();
			int cnt = 0;

			for (int i = 0; i < st.length; i++) {
				if (st[i].equals("n") || st[i].equals("w")) {
					stack.add(st[i]);
					cnt++;
				}
			}

			double po = Math.pow(2, cnt - 1);
			double result = 0;
			if (stack.pop().equals("w")) {
				result = 90 * po;
			}
			int save = 1;
			while (!stack.isEmpty()) {
				String temp = stack.pop();
				if (temp.equals("w"))
					result += 90 * po / Math.pow(2, save);
				else
					result -= 90 * po / Math.pow(2, save);
				save++;
			}
			while (save != 1 && result % 2 == 0) {
				result /= 2;
				save--;
			}
			if (save == 1) {
				System.out.println("#" + t + " " + (int) result);
			} else {
				System.out.println("#" + t + " " + (int) result + "/" + (int) Math.pow(2, save - 1));
			}

		}

	}

}
