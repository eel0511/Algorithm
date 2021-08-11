package today;

import java.io.*;
import java.util.*;

public class boj1764_듣보잡 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		Set<String> set = new HashSet<>();
		ArrayList<String> list = new ArrayList<>();

		// set에 추가
		for (int i = 0; i < N; i++) {
			String temp = sc.next();
			set.add(temp);
		}
		// set과 비교해서 들어잇으면 list에 추가
		for (int i = 0; i < M; i++) {
			String temp = sc.next();
			if (set.contains(temp)) {
				list.add(temp);
			}
		}

		Collections.sort(list);
		System.out.println(list.size());
		for (String temp : list) {
			System.out.println(temp);
		}

	}

}
