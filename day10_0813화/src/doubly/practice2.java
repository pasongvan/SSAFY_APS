package doubly;

class Node {
	String data;
	Node prev;
	Node next;
}

public class practice2 {
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList(); 
		
		list.addData(0, "1");
		list.addData(0, "2");
		list.addData(0, "3");
		list.addData(0, "4");
		
		list.printReverse();
	}

}

class DoublyLinkedList {
	Node head;
	Node tail;
	int size;
	
	public DoublyLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}
	
	// 삽입
	void addData(int i, String data) {
		if (i<0 || i>size) {
			System.out.println("범위 밖");
			return;
		}
		// 0이면 제일 앞, size면 제일 뒤
		
		// 삽입할 새 노드 생성
		Node newNode = new Node();
		newNode.data = data;
		
		// 삽입 위치 앞 노드 찾기
		Node curr = head;
		for (int k=0; k<i; k++) {
			curr = curr.next;
		}
		
		// 새 노드 링크 해주기
		newNode.next = curr.next;
		newNode.prev = curr;
		
		// 기존 노드 링크 재구성
		newNode.next.prev = newNode;
		curr.next = newNode;
		
		// 사이즈 변경
		size++;
	}
	
	// 삭제
	void removeData(int i) {
		// 0: 제일 앞, size-1: 제일 뒤
		if (i<0 || i>=size) {
			System.out.println("범위 밖");
			return;
		}
		// 삭제할 위치 찾기
		Node curr = head.next;
		for (int k=0; k<i; k++) {
			curr = curr.next;
		}
		
		// 앞 뒤 링크 바꾸기
		curr.prev.next = curr.next;
		curr.next.prev = curr.prev;
		
		// 사이즈 변경
		size--;
	}
	
	// 전체 데이터 역으로 출력
	void printReverse() {
		Node curr = tail.prev;
		String str = "";
		while (curr!=head) {
			str = " <= " + curr.data + str;
			curr = curr.prev;
		}
		System.out.println(str);
	}
}
