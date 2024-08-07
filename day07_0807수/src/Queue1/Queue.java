package Queue1;

import java.util.Scanner;

public class Queue {
	
	static String[] queue = new String[10]; // 10번 삽입 가능한 큐
	static int front = -1;
	static int rear = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i=0; i<11; i++) {
			enQueue("해");
		}
		
		System.out.println(size());
		
		while(!isEmpty()) {
			String rItem = deQueue();
			System.out.println(rItem);
		}

	}

	// 공백상태 확인
	static boolean isEmpty() {
		return front == rear;
	}
	
	// 포화상태 확인
	static boolean isFull() {
		return rear == queue.length -1 ;
	}
	
	// 삽입
	static void enQueue(String item) {
		if (isFull()) {
			System.out.println("큐 가득");
			return;
		}
		queue[++rear] = item;
	}
	
	// 삭제
	static String deQueue() {
		if (isEmpty()) {
			System.out.println("큐에 원소 없음");
			return null;
		}
		return queue[++front];
	}
	
	// 조회
	static String Qpeek() {
		if (isEmpty()) {
			System.out.println("큐에 원소 없음");
			return null;
		}
		return queue[front + 1];
	}
	
	// 크기 조회
	static int size() {
		return rear - front;
	}
}
