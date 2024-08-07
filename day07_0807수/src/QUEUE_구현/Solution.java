package QUEUE_구현;

import java.util.Arrays;

public class Solution {
	
	static int[] queue = new int[10];
	static int front = -1;
	static int rear = -1;
	
	public static void main(String[] args) {
		System.out.println(isEmpty());
		
		enQueue(1);
		enQueue(2);
		enQueue(3);
		System.out.println(Arrays.toString(queue));
		
		System.out.println(deQueue());
		
		System.out.println(isEmpty());
		System.out.println(isFull());
		
		System.out.println(Qpeek());
	}
	
	// enQueue
	static void enQueue(int item) {
		if (isFull()) {
			System.out.println("꽉 참");
			return;
		}
		queue[++rear] = item;
	}
	
	// deQueue
	static int deQueue() {
		if (isEmpty()) {
			System.out.println("비어있음");
			return -9999;
		}
		return queue[++front];
	}
	
	// isEmpty
	static boolean isEmpty() {
		return front == rear;
	}
	
	// isFull
	static boolean isFull() {
		return rear == queue.length-1;
	}
	
	// Qpeek
	static int Qpeek() {
		if (isEmpty()) {
			System.out.println("비어있음");
			return -9999;
		}
		return queue[front + 1];
	}
}