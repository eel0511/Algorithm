package today;

import java.util.Scanner;

public class sw1213 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			String word = sc.next();
			String save = sc.next();
			String[] st = save.split(word);

			if (word.equals(save.substring(save.length() - word.length(), save.length()))) {
				System.out.println("#" + test_case + " " + st.length);
			} else {
				System.out.println("#" + test_case + " " + (st.length - 1));
			}

		}
	}

}
