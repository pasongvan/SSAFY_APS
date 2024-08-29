package 백트래킹;

import java.util.Scanner;

public class hamburger {
	
	static int N, L;
	static int[] cals;
	static int[] scores;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			N = sc.nextInt();
			L = sc.nextInt();
			scores = new int[N];
			cals = new int[N];
			for (int i=0; i<N; i++) {
				scores[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}//input 끝
			ans = 0;
			
			// 1. 비트마스킹으로 풀 수 있다.
			
			
			
			
		}// test_case

	}//main
	
	static void makeBurger(int idx, int sumScore, int sumCal) {
		// 기저조건
		if(sumCal > L) return;
		
		if (idx == N) { // 모든 재료를 전부 다 고려한 경우
			if (ans < sumScore)
				ans = sumScore;
			return;
		}
		
		// 재귀부분
		// 해당 재료 사용o
		makeBurger(idx+1, sumScore+scores[idx], sumCal+cals[idx]);
		// 해당 재료 사용x
		makeBurger(idx+1, sumScore, sumCal);
	}

}//class






