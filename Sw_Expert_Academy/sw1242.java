package today;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class sw1242{
	static HashMap<String, String> map = new HashMap<>();
	static String[] number = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
			"0110111", "0001011" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initmap();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int test_case = 1; test_case <= num; test_case++) {

			int N = sc.nextInt();
			int M = sc.nextInt();
			String[] save = new String[N * M /10];
			String[] check = new String[N * M /10];
			String[] reversecheck = new String[N * M /10];
			String[] makenumber = new String[10];
			int[][] result = new int[N * M /10][8];
			int sumanswer = 0;

			for (int i = 0; i < save.length; i++) {
				save[i] = "";
				check[i] = "";
				reversecheck[i] = "";
				if (i < 10) {
					makenumber[i] = "";
				}
			}
			

			// 유효한 값만 집어넣음
			int cnt = 0;
			for (int i = 0; i < N; i++) {

				String[] st = sc.next().split("");
				save[cnt] = "";
				for (int j = 0; j < st.length; j++) {
					save[cnt] += map.get(st[j]);
				}
				if (save[cnt].contains("1")) {
					cnt++;
				}
			}
			int step = 0;
			for (int i = 0; i < cnt; i++) {

				// check라는 배열에 한줄씩 떼와서 잘라서 넣음
				for (int j = save[i].length() - 1; j >= 0; j--) {
					if (save[i].charAt(j) == '1') {
						while (save[i].charAt(j) == '1') {
							if (j == 0)
								break;
							check[step] += save[i].charAt(j);
							j--;
						}
						while (save[i].charAt(j) == '0') {
							if (j == 0)
								break;
							check[step] += save[i].charAt(j);
							j--;
						}
						while (save[i].charAt(j) == '1') {
							if (j == 0)
								break;
							check[step] += save[i].charAt(j);
							j--;
						}
						while (save[i].charAt(j) == '0') {
							if (j == 0)
								break;
							check[step] += save[i].charAt(j);
							j--;
						}
						j++;
						step++;
					}
				}
			}
			check[7] = check[7].substring(0, check[0].length());
			for (int k = 0; k < step; k = k + 8) {

				// 마지막처리

				if (k != 0) {
					check[k + 7] = check[k + 7].substring(0, check[k].length());
				}

				// 뒤집어줌
				for (int i = k; i < k + 8; i++) {
					for (int j = check[k].length() - 1; j >= 0; j--) {

						reversecheck[i] += check[i].charAt(j);
					}
				}

				// 비교배열 만듬
				int mul = check[k].length() / 7;
				for (int i = 0; i < makenumber.length; i++) {
					makenumber[i] = "";
				}
				for (int j = 0; j < makenumber.length; j++) {
					for (int m = 0; m < 7; m++) {
						for (int h = 0; h < mul; h++) {
							makenumber[j] += number[j].charAt(m);
						}
					}
				}

				// 비교배열과 비교하여 2진수를 10진수로 변환
				for (int i = k; i < k + 8; i++) {
					for (int j = 0; j < 10; j++) {
						if (reversecheck[i].equals(makenumber[j])) {
							result[k / 8][i - k] = j;
							break;
						}

					}
				}

			}

			Set<String> set = new HashSet<>();
			for (int j = 0; j < result.length; j++) {
				set.add(result[j][0] + "" + result[j][1] + "" + result[j][2] + "" + result[j][3] + "" + result[j][4]
						+ "" + result[j][5] + "" + result[j][6] + "" + result[j][7] + "");
			}

			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				String[] t = it.next().split("");
				int code = (Integer.parseInt(t[7]) + Integer.parseInt(t[5]) + Integer.parseInt(t[3])
						+ Integer.parseInt(t[1])) * 3
						+ (Integer.parseInt(t[6]) + Integer.parseInt(t[4]) + Integer.parseInt(t[2])
								+ Integer.parseInt(t[0]));
				if (code % 10 == 0) {
					sumanswer += (Integer.parseInt(t[7]) + Integer.parseInt(t[5]) + Integer.parseInt(t[3])
							+ Integer.parseInt(t[1]))
							+ (Integer.parseInt(t[6]) + Integer.parseInt(t[4]) + Integer.parseInt(t[2])
									+ Integer.parseInt(t[0]));
				}
			}

			System.out.println("#" + test_case + " " + sumanswer);
		}
	}

	public static void initmap() {
		map.put("0", "0000");
		map.put("1", "0001");
		map.put("2", "0010");
		map.put("3", "0011");
		map.put("4", "0100");
		map.put("5", "0101");
		map.put("6", "0110");
		map.put("7", "0111");
		map.put("8", "1000");
		map.put("9", "1001");
		map.put("A", "1010");
		map.put("B", "1011");
		map.put("C", "1100");
		map.put("D", "1101");
		map.put("E", "1110");
		map.put("F", "1111");

	}

}
