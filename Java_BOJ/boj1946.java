package today;

import java.util.HashMap;
import java.util.Scanner;

public class boj1946 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int i = 0; i < testcase; i++) {
			int num = sc.nextInt();
			HashMap<Integer, Integer> map = new HashMap<>();

			for (int j = 0; j < num; j++) {
				map.put(sc.nextInt(), sc.nextInt());
			}
			System.out.println(map.toString());
			int cnt = 0;
			int save = map.get(1);
			for (int j = 2; j <= map.size(); j++) {
				System.out.println(map.get(j)+" "+save);
				if (map.get(j) < save) {
					cnt++;
					save = map.get(j);
					
				}

			}
			System.out.println(cnt);
		}

	}

}
