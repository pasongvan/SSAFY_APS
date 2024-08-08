package Queue2;

import java.util.Arrays;

public class 원형큐 {

	// 배열 크기 4 => 최대 원소 3개
	static String[] queue = new String[4];
	static int N = queue.length;
	static int front, rear;
	
	public static void main(String[] args) {
		
		enQueue("배리본즈");
		enQueue("랜디존슨");
		enQueue("커트실링");
		enQueue("제이슨지암비");
		
		System.out.println(size());
		System.out.println(Arrays.toString(queue));
		
		deQueue();
		deQueue();
		deQueue();
		deQueue();
		enQueue("제이슨지암비");
		enQueue("롭넨");
		enQueue("데이비드오티즈");
		
		System.out.println(size());
		System.out.println(Arrays.toString(queue));
	}

	// 포화상태 확인
	static boolean isFull() {
		return (N + front - rear) % N == 1;
	}
	
	// 공백상태 확인
	static boolean isEmpty() {
		return front == rear;
	}
	
	// 삽입
	static void enQueue(String item) {
		if (isFull()) {
			System.out.println("큐 가득");
			return;
		}
		rear = (rear + 1) % N;
		queue[rear] = item;
	}
	
	// 삭제
	static String deQueue() {
		if (isEmpty()) {
			System.out.println("큐 빔");
			return null;
		}
		front = (front + 1) % N;
		String item = queue[front];
		queue[front] = null;
		return item;
	}
	
	// 조회
	static String Qpeek() {
		if (isEmpty()) {
			System.out.println("큐 빔");
			return null;
		}
		return queue[(front + 1) % N];
	}
	
	// 데이터 개수 세기
	static int size() {
		return (rear - front + N) % N;
	}
}
