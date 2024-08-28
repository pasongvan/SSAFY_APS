package 병합정렬;

import java.util.Arrays;

public class Solution {
	
	static int[] arr = {6,654,7,31,2,64,4,13,64};
	static int N = arr.length;
	static int[] tmp = new int[N];

	public static void main(String[] args) {

		mergeSort(0, N-1);
		System.out.println(Arrays.toString(arr));

	}
	static void mergeSort(int left, int right) {
		
		// 기저 조건
		if (left >= right) return;
		
		// 반으로 자르기
		int mid = (left + right) / 2;
		
		// 왼쪽 부분
		mergeSort(left, mid);
		// 오른쫀 부분
		mergeSort(mid+1, right);
		
		// 정렬해주기
		int L = left;
		int R = mid + 1;
		int idx = left;
		
		while(L <= mid && R <= right) {
			// 왼쪽이 더 작으면 왼쪽 담기
			if (arr[L] < arr[R]) 
				tmp[idx++] = arr[L++]; 
			// 오른쪽이 더 작으면 오른쪽 담기
			else 
				tmp[idx++] = arr[R++];
		}
		
		// 왼쪽이 남은 경우
		if (L <= mid) {
			while (L <= mid) 
				tmp[idx++] = arr[L++];
		}
		// 오른쪽이 남은 경우
		else {
			while (R <= right) 
				tmp[idx++] = arr[R++];
		}
		
		// 임시 배열을 원래 배열에 저장
		for (int i=left; i<=right; i++) {
			arr[i] = tmp[i];
		}
	}
}

// 병합정렬
// 반으로 나누기
// 재귀 병합
// 합치기