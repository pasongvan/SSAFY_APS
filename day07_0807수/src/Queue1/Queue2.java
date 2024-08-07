package Queue1;

import java.util.LinkedList;
import java.util.Queue;

public class Queue2 {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		
		// 삽입
		queue.add(1); // 원소 추가 불가 시 예외 발생
		queue.offer(2); // 추가 됐으면 true, 안됐으면 false
		
		System.out.println(queue);
		
		// 삭제
		queue.remove(); // 큐가 비어있으면 예외 발생
		queue.poll(); // 큐가 비어있으면 return null
		System.out.println(queue);
		queue.remove();
		
		// 조회
		queue.element(); // 예외발생
		queue.peek(); // return null
	}
}
