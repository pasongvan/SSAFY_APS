package STACK_구현;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	static List<Integer> stack = new ArrayList<>();
	
	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
		
		System.out.println(pop());
		
		System.out.println(size());
		
		System.out.println(peek());
		
		System.out.println(isEmpty());
		pop();
		pop();
		System.out.println(isEmpty());
	}
	
	static void push(int element) {
		stack.add(element);
	}
	
	static int pop() {
		int element = stack.get(size()-1);
		stack.remove(size()-1);
		return element;
	}
	
	static int size() {
		return stack.size();
	}
	
	static int peek() {
		int element = stack.get(size()-1);
		return element;
	}
	
	static boolean isEmpty() {
		return size()==0;
	}
	
}