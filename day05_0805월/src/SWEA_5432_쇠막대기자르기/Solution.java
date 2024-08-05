package SWEA_5432_쇠막대기자르기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 변수 설정 및 입력=============================================
			String oneLine = sc.next();
			int len = oneLine.length(); // 괄호문자열 길이
			int[] openStack = new int[len]; // 여는 괄호 저장 스택 
			int stick = 0; // 쪼갤 막대
			int dividedStick = 0; // 쪼개진 막대
			int top = -1; // 스택 top
			
			// 막대기 쪼개기================================================
			for (int i=0; i<len; i++) {
				String command = oneLine.substring(i, i+1); // 괄호 하나씩
				// 여는 괄호가 나오면
				if (command.equals("(")) {
					openStack[++top] = 1; // 여는 괄호 스택에 저장
					stick++; // 쪼갤 막대기 +1
				}
				// 닫는 괄호가 나오면
				else {
					// 직전 괄호가 여는 괄호인 경우 (레이저 빔)
					if (i>0 && oneLine.substring(i-1, i).equals("(")) {
						stick--; // 쪼갤 막대기가 추가되면 안되었으므로 다시 빼 줌
						dividedStick += stick; // 쪼개진 막대기에 저장
					}
					// 직전 괄호가 여는 괄호가 아닌 경우 (막대기 하나 제거)
					else {
						openStack[top--] = 0; // 여는 괄호 스택에서 하나 뺌
						dividedStick++; // 쪼개진 막대기 +1
						stick--; // 쪼갤 막대기 -1
					}
				}
			}
			// 출력=====================================================
			System.out.println("#" + test_case + " " + dividedStick);
		}
	}
}