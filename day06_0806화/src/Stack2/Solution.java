package Stack2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
	
	// 연산자 우선 순위 map
	static Map<Character, Integer> map = new HashMap<>();
	static {
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
		map.put('(', 0);
	}
	
	public static void main(String[] args) {
		
		//계산기
		String expression = "(6+5*(2-8)/2)";
//		String expression = "(3+5)*8";
		
		String postfix = infixToPostfix(expression);
		System.out.println(postfix);
		
		int result = evalPostfix(postfix);
		System.out.println(result);
		
		System.out.println(evaluate(expression));
		
	}
	// 중위표기식 => 계산 메소드
	static int evaluate(String expression) {
		String postfix = infixToPostfix(expression);
		return evalPostfix(postfix);
	}
	
	
	// 후위 표기법 변환 메소드
	static String infixToPostfix(String infix) {
		
		String postfix = "";
		Stack<Character> stack = new Stack<>();
		
		for (int i=0; i<infix.length(); i++) {
			char c = infix.charAt(i);
			
			// 피연산자가 나오면 바로 출력
			if ('0'<=c && c<='9') {
				postfix += c;
			}
			// 여는 괄호가 나오는 경우
			else if (c == '(') 
				stack.push('(');
			// 닫는 괄호가 나오는 경우
			else if (c == ')') {
				// 여는 광호가 나올 때까지 pop
				char popItem = stack.pop();
				while (popItem != '(') {
					postfix += popItem;
					popItem = stack.pop();
				}
			}
			// 연산자가 나오는 경우
			else {
				// 스택 top에 우선순위가 낮은 연산자 올 때까지 pop
				
				while (!stack.isEmpty() && 
						stack.peek()!='(' && 
						map.get(stack.peek()) >= map.get(c)) {
					char popItem = stack.pop();
					postfix += popItem;
				}
				stack.push(c);
			}
		}
		// 스택 비워주기
		while (!stack.isEmpty() && stack.peek()!='(') {
			postfix += stack.pop();
		}
		
		return postfix;
	}
	
	// 후위표기식 => 계산 메소드
	static int evalPostfix(String postfix) {
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i=0; i<postfix.length(); i++) {
			char c = postfix.charAt(i);
			
			if ('0'<=c && c<='9') {
				stack.push(c - '0');
			}
			else {
				int num2 = stack.pop();
				int num1 = stack.pop();
				int result;
				
				if (c == '+') {
					result = num1 + num2;
				} else if (c == '-') {
					result = num1 - num2;
				} else if (c == '*') {
					result = num1 * num2;
				} else {
					result = num1 / num2;
				}
				stack.push(result);
			}
		}
		return stack.pop();
	}

}