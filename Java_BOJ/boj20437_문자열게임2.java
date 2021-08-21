package today;

import java.util.ArrayList;
import java.util.Scanner;

public class boj20437_문자열게임2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		//N 회 반복
		for (int i = 0; i < N; i++) {
			//문자열 받아서 string 배열에 넣고
			String[] st = sc.next().split("");
			//a~z의 인덱스를 담을 arraylist 배열 생성
			ArrayList<Integer>[] arr = new ArrayList[26];
			//init
			for (int j = 0; j < arr.length; j++) {
				arr[j] = new ArrayList<>();
			}
			//문자열을 하나씩 처리하는데 a~z => 0~25로 각 arraylist에 그 값의 인덱스를 계속 넣음
			for (int j = 0; j < st.length; j++) {
				int a = st[j].charAt(0) - 'a';
				arr[a].add(j);
			}
			boolean check=false;
			int K = sc.nextInt();
			int first = Integer.MAX_VALUE;
			int second = Integer.MIN_VALUE;

			//a~z에 대해서 자신이 나타난 인덱스를 담고있는 [26][n]의 arraylist가 잇으므로
			//각각에 대해 루프를 돌며 우선 K회 이상 나타난 문자에 대해서만 조사(K회미만나타나면 답이안되므로)
			for (int j = 0; j < arr.length; j++) {
				if (arr[j].size() >= K) {
					check=true;
					int start = 0;
					int end = K - 1;
					//first는 어떤 문자를 정확히 K개를 포함하는 가장 짧은 연속 문자열의 길이
					//second는 어떤 문자를 정확히 K개를 포함하고, 문자열의 첫 번째와 마지막 글자가 해당 문자로 같은 가장 긴 연속 문자열의 길이
					//이것을 a~z모두 시행해주며 값을 갱신해나간다
					while (end < arr[j].size()) {
						first = Integer.min(first, arr[j].get(end) - arr[j].get(start) + 1);
						second = Integer.max(second, arr[j].get(end) - arr[j].get(start) + 1);
						start++;
						end++;
					}
				}
			}
			//값이 한번도 갱신되지 않았으면 -1 아니라면 정답 출력
			if(!check) {
				System.out.println(-1);
				continue;
			}else {
				System.out.println(first+" "+second);
			}
		}

	}
}
