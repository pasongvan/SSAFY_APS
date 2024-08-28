package 호어파티션;

import java.util.Arrays;

public class Solution {
	
	static int[] arr = {50,2,198,19,198,183,3,23,11,64};
	static int N = arr.length;

	public static void main(String[] args) {
		
		hoare(0, N-1);
		System.out.println(Arrays.toString(arr));

	}
	
	// 첫요소를 피봇으로 골라서 피봇을 중심으로 양 옆을 분배
	// 양 옆에 대해 재귀
	static void hoare(int left, int right) {
		
		if (left >= right) return;
		
		int pivot = partition(left, right);
		hoare(left, pivot-1);
		hoare(pivot+1, right);
	}
	
	static int partition(int left, int right) {
		
		int pivot = left;
		int L = left + 1;
		int R = right;
		
		while (L < R) {
			// 왼쪽에서 피벗보다 큰 원소 나올 때까지 앞으로
			while (arr[L] <= arr[pivot]) L++;
			// 오른쪽에서 피봇보다 작은 원소 나올 때까지 뒤로
			while (arr[R] >= arr[pivot]) R--;
			
			// L이 R보다 작으면 위치 바꾸기
			if (L < R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		// 피봇을 둘 사이에 끼워주기
		int tmp = arr[pivot];
		arr[pivot] = arr[R];
		arr[R] = tmp;
		
		// 피봇 위치 반환
		return R;
	}

}
