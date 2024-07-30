import java.util.Arrays;

public class SortSearch {

	public static void main(String[] args) {
		
		// 버블 정렬
		int[] arrBubble = {55, 7, 78, 12, 42};
		arrBubble = bubbleSort(arrBubble);
		System.out.println(Arrays.toString(arrBubble));
		
		// 선택 정렬
		int[] sel = {64, 25, 10, 22, 11};
		sel = selectionSort(sel);
		System.out.println(Arrays.toString(sel));
		
		// 카운팅정렬
		int[] arrcnt = {0, 4, 1, 3, 1, 2, 4, 1};
		int max = 4;
		arrcnt = countingSort(arrcnt, max);
		System.out.println(Arrays.toString(arrcnt));
		
		// 순차검색
		int[] seq = {4, 9, 11, 23, 2, 19, 7};
		int idx = seqSearch(seq, 2);
		System.out.println(idx);

		// 이진검색
		int[] bi = {2, 4, 7, 9, 11, 19, 23};
		int index = biSearch(bi, 1);
		System.out.println(index);
		
	}
	// 이진 검색 메소드
	static int biSearch(int[] bi, int target) {
		int first = 0;
		int last = bi.length - 1;
		int middle;
		while (first <= last) {
			middle = (first + last) / 2; 
			if (bi[middle] == target) {
				return middle;
			}
			else if (bi[middle] > target) {
				last = middle - 1;
			}
			else {
				first = middle + 1;
			}
		}
		return -1;
	}
	
	// 순차 검색 메소드
	static int seqSearch(int[] seq, int target) {
		int idx = -1;
		for (int i=0; i<seq.length; i++) {
			if (seq[i] == target) {
				idx = i;
			}
		}
		return idx;
	}
	
	// 카운팅 정렬 메소드
	static int[] countingSort(int[] arrcnt, int max) {
		int[] cnting = new int[max+1];
		for (int i=0; i<arrcnt.length; i++) { // {1, 3, 1, 1, 2}
			cnting[arrcnt[i]]++;
		}
		for (int i=1; i<=max; i++) { // {1, 4, 5, 6, 8}
			cnting[i] += cnting[i-1];
		}
		int [] newarr = new int[arrcnt.length];
		for (int i=arrcnt.length-1; i>=0; i--) { // {0, 1, 1, 1, 2, 3, 4, 4}
			cnting[arrcnt[i]]--;
			newarr[cnting[arrcnt[i]]] = arrcnt[i];
		}
		return newarr;
	}
	
	// 선택 정렬 메소드
	static int[] selectionSort(int[] sel) {
		for (int i=0; i<sel.length; i++) {
			int min = sel[i];
			int idx = i;
			for (int j=sel.length-1; j>=i; j--) {
				if (min > sel[j]) {
					min = sel[j];
					idx = j;
				}
			}
			sel[idx] = sel[i];
			sel[i] = min;
		}
		return sel;
	}
	
	// 버블 정렬 메소드
	static int[] bubbleSort(int[] arrBubble) {
		int tmp;
		for (int i=0; i<arrBubble.length-1; i++) {
			for (int j=i; j<arrBubble.length-1; j++) {
				if (arrBubble[j] > arrBubble[j+1]) {
					tmp = arrBubble[j];
					arrBubble[j] = arrBubble[j+1];
					arrBubble[j+1] = tmp;
				}
			}
		}
		return arrBubble;
	}

}
