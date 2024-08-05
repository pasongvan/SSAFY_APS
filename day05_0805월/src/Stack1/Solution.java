package Stack1;

import java.util.Stack;

public class Solution {
	
	static String[] stack = new String[100];
	static int top = -1;
	
	public static void main(String[] args) {
//		Stack<String> stack = new Stack<>();
//		
//		stack.push("Omar Bizquel");
//		stack.push("Barry Bonds");
//		stack.push("Todd Helton");
//		
//		for (int i=0; i<3; i++) {
//			System.out.println(stack.pop());
//		}
		push("Omar Bizquel");
		push("Barry Bonds");
		push("Todd Helton");
		
		while (!(isEmpty())) {
			System.out.println(pop());
		}
		
	}
	static boolean isEmpty() {
		return top == -1;
	}
	
	static boolean isFull() {
		return top == stack.length - 1;
	}
	
	static void push(String item) {
		if (isFull()) {
			System.out.println("스택이 가득 찼습니다.");
			return;
		}
		stack[++top]  = item;
	}
	
	static String pop() {
		if (isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return null;
		}
		return stack[top--];
	}
	
	static String peek() {
		if (isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return null;
		}
		return stack[top];
	}
}