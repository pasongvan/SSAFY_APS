package 백트래킹;

import java.util.Arrays;

public class 순열02_swap {
	
	static int[] nums;
	static int N;

	public static void main(String[] args) {
		nums = new int[] {0, 1, 2};
		N = nums.length;
		
		perm(0);
	}
	
	static void perm(int idx) {
		// 기저조건
		if (idx == N) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		// 재귀부분
		for (int i=idx; i<N; i++) {
			swap(i, idx);
			perm(idx+1);
			swap(i, idx);
		}
	}
	
	static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}

}
