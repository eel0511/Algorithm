package today3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1581_락스타동호 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[4];
		String[] temp = br.readLine().split(" ");
		//ff , fs , sf , ss
		arr[0] = Integer.parseInt(temp[0]);
		arr[1] = Integer.parseInt(temp[1]);
		arr[2] = Integer.parseInt(temp[2]);
		arr[3] = Integer.parseInt(temp[3]);
		int cnt = 0;
		if (arr[0] == 0 && arr[1] == 0) {
			if (arr[2] == 0) {
				cnt += arr[3];
			} else {
				cnt += arr[3] + 1;
			}
		} else if (arr[1] == 0) {
			cnt += arr[0];
		} else {
			if(arr[1]<=arr[2]) {
				cnt+=arr[0]+arr[1]+arr[1]+arr[3];
			}
			else {
				cnt+=arr[0]+arr[2]+arr[2]+arr[3]+1;
			}
		}
		System.out.println(cnt);
	}

}
