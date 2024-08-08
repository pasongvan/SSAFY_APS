package Queue2;

import java.util.Arrays;

public class 우선순위1차원 {
	
	static int[] queue = new int[100];
	static int front = -1;
	static int rear = -1;

	public static void main(String[] args) {

		enQueue(1);
		enQueue(2);
		enQueue(3);
		enQueue(4);
		enQueue(5);
		enQueue(6);
		
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());

	}
	static void enQueue(int data) {
		queue[++rear] = data;
		int i = rear;
		int j;
		for (j=i-1; j>=0 && queue[j]<data; j--) {
			queue[j+1] = queue[j];
		}
		queue[j+1] = data;
	}
	
	static int deQueue() {
		return queue[++front];
	}

}
