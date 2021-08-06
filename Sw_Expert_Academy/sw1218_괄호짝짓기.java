package today;

import java.util.Scanner;
import java.util.Stack;

public class sw1218 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = Integer.parseInt(sc.nextLine());
			Stack<String> stack = new Stack<>();
			String[] save = sc.nextLine().split("");
			int cnt = 1;
			for (int i = 0; i < save.length; i++) {

				switch (save[i]) {
				case "}":
					if (!stack.peek().equals("{")) {
						cnt = 0;
						break;
					} else {
						stack.pop();
						break;
					}
				case ">":
					if (!stack.peek().equals("<")) {
						cnt = 0;
						break;
					} else {
						stack.pop();
						break;
					}
				case "]":
					if (!stack.peek().equals("[")) {
						cnt = 0;
						break;
					} else {
						stack.pop();
						break;
					}
				case ")":
					if (!stack.peek().equals("(")) {
						cnt = 0;
						break;
					} else {
						stack.pop();
						break;
					}
				default:
					stack.push(save[i]);

				}
				if (cnt == 0) {
					break;
				}
			}

			System.out.println("#"+test_case+" "+cnt);

		}
	}
}
