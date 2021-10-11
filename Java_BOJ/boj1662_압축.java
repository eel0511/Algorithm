package today4;

import java.util.Scanner;
import java.util.Stack;

public class boj1662_압축 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Stack<int[]> stack = new Stack<>();

		String temp = sc.next();
		int length = 0;
		char str = ' ';
		for (int i = 0; i < temp.length(); i++) {
			if (Character.isDigit(temp.charAt(i))) {
				length++;
				str = temp.charAt(i);
			} else if (temp.charAt(i) == '(') {
				stack.add(new int[] { str, length-1 });
				length = 0;
			} else {
				int[] stemp = stack.pop();
				length = (stemp[0]-'0') * length + stemp[1];
			}
		}
		System.out.println(length);

	}
}
