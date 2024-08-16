package Heap;

public class Heap {

	static int[] heap = new int[128];
	static int heapSize = 0;
	
	public static void main(String[] args) {


		heapPush(20);
		heapPush(19);
		heapPush(28);
		heapPush(-5);
		heapPush(40);
		heapPush(-18);

	
		while (heapSize != 0) {
			int popItem = heapPop();
			System.out.println(popItem);
		}
	}
	
	// swap
	static void swap(int i, int j) {
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}

	// 삽입
	static void heapPush(int data) {
		// 1. 완전이진트리 마지막에 data 추가
		heap[++heapSize] = data; 
		
		int p = heapSize / 2;
		int ch = heapSize;
		
		while (ch != 1 && heap[p] > heap[ch]) {
			// 2. 부모보다 자식이 더 작으면 swap
			swap(p ,ch);
			
			// 3. swap 이후 인덱스 갱신
			ch = p;
			p = ch /2;
		}
	}
	
	// 삭제 연산
	static int heapPop() {
		// 1. root에 있는 데이터 저장
		int popItem = heap[1];
		
		// 2. 마지막 노드를 루트로 옮김
		heap[1] = heap[heapSize--];
		
		// 3. 자식과 부모 비교하여 swap 반복
		int p = 1;
		int ch = p*2; // 왼쪽 자식
		if (ch + 1 <= heapSize && heap[ch] > heap[ch+1]) // 오른쪽 자식이 더 작으면
			ch++;
		
		while (ch <= heapSize && heap[ch] < heap[p]) {
			swap(p, ch);
			
			// 4. swap 이후 인덱스 갱신
			p = ch;
			ch = p*2;
		}
		
		return popItem;
	}
}




