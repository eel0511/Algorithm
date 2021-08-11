package today;

import java.io.*;
import java.util.*;

public class boj1764_듣보잡 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String temp = sc.next();
			list1.add(temp);
		}

		for (int i = 0; i < M; i++) {
			String temp = sc.next();
			list2.add(temp);
		}

		Collections.sort(list1);
		Collections.sort(list2);
		for (String temp : list1) {

			if (Collections.binarySearch(list2, temp) >0) {
				result.add(temp);
			}
		}
		
		Collections.sort(result);
		System.out.println(result.size());
		for(String temp : result) {
			System.out.println(temp);
		}

	}

}
