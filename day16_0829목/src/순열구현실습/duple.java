package 순열구현실습;

import java.util.Arrays;

public class duple {
	
	static int[] arr = {1,2,3,4,5};
	static int N = arr.length;
	static int[] result = new int[N];

	public static void main(String[] args) {

		perm(0);

	}

	static void perm(int depth) {
		// 기저조건
		if (depth == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		// 재귀조건
		for (int i=0; i<N; i++) {
			result[depth] = arr[i];
			perm(depth+1);
		}
	}
}
