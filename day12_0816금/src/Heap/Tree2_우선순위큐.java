package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

class Person implements Comparable<Person> {
	String name;
	int age;
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// o: 상대방
	@Override
	public int compareTo(Person o) {
		// -1, 0, 1 셋 중 하나를 리턴
		// 0: 같다, 1: 위치를 바꾼다, -1: 위치를 바꾸지 않는다
		
//		if (this.age == o.age)
//			return 0;
//		else if (this.age > o.age)
//			return 1;
//		return -1;
		return this.age - o.age;
	}
	
	public String toString() {
		return this.name;
	}
}

public class Tree2_우선순위큐 {
	public static void main(String[] args) {
		
		// 기본적으로는 최소힙
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.add(10);
		pq.add(20);
		pq.add(30);
		pq.add(-10);
		pq.add(40);
		
		System.out.println("최소 힙");
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		
		// 최대힙 구현
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		
		pq2.add(10);
		pq2.add(20);
		pq2.add(30);
		pq2.add(-10);
		pq2.add(40);
		
		System.out.println("최대 힙");
		while (!pq2.isEmpty()) {
			System.out.println(pq2.poll());
		}
		
		// class 변수
//		PriorityQueue<Person> personPQ = new PriorityQueue<>(new PersonComarator());
		PriorityQueue<Person> personPQ = 
				new PriorityQueue<>((p1, p2)->{return p2.age - p1.age;});
		
		personPQ.add(new Person("루나", 3));
		personPQ.add(new Person("데이지", 1));
		personPQ.add(new Person("맥스", 8));
		
		System.out.println("Person");
		while (!personPQ.isEmpty()) {
			Person p = personPQ.poll();
			System.out.println(p);
		}
	}
}
