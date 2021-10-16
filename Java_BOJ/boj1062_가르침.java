package today4;

import java.util.Scanner;

public class boj1062_가르침 {

	static int N,K,max;
	static String[] arr;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		K= sc.nextInt();
		arr = new String[N];
		check = new boolean[26];
		max=0;
		if(K<5) {
			System.out.println(0);
			System.exit(0);
		}
		for(int i=0;i<N;i++) {
			arr[i]=sc.next().replace("anta", "").replace("tica", "");
		}
		check['a'-'a']=true;
		check['n'-'a']=true;
		check['t'-'a']=true;
		check['i'-'a']=true;
		check['c'-'a']=true;
		
		back(0,0);
		System.out.println(max);
		
	}
	public static void back(int alpah,int len) {
		if(len==K-5) {
			int cnt =0;
			for (int i = 0; i < arr.length; i++) {
				boolean flag = true;
				for(int j=0;j<arr[i].length();j++) {
					if(!check[arr[i].charAt(j)-'a']) {
						flag= false;
						break;
					}
				}
				if(flag) {
					cnt++;
				}
			}
			max = Integer.max(max,cnt);
			return;
		}
		for(int i =alpah;i<26;i++) {
			if(!check[i]) {
				check[i]=true;
				back(i,len+1);
				check[i]=false;
			}
		}
	}
}
