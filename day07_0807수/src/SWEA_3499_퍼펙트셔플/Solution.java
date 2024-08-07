package SWEA_3499_퍼펙트셔플;

import java.util.Scanner;

public class Solution {
	
	// 큐 선언
	static String[] queue;
	static int front = -1;
	static int rear = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 입력 및 초기화
			int len = sc.nextInt();
			front = -1;
			rear = -1;
			queue = new String[len];
			
			for (int i=0; i<len; i++) {
				String word = sc.next();
				offer(word);
			}
			
			// 출력
			System.out.print("#" + test_case + " ");
			// 홀수인경우 1회 먼저 시작
			if (len%2==1) {
				System.out.print(poll() + " ");
				for (int i=0; i<len/2; i++) {
					offer(poll());
				}
			}
			// 큐가 빌 때까지 반복
			int iter = len/2-1;
			while(!isEmpty()) {
				System.out.print(poll() + " ");
				for (int i=0; i<iter; i++) {
					offer(poll());
				}
				System.out.print(poll() + " ");
				for (int i=0; i<iter; i++) {
					offer(poll());
				}
				iter--;
			}
			System.out.println();
		}
	}
	
	// offer
	static void offer(String item) {
		if (isFull()) 
			return;
		queue[++rear] = item;
	}
	
	// poll
	static String poll() {
		if (isEmpty())
			return null;
		String pollOut = queue[0];
		rear--;
		for (int i=0; i<=rear; i++) {
			queue[i] = queue[i+1];
		}
		return pollOut;
	}
	
	// isEmpty
	static boolean isEmpty() {
		return rear == -1;
	}
	
	// ifFull
	static boolean isFull() {
		return rear == queue.length -1;
	}
}