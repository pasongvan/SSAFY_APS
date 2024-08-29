package 순열구현실습;

import java.util.Arrays;

public class visit {
	
	static int[] arr = {1,2,3,4,5};
	static int N = arr.length;
	static boolean[] visit = new boolean[N];
	static int[] result = new int[N];

	public static void main(String[] args) {

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
			if (visit[i]) continue;
			
			visit[i] = true;
			result[idx] = arr[i];
			perm(idx+1);
			visit[i] = false;
		}
	}

}
