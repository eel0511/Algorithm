package today3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class sw2115_벌꿀채취 {

	static int[][] board;
	static boolean[][] check;
	static int N, M, C;
	static int result;
	static int[][] save;
	static int[] money;
	static boolean[] honeycheck;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			String[] temp = br.readLine().split(" ");
			N = Integer.parseInt(temp[0]);
			M = Integer.parseInt(temp[1]);
			C = Integer.parseInt(temp[2]);
			board = new int[N][N];
			check = new boolean[N][N];
			save = new int[2][N];
			honeycheck = new boolean[N];
			result = 0;
			for (int i = 0; i < board.length; i++) {
				temp = br.readLine().split(" ");
				for (int j = 0; j < board.length; j++) {
					board[i][j] = Integer.parseInt(temp[j]);
				}
			}
			dfs(0);
			System.out.println("#" + t + " " + result);
		}
	}

	// 값 계산을 위한 메소드
	public static void clac(int cnt, int sum, int curmoney) {
		// 일꾼이 벌어들일수있는 값의 최댓값을 저장
		money[cnt] = Integer.max(money[cnt], curmoney);

		// curmoney는 일꾼이 현재 위치에서 벌어들일수있는 돈
		// C를 넘으면 안되기때문에 다양한 조합이 발생가능하므로 백트래킹사용
		for (int i = 0; i < M; i++) {
			if (!honeycheck[i]) {
				if (C - sum >= save[cnt][i]) {
					honeycheck[i] = true;
					clac(cnt, sum + save[cnt][i], curmoney + (int) Math.pow(save[cnt][i], 2));
					honeycheck[i] = false;
				}
			}
		}
	}

	// 2명의 일꾼의 경우로 백트래킹
	public static void dfs(int cnt) {
		// 2명다 자리 잡았으면 그 부분에서의 최댓값계산
		if (cnt == 2) {
			money = new int[2];
			for (int i = 0; i < 2; i++) {
				clac(i, 0, 0);
			}
			int total = money[0] + money[1];
//			System.out.println(money[0]+" "+money[1]);
//			System.out.println(total);
			result = Integer.max(result, total);
			return;
		}
		// 일꾼이 전체 Map에서 가로로만 자리를 잡을수있음
		// M개의 벌통 선택가능하므로
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				// 가로에서 M범위가 넘으면안됨
				if (j + M <= N) {
					// 그리고 이미 다른일꾼이 선택한 벌통도안됨
					boolean flag = false;
					for (int k = j; k < j + M; k++) {
						if (check[i][k]) {
							flag = true;
							break;
						}
					}
					if (flag)
						continue;
					// save[일꾼번호][j~j+M]으로 일꾼이 차지한벌통을복사
					// 백트래킹으로 모두 탐색
					for (int k = j; k < j + M; k++) {
						check[i][k] = true;
						save[cnt][k - j] = board[i][k];
					}
					dfs(cnt + 1);
					for (int k = j; k < j + M; k++) {
						check[i][k] = false;
					}
				}
			}
		}
	}
}
