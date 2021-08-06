package today;

import java.util.Scanner;
import java.util.Stack;

public class boj1541 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Stack<String> stack = new Stack<>();
		String[] st = sc.next().split("");
		String[] temp = new String[st.length + 2];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = "";
		}
		int cnt = 0;
		for (int i = 0; i < st.length; i++) {
			if (st[i].equals("+") || st[i].equals("-")) {
				temp[++cnt] += st[i];
				cnt++;
			} else {
				temp[cnt] += st[i];
			}
		}

		// 덧셈 먼저
		for (int i = 0; i < cnt + 1; i++) {

			stack.push(temp[i]);
			if (temp[i].equals("+")) {
				stack.push(temp[++i]);
				int num1 = Integer.parseInt(stack.pop());
				String op = stack.pop();
				int num2 = Integer.parseInt(stack.pop());
				stack.push((num1 + num2) + "");

			}
		}

		//뒤집어서 뺄셈
		Stack<String> reversestack = new Stack<>();
		while (!stack.isEmpty()) {
			reversestack.push(stack.pop());
		}

		while (reversestack.size() != 1) {
			int num1 = Integer.parseInt(reversestack.pop());
			String op = reversestack.pop();
			int num2 = Integer.parseInt(reversestack.pop());
			reversestack.push((num1 - num2) + "");
			
		}

		System.out.println(reversestack.pop());

	}

}
