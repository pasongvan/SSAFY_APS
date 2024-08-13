package LinkedList;

class Node {
	String data;
	Node link;
}

public class Practice {
	
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		
		list.addData(0, "클레이튼 커쇼");
		list.printAll();
		list.addData(0, "무키 베츠");
		list.addData(0, "제이슨 지암비");
		list.printAll();
		list.removeData(0);
		list.printAll();
	}

}


class SinglyLinkedList {
	Node head;
	int size;
	
	SinglyLinkedList() {
		head = new Node();
	}
	
	// 삽입
	void addData(int i, String data) {
		// 0이면 제일 앞, size와 같으면 제일 뒤
		if (i<0 || i>size) {
			System.out.println("범위 밖");
			return;
		}
		// 새 노드 생성
		Node newNode = new Node();
		newNode.data = data;
		
		// 삽입할 위치 앞 노드 찾기
		Node curr = head;
		for (int k=0; k<i; k++) {
			curr = curr.link;
		}
		
		// 새 노드부터 연결
		newNode.link = curr.link;
		
		// 이전 노드와 새노드 연결
		curr.link = newNode;
		
		// 사이즈 증가
		size++;
	}
	
	// 삭제
	void removeData(int i) {
		// 0이면 제일 앞, size-1이면 제일 뒤
		if (i<0 || i>size-1) {
			System.out.println("범위 밖");
			return;
		}
		// 삭제할 앞 노드 찾기
		Node prev = head;
		for (int k=0; k<i; k++) {
			prev = prev.link;
		}
		
		// 앞 노드 링크 한 칸 뛰어 넘기기
		prev.link = prev.link.link;
		
		// 사이즈 감소
		size--;
	}
	
	// 모든 데이터 조회
	void printAll() {
		Node curr = head.link;
		
		while (curr != null) {
			System.out.print(curr.data + " => ");
			curr = curr.link;
		}
		System.out.println();
	}
	
	
}


