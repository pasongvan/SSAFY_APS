package 연결스택구현;

class Node {
	String data;
	Node link;
}

public class Solution {
	public static void main(String[] args) {
		LinkedStack stack = new LinkedStack();
		
		System.out.println(stack.isEmpty());
		
		stack.push("마이크 트라웃");
		stack.push("무키 베츠");
		stack.push("애런 저지");
		
		System.out.println(stack.size());
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println(stack.peek());
	}
}

class LinkedStack {
	Node head = new Node();
	int size;
	
	LinkedStack() {}
	
	// push => head 바로 뒤가 top
	void push(String data) {
		Node newNode = new Node();
		newNode.data = data;
		
		newNode.link = head.link;
		head.link = newNode;
		
		size++;
	}
	
	// pop
	String pop() {
		if (isEmpty()) {
			System.out.println("스택 비어있음");
			return null;
		}
		
		String popOut = head.link.data;
		head.link = head.link.link; // 링크 변경
		
		size--;
		return popOut;
	}
	
	// peek
	String peek() {
		if (isEmpty()) {
			System.out.println("스택 비어있음");
			return null;
		}
		
		return head.link.data;
	}
	
	// isEmpty
	boolean isEmpty() {
		return size==0;
	}
	
	// size
	int size() {
		return size;
	}
}