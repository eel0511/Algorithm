package today4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class boj17255_N으로만들기 {

	static int num, total;
	static ArrayList<Integer> list;

	static String temp;
	static HashSet<String> set;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		set = new HashSet<>();
		temp = br.readLine();
		num = temp.length();
		total = 0;
		list = new ArrayList<>();
		for (int i = 0; i < temp.length(); i++) {
			list.add(temp.charAt(i) - '0');
		}

		back(0, "", "");
		System.out.println(set.size());

	}

	public static void back(int depth, String s, String st) {
		if (depth == num) {

			if (s.equals(temp)) {
				set.add(st);

			}

			return;
		}

		for (int i : list) {

			back(depth + 1, s + i, st + s + i);
			back(depth + 1, i + s, st + s + i);

		}
	}
}
