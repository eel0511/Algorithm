package today;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj9655_돌게임 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()) % 6;
		if (N % 2 == 1)
			System.out.println("SK");
		else
			System.out.println("CY");
	}

}
