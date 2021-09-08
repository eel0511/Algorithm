package today3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class sw1767_프로세서연결하기 {

	static int N;
	static int[][] board;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static LinkedList<int[]> list;
	static int maxcnt;
	static int minlength;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			list = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				String[] temp = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(temp[j]);
					// 벽에붙어있지않은 탐색이필요한 프로세서들을 list에 저장
					if (board[i][j] == 1 && isNotlast(i, j)) {
						list.add(new int[] { i, j });
					}
				}
			}
			maxcnt = Integer.MIN_VALUE;
			minlength = Integer.MAX_VALUE;
			dfs(0, 0, 0);
			System.out.println("#" + t + " " + minlength);
		}
	}

	public static void dfs(int start, int cnt, int len) {
		if (start == list.size()) {
			makesize(cnt, len);
			return;
		}
		int x = list.get(start)[0];
		int y = list.get(start)[1];
		for (int i = 0; i < dx.length; i++) {
			int lencnt = 0;
			int savex = x;
			int savey = y;
			int newx = x;
			int newy = y;
			// 단방향으로 계속 이어나가서 벽으로 연결되면 lencnt값저장
			// 다른 선에 부딪히면 값X 하고 밑의 재귀로 다음프로세서로넘김
			while (true) {
				newx += dx[i];
				newy += dy[i];
				if (!isNotWall(newx, newy))
					break;
				if (board[newx][newy] == 1) {
					lencnt = 0;
					break;
				}
				lencnt++;
			}
			// 벽으로 연결된경우 선을 쭉 그려줌
			for (int j = 0; j < lencnt; j++) {
				savex += dx[i];
				savey += dy[i];
				board[savex][savey] = 1;
			}
			// 다른선에 부딪혔을때는 다음프로세서로
			if (lencnt == 0) {
				dfs(start + 1, cnt, len);
			}
			// 백트래킹으로 그린선길이와 연결된갯수를 재귀하고 그렸던선을 지움
			else {
				dfs(start + 1, cnt + 1, len + lencnt);
				savex = x;
				savey = y;
				for (int j = 0; j < lencnt; j++) {
					savex += dx[i];
					savey += dy[i];
					board[savex][savey] = 0;
				}
			}
		}
	}

	public static void makesize(int cnt, int len) {
		// 프로세서개수가 더 많이 연결된다면 minlength를 강제로 변환
		if (maxcnt < cnt) {
			maxcnt = cnt;
			minlength = len;
		} // 같은 개수라면더 짧은 전선길이를 저장
		else if (maxcnt == cnt) {
			minlength = Integer.min(minlength, len);
		}
	}

	public static boolean isNotlast(int x, int y) {
		if (x > 0 && x < N - 1 && y > 0 && y < N - 1)
			return true;
		return false;
	}

	public static boolean isNotWall(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N)
			return true;
		return false;
	}

}
