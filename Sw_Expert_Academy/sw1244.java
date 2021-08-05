package today;

import java.util.Scanner;

public class sw1244 {
	static int[] save;
	static int cnt;
	static int result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		for (int test_case = 1; test_case <= 10; test_case++) {

			String[] st = sc.next().split("");
			save = new int[st.length];
			result = 0;
			cnt = sc.nextInt();
			for (int i = 0; i < save.length; i++) {
				save[i] = Integer.parseInt(st[i]);
			}
			if (save.length < cnt)
				cnt = save.length;

			result = dfs(0, 0);
//			if (result == 0) {
//				String str = "";
//				for (int i = 0; i < save.length; i++) {
//					str += save[i];
//				}
//				System.out.println("#" + test_case + " " + str);
//				continue;
//			}
			System.out.println("#" + test_case + " " + result);

		}
	}

	public static int dfs(int check, int start) {
		if (check == cnt) {
			String str = "";
			for (int i = 0; i < save.length; i++) {
				str += save[i];
			}
			result = Integer.max(result, Integer.parseInt(str));
			return result;
		}
		for (int i = start; i < save.length - 1; i++) {
			for (int j = i + 1; j < save.length; j++) {

				swap(i, j);
				dfs(check + 1, i);
				swap(i, j);

			}
		}
		return result;
	}

	public static void swap(int num1, int num2) {
		int temp = save[num1];
		save[num1] = save[num2];
		save[num2] = temp;
	}

}
