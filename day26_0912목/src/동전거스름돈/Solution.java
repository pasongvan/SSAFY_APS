package 동전거스름돈;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 얼마를 거슬러줘야하는지 입력
		int N = sc.nextInt();
		// dp 배열
		int[] dp = new int[N+1];
		
		// 1원부터 N원까지 최적 해
		for (int i=1; i<=N; i++) {
			// 최소값 초기화
			dp[i] = Integer.MAX_VALUE;
			
			dp[i] = Math.min(dp[i-1]+1, dp[i]); // N-1원과 1원을 사용
			if (i>=4) dp[i] = Math.min(dp[i-4]+1, dp[i]); // N-4원과 4원을 사용
			if (i>=6) dp[i] = Math.min(dp[i-6]+1, dp[i]); // N-6원과 6원을 사용
		}
		
		System.out.println(dp[N]);
	}

}
// 1원, 4원, 6원
// N원을 거슬러주기 위해서는?