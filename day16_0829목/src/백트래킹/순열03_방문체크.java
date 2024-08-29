package 백트래킹;

import java.util.Arrays;

public class 순열03_방문체크 {
	
	static int[] nums;
	static int N;
	// 추가 공간
	static boolean[] visited;
	static int[] result;

	public static void main(String[] args) {
		nums = new int[] {0, 1, 2};
		N = nums.length;
		visited = new boolean[N];
		result = new int[N];
		perm(0);
	}
	
	static void perm(int idx) {
		// 기저조건
		if (idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		// 재귀부분
		for (int i=0; i<N; i++) {
			if (!visited[i]) {
				result[idx] = nums[i];
				visited[i] = true;
				perm(idx+1);
				visited[i] = false;
			}
		}
	}
	
	

}
