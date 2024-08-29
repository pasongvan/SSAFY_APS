package 백트래킹;

import java.util.Arrays;

public class 순열04_비트마스킹 {
	
	static int[] nums;
	static int N;
	// 추가 공간
	static int[] result;

	public static void main(String[] args) {
		nums = new int[] {0, 1, 2};
		N = nums.length;
		result = new int[N];
		perm(0, 0);
	}
	
	static void perm(int idx, int visited) {
		// 기저조건
		if (idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		// 재귀부분
		for (int i=0; i<N; i++) {
			if ((visited & (1 << i)) != 0) continue;
				
			result[idx] = nums[i];
			perm(idx+1, visited | (1<<i));
		}
	}
	
	

}
