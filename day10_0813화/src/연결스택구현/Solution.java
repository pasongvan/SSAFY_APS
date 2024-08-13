package 연결스택구현;

class Node {
	String data;
	Node link;
}

public class Solution {
	public static void main(String[] args) {
		
	}
}

class LinkedStack {
	Node head = new Node();
	int size;
	
	// 삽입 => head 바로 뒤가 top
	void add(String data) {
		Node newNode = new Node();
		newNode.data = data;
		
		newNode.link = head.link;
		head.link = newNode;
	}
	
	
}