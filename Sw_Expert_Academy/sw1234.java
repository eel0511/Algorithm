package today;

import java.util.Scanner;
import java.util.Stack;

public class sw1234 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {

			int num = sc.nextInt();
			String[] st = sc.next().split("");
			Stack<String> stack = new Stack<>();

			for (int i = 0; i < st.length; i++) {
				if (!stack.isEmpty() && stack.peek().equals(st[i])) {
					stack.pop();
					continue;
				}
				stack.push(st[i]);
			}

			String[] result = new String[stack.size()];
			for (int i = result.length - 1; i >= 0; i--) {
				result[i] = stack.pop();
			}
			
			System.out.print("#"+test_case+" ");
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i]);
			}
			System.out.println();
		}

	}

}
