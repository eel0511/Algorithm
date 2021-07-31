package today;

import java.util.Scanner;

public class sw1240 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			String st = "";
			for (int i = 0; i < N; i++) {
				st = sc.next();
				if (st.contains("1")) {
					break;
				}

			}
			int start = 0;
			for (int i = 0; i < st.length(); i++) {
				if (st.charAt(i) == '1') {
					start = i;
					break;

				}
			}

			int sum = 0;
			int[] save = new int[8];
			int index = 0;
			for (int i = start; i < start + 56; i = i + 7) {
				String temp = st.substring(i, i + 7);
				sum = 0;
				for (int j = 0; j < 7; j++) {
					sum += temp.charAt(j) - '0';
				}
				save[index++] = sum;

			}
			for (int i = 0; i < save.length; i++) {
				System.out.println(save[i]);
			}

		}

	}

}
