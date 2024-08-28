package 분할정복;

public class 이진검색01_이진검색_반복 {
	
	static int[] arr = { 8, 9, 17, 21, 23, 35, 88, 369 };
	static int key = 19;

	public static void main(String[] args) {

		binarySearch(0, arr.length-1);

	}

	static boolean binarySearch(int left, int right) {

		// 기저조건
		if (left > right) return false;
		
		// 재귀부분
		int mid = (left + right) / 2;
		
		// 1. 같을 때
		if (arr[mid] == key) return true;
		
		// 2. 클 때
		else if (arr[mid] > key) 
			return binarySearch(left, mid-1);
		
		// 3. 작을 때
		else 
			return binarySearch(mid+1, right);
	}
}