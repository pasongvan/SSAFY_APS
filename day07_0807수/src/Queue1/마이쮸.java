package Queue1;

import java.util.LinkedList;
import java.util.Queue;

class Person {
	int no;
	String name;
	int myChu;
	
	Person() {}

	public Person(int no, String name, int cnt) {
		this.no = no;
		this.name = name;
		this.myChu = cnt;
	}

	@Override
	public String toString() {
		return "Person [no=" + no + ", name=" + name + ", myChu=" + myChu + "]";
	}
	
}

public class 마이쮸 {

	public static void main(String[] args) {
		Queue<Person> queue = new LinkedList<>();
		
		int N = 20;
		int pNum = 0;
		
		queue.add(new Person(++pNum, "Kim", 1));
		
		while (N>0) {
			// 맨 앞 사람이 마이쮸를 가져간다
			Person p = queue.poll();
			N -= p.myChu++;
			System.out.println(p.name + "님이 " + (p.myChu-1) + "개 가져감");
			System.out.println("남은 마이쮸: " + N);
			if (N <=0) {
				System.out.println(p.name + "님이 마지막 마이쮸");
				break;
			}
			
			// 줄 맨 뒤에 다시 섬
			queue.add(p);
			
			// 새로운 사람 줄 섬
			String newMember = "Lee" + pNum;
			Person p2 = new Person(++pNum, newMember, 1);
			queue.add(p2);
		}

	}

}
