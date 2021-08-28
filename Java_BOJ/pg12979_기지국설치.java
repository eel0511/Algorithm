package today;

public class pg12979_기지국설치 {
	public int solution(int n, int[] stations, int w) {
		int answer = 0;
		int po = 1;
		int index = 0;

		while (po <= n) {
			if (index < stations.length && po >= stations[index] - w) {
				po = stations[index++] + w + 1;
			} else {
				answer++;
				po += (w * 2) + 1;
			}
		}

		return answer;
	}
}
