package today3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class boj1043_거짓말 {

	static int N, M;
	static int[] cntarr;
	static boolean[] check;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		check = new boolean[N];
		cntarr = new int[M];
		ArrayList<Integer>[] arr = new ArrayList[M];

		int cnt = sc.nextInt();
		for (int i = 0; i < cnt; i++) {
			check[sc.nextInt() - 1] = true;
		}

		for (int i = 0; i < M; i++) {
			cnt = sc.nextInt();
			arr[i] = new ArrayList<>();
			for (int j = 0; j < cnt; j++) {
				arr[i].add(sc.nextInt() - 1);
			}
		}
		//원래는 arraylist의 size가 높은 순으로 쭉 넣어주며 퍼뜨릴려했는데
		//그래도 안되는 경우가 생겨 아래처럼 그냥 M^2번 무지성 반복
//		Arrays.sort(arr, new Comparator<ArrayList<Integer>>() {
//
//			@Override
//			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
//				// TODO Auto-generated method stub
//				if (o1.size() > o2.size())
//					return -1;
//				else if (o1.size() == o2.size())
//					return 0;
//				return 1;
//			}
//
//		});
//		
		//전체에다가 소문 퍼뜨리기
		int total = 0;
		for (int k = 0; k < M; k++) {
			for (int i = 0; i < M; i++) {
				boolean flag = false;
				for (int j : arr[i]) {
					if (check[j]) {
						flag = true;
					}
				}
				if (flag) {
					for (int j : arr[i]) {
						check[j] = true;
					}
				}
			}
		}

		//다 모를때만 total++ 함
		for (int i = 0; i < M; i++) {
			boolean flag = false;
			for (int j : arr[i]) {
				if (check[j]) {
					flag = true;
				}
			}
			if (!flag) {
				total++;
			}
		}

		System.out.println(total);

	}

}
