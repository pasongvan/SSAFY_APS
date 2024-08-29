package 순열구현실습;

import java.util.Arrays;

public class bitmasking {
	
	static int[] arr = {1,2,3,4,5};
	static int N = arr.length;
	static int[] result = new int[N];

	public static void main(String[] args) {
		
		perm(0, 0);

	}

	static void perm(int bit, int depth) {
		// 기저조건
		if (depth == N) {
			System.out.println(Arrays.toString(result));
		}
		
		// 재귀부분
		for(int i=0; i<N; i++) {
			// 방문 여부 확인
			if ((bit & (1<<i)) > 0) continue;
			
			result[depth] = arr[i];
			perm((bit | (1<<i)), depth+1);
		}
	}
}
