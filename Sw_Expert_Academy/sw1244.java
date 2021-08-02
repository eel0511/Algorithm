package today;

import java.util.Scanner;

public class sw1244 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		for (int test_case = 1; test_case <= 10; test_case++) {
			String[] st = sc.next().split("");
			int cnt = sc.nextInt();

			int[] save = new int[st.length];

			for (int i = 0; i < save.length; i++) {
				save[i] = Integer.parseInt(st[i]);
			}
			for (int i = 0; i < save.length; i++) {
				if (cnt == 0)
					break;
				int temp = save[i];
				int tempindex = 0;

				for (int j = i + 1; j < save.length; j++) {
					if (save[i] > save[j]) {
						if (temp < save[j]) {
							temp = save[j];
							tempindex = j;
							
						}
					} else {
						if (temp <= save[j]) {
							temp = save[j];
							tempindex = j;
						}
					}

				}

				save[tempindex] = save[i];
				save[i] = temp;
				cnt--;
				if (save[tempindex] == save[i])
					continue;

			}
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < save.length; i++) {
				System.out.print(+save[i]);
			}
			System.out.println();
		}
	}

}
