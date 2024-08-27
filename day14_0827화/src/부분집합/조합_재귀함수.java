package 부분집합;

import java.util.Arrays;

public class 조합_재귀함수 {
	
	static String[] grad = {"상추", "패티", "토마토", "치즈"};
	static int N, R;
	static String[] sel;
	
	public static void main(String[] args) {
		N = 4;
		R = 2;
		sel = new String[R];
		
		combination(0, 0);
	}
	
	static void combination(int idx, int sidx) {
		// 기저조건
		if (sidx == R) {
			// 모든 재료를 전부 다 뽑았다!
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		// 재귀
		for (int i=idx; i<=N-R+sidx; i++) {
			sel[sidx] = grad[i];
			combination(i+1, sidx+1);
		}
	}
}
