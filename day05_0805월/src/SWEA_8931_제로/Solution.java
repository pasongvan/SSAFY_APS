package SWEA_8931_제로;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case=1; test_case<=T; test_case++) {
			//변수 설정 및 입력=================================================
			int K = sc.nextInt();
			int[] book = new int[K];
			int top = -1;
			
			// 장부 작성======================================================
			for (int i=0; i<K; i++) {
				int input = sc.nextInt();
				if (input != 0) {
					book[++top] = input;
				}
				else {
					book[top--] = 0;
				}
			}
			// 장부 합 계산====================================================
			int sum = 0;
			for (int i=0; i<=top; i++) {
				sum += book[i];
			}
			
			// 출력==========================================================
			System.out.println("#" + test_case + " " + sum);
		}
	}
}