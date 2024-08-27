package swea_5215_햄버거다이어트;

import java.util.Scanner;

public class Solution {
	
	// 전역 변수
	static int[][] grad; // 0번 인덱스: 맛 점수, 1번 인덱스: 칼로리
	static int max; // 맛 최대값
	static int N;
	static int L;	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 입력
			N = sc.nextInt();
			L = sc.nextInt();
			grad = new int[N][2];
			for (int i=0; i<N; i++) {
				int taste = sc.nextInt();
				int calories = sc.nextInt();
				int[] arr = {taste, calories};
				grad[i] = arr;
			}
			
			// 전역 변수 초기화
			max = 0;
			
			// 메소드 호출
			method(0, -1, 0, 0);
			
			// 결과 출력
			System.out.println("#" + test_case + " " + max);
		}

	}
	static void method(int depth, int last, int calories, int sum_taste) {
		// 기저조건 1: 칼로리 초과
		if (calories > L) {
			return;
		}
		
		// 맛 최댓값 갱신
		if (max < sum_taste) {
			max = sum_taste;
		}
		
		// 기저조건 2: last가 맨 마지막
		if (last == N-1) {
			return;
		}
		
		// 재귀 부분
		for (int i=last+1; i<N; i++) {
			method(depth+1, i, calories+grad[i][1], sum_taste+grad[i][0]);
		}
	}

}
