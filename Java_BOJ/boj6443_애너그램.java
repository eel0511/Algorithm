package today4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj6443_애너그램 {
	static boolean[] temp;
	static char[] arr;
	static char[] result;
	static BufferedWriter bw;
	static char[] check;

	public static void main(String[] args) throws IOException {
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new char[N];

		for (int i = 0; i < N; i++) {

			arr = br.readLine().toCharArray();
			Arrays.sort(arr);
			result = new char[arr.length];
			temp = new boolean[arr.length];
			check = new char[arr.length];
			back(i, arr.length, 0);

		}
		bw.close();

	}

	public static void back(int start, int maxlen, int len) throws IOException {

		if (len == maxlen) {

			bw.write(result);
			bw.write("\n");

			return;
		}
		check[len]=0;
		for (int i = 0; i < maxlen; i++) {
			if (!temp[i]) {
				if (check[len] >= arr[i])
					continue;
				
				check[len]=arr[i];
				temp[i] = true;
				result[len] = arr[i];
				back(i, maxlen, len + 1);
				temp[i] = false;

			}
		}
	}

}
