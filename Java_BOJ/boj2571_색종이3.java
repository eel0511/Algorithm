package today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2571_색종이3 {
	static int[][] board;
	static int result = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		board = new int[101][101];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = Integer.parseInt(temp[0]); j < Integer.parseInt(temp[0]) + 10; j++) {
				for (int k = Integer.parseInt(temp[1]); k < Integer.parseInt(temp[1]) + 10; k++) {
					board[k][j]++;
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] >= 1) {
					check(i,j);
				}
			}
		}
		System.out.println(result);

	}

	public static boolean isNotWall(int x, int y) {
		if (x >= 0 && x < 100 && y >= 0 && y < 100) {
			return true;
		}
		return false;
	}
	public static boolean isPaper(int x, int y, int endx,int endy) {
		for (int i =x; i <= endx; i++) {
			for (int j = y; j <= endy; j++) {
				if(board[i][j]<1) {
					return false;
				}
			}
		}
		return true;
	}

	public static void check(int x, int y) {
		for (int i = 0; i < 100; i++) {
			if(!isNotWall(x+i, y)||board[x+i][y]<1) {
				break;
			}
			for (int j = 0; j < 100; j++) {
				if(!isNotWall(x, y+j)||board[x][y+j]<1) {
					break;
				}
				if(isPaper(x, y, x+i,y+j)) {
					result = Integer.max(result, (i+1)*(j+1));
					
				}
			}
		}
	}

}
