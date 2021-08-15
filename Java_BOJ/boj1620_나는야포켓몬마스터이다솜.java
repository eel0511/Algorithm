package today;

import java.util.HashMap;
import java.util.Scanner;

public class boj1620_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String temp = sc.next();
			map.put(temp, (i + 1) + "");
			map.put((i + 1) + "", temp);
		}

		for (int i = 0; i < M; i++) {
			System.out.println(map.get(sc.next()));
		}
	}

}
