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
					for (int j = i + 1; j < N; j++) {
						sc.next();
					}
					break;
				}

			}
			int start = 0;
			for (int i = 0; i < st.length(); i++) {
				if (st.charAt(i) == '1') {
					start = i - 3;
					break;

				}
			}

			String[] number = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
					"0110111", "0001011" };
			boolean check = true;
			for (int i = start; i < start + 4; i++) {
				if (check) {

					String temp = st.substring(i, i + 7);
					for (int j = 0; j < number.length; j++) {
						if (temp.equals(number[j])) {

							if (st.charAt(i + 7) != '1') {
								check = false;
								start = i;
								break;
							}

						}
					}

				}

			}
			int sum = 0;
			int[] save = new int[8];
			int index = 0;
			for (int i = start; i < start + 56; i = i + 7) {
				String temp = st.substring(i, i + 7);
				sum = 0;
				for (int j = 0; j < number.length; j++) {
					if (temp.equals(number[j])) {
						sum += j;
					}
				}
				save[index++] = sum;

			}

			int total = (save[0] + save[2] + save[4] + save[6]) * 3 + save[1] + save[3] + save[5] + save[7];
			if (total % 10 == 0) {
				total = 0;
				for (int i = 0; i < save.length; i++) {
					total += save[i];
				}
				System.out.println("#"+test_case+" "+total);
			} else {
				System.out.println("#"+test_case+" "+0);
			}
		}

	}

}
