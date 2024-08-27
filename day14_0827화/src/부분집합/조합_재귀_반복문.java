package 부분집합;

import java.util.Arrays;

public class 조합_재귀_반복문 {
	
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
		if (idx == N) {
			return;
		}
		
		// 재귀
		// 해당 idx 번째 재료를 사용했는지 안했는지
		sel[sidx] = grad[idx];
		combination(idx+1, sidx+1);
		
//		sel[sidx] = null; // 재료 사용 x: 나중에 덮어써버림
		combination(idx+1, sidx); // 햄버거의 실제 재료를 아직 뽑지 않았다.
	}
}
