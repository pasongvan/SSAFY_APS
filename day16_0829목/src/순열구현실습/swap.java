package 순열구현실습;

import java.util.Arrays;

public class swap {
	
	static int[] arr = {1, 2, 3, 4, 5};
	static int N = arr.length;

	public static void main(String[] args) {
		
		perm(0);
	}
	
	// 중복x 순열
	static void perm(int idx) {
		// 기저 조건
		if (idx >= N) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		// 재귀 부분
		for (int i=idx; i<N; i++) {
			swap(i, idx);
			perm(idx+1);
			swap(i, idx);
		}
		
	}
	
	// swap 메소드
	static void swap(int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}

}
