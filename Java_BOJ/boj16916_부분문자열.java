package today2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj16916_부분문자열 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split("");
		String[] p = br.readLine().split("");

		System.out.println(KMP(s, p));

	}

	static int KMP(String[] s, String[] p) {
		int[] table = makeTable(p);
		int n1 = s.length;
		int n2 = p.length;

		int idx = 0;
		for (int i = 0; i < n1; i++) {
			while (idx > 0 && !s[i].equals(p[idx])) {
				idx = table[idx - 1];
			}

			if (s[i].equals(p[idx])) {
				if (idx == n2 - 1) {
					return 1; // 매칭이 되었으면 1
				} else {
					idx += 1;
				}
			}
		}

		return 0; // 매칭이 안되었으면 0

	}

	static int[] makeTable(String[] p) {
		int n = p.length;
		int[] table = new int[n];

		int idx = 0;
		for (int i = 1; i < n; i++) {
			// 일치하는 문자가 발생했을 때(idx>0),
			// 연속적으로 더 일치하지 않으면 idx = table[idx-1]로 돌려준다.
			while (idx > 0 && !p[i].equals(p[idx])) {
				idx = table[idx - 1];
			}

			if (p[i].equals(p[idx])) {
				idx += 1;
				table[i] = idx;
			}
		}

		return table;
	}

}
