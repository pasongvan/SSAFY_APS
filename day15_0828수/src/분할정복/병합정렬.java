package 분할정복;

import java.util.Arrays;

public class 병합정렬 {

	static int[] arr = {7,5,13,2,79,12,35,42};
	static int N = arr.length;
	static int[] tmp = new int[N];
	
	public static void main(String[] args) {
		
		mergeSort(0, N-1);
		System.out.println(Arrays.toString(arr));

	}
	static void mergeSort(int left, int right) {
		if (left >= right) return;
		
		int mid = (left+right) / 2;
		mergeSort(left, mid);
		mergeSort(mid+1, right);
		merge(left, mid, right);
	}
	
	static void merge(int left, int mid, int right) {
		int L = left; // 왼쪽 구간 시작 포인트
		int R = mid + 1; // 오른쪽 구간 시작 포인트
		
		int idx = left; // tmp 배열의 인덱스
		
		while(L<=mid && R<=right) { // 왼쪽, 오른쪽 모두 끝에 도달하지 않았을 때
			
			if (arr[L] <= arr[R])
				tmp[idx++] = arr[L++];
			else 
				tmp[idx++] = arr[R++];
		}
		// 왼쪽이 남은 경우
		if (L <= mid) {
			for (int i=L; i<=mid; i++) {
				tmp[idx++] = arr[i];
			}
		}
		// 오른쪽이 남은 경우
		else {
			for (int i=R; i<=right; i++) {
				tmp[idx++] = arr[i];
			}
		}
		// 원본 배열에 반영하기
		for (int i=left; i<=right; i++) {
			arr[i] = tmp[i];
		}
	}
}
