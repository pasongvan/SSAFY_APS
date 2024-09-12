package CT3;

import java.util.Scanner;

public class coin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int money = sc.nextInt();
		int[] dp = new int[money+1];
		
		// 1, 4, 6원 고민
		for (int i=1; i<=money; i++) {
			int minCnt = Integer.MAX_VALUE;
			
			minCnt = Math.min(minCnt, dp[i-1]+1);
			if(i>=4) minCnt = Math.min(dp[i-4]+1, minCnt);
			if(i>=6) minCnt = Math.min(dp[i-6]+1, minCnt);
			
			dp[i] = minCnt;
		}
		
		System.out.println(dp[money]);
	}
}
