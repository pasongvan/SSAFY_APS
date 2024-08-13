package 연결큐구현;

class Node {
	String data;
	Node prev;
	Node next;
	
	Node() {}
}

public class Solution {
	public static void main(String[] args) {
		LinkedQueue queue = new LinkedQueue();
		
		System.out.println(queue.isEmpty());
		
		queue.enQueue("김김김");
		queue.enQueue("이이이");
		
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		
	}
}

class LinkedQueue {
	Node head = new Node();
	Node tail = new Node();
	int size;
	
	LinkedQueue() {
		head.next = tail;
		tail.prev = head;
	}
	
	// enQueue
	void enQueue(String data) {
		// head로 enQueue
		Node newNode = new Node();
		newNode.data = data;
		
		// 삽입할 노드 링크 연결
		newNode.next = head.next;
		newNode.prev = head;
		
		// head와 뒷 노드 링크 변경
		head.next = newNode;
		newNode.next.prev = newNode;
		
		size++;
	}
	
	// deQueue
	String deQueue() {
		if (isEmpty()) {
			System.out.println("큐 빔");
			return null;
		}
		
		// tail에서 deQueue
		Node deQNode = tail.prev;
		
		// tail과 그 앞 노드 링크 변경
		if (size==1) {
			head.next = tail;
			tail.prev = head;
		}
		else {
			tail.prev = tail.prev.prev;
			tail.prev.prev.next = tail;
		}
		
		size--;
		
		return deQNode.data;
	}
	
	// isEmpty
	boolean isEmpty() {
		return size==0;
	}
}