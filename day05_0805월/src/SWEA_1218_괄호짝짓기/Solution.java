package SWEA_1218_괄호짝짓기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case=1; test_case<=10; test_case++) {
			
			// 변수 설정 및 입력========================================
			int len = sc.nextInt(); // 테스트 케이스 길이
			String oneLine = sc.next(); // 한 줄 입력
			int result = 1; // 유효성 여부 변수
			int[] stack = new int[len]; // 괄호 스택 (소괄호 1, 중괄호 2, 대괄호 3, 꺽쇠괄호 4)
			int top = -1; // 스택 top 변수
			
			// 괄호 열고 닫기==========================================
			for (int i=0; i<len; i++) {
				String letter = oneLine.substring(i, i+1); // 한글자씩
				// 여는 괄호일 때
				if (letter.equals("(") || letter.equals("{") || letter.equals("[") || letter.equals("<")) {
					stack[++top] = letter; // push
				}
				// 닫는 괄호일 때
				else {
					if (top==-1)
						break; // 괄호 열지 않았는데 닫으려고 하면 중단
					else if ()
				}
			}
			
		}
	}
}