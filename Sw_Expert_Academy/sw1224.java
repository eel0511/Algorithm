package today;

import java.util.Scanner;
import java.util.Stack;

public class sw1224 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {

			Stack<String> stack = new Stack<>();
			int N = sc.nextInt();
			String[] st = new String[N];
			st = sc.next().split("");
			String save = "";


			// 후위표현식 만들기
			for (int i = 0; i < st.length; i++) {

				switch (st[i]) {
				case "(":
					stack.push(st[i]);
					break;

				case "*":
					while (!stack.isEmpty() && stack.peek().equals("*")) {
						String temp = stack.pop();
						save += temp;
					}
					stack.push(st[i]);
					break;
				case "+":
					while (!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("+"))) {
						String temp = stack.pop();
						save += temp;
					}
					stack.push(st[i]);
					break;
				case ")":

					while (!stack.peek().equals("(")) {
						String temp = stack.pop();
						save += temp;
					}
					stack.pop();
					break;

				default:
					save += st[i];

				}

			}
			while (!stack.isEmpty()) {
				save += stack.pop();
			}


			Stack<Integer> calstack = new Stack<Integer>();
			
			for (int i = 0; i < save.length(); i++) {
				char temp = save.charAt(i);

				if (temp == '+') {
					calstack.push(calstack.pop() + calstack.pop());
				} else if (temp == '*') {
					calstack.push(calstack.pop() * calstack.pop());
				} else {
					calstack.push(Integer.parseInt("" + temp));
				}
			}
			System.out.println("#"+test_case+" "+calstack.pop());
		}
	}
}
