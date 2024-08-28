package 로무토파티션;

import java.util.Arrays;

public class Solution {

	static int[] arr = {645,46,46,648,49,43,1,31,7,50};
	static int N = arr.length;
	
	public static void main(String[] args) {
		
		lomuto(0, N-1);
		System.out.println(Arrays.toString(arr));
	}

	static void lomuto(int left, int right) {
		
		// 기저조건
		if (left >= right) return;
		
		int pivot = partition(left, right);
		lomuto(left, pivot-1);
		lomuto(pivot+1, right);
	}
	
	static int partition(int left, int right) {
		
		int pivot = right;
		int i = left - 1;
		int j = left;
		
		while (j < right) {
			// j인덱스가 pivot보다 작거나 같으면 i++, arr[i], arr[j] 위치 변경
			if (arr[j] <= arr[pivot]) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
			// j++
			j++;
		}
		// 피봇이 들어갈 자리는 i+1
		int tmp = arr[pivot];
		arr[pivot] = arr[i+1];
		arr[i+1] = tmp;
		
		// 피봇 위치 반환
		return i+1;
	}
}
