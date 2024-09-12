package 배낭;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 물건의 개수와 배낭의 무게
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		// 각 물건 무게와 가격 담기
		int[] weights = new int[N+1];
		int[] prices = new int[N+1];
		for (int i=1; i<=N; i++) {
			weights[i] = sc.nextInt();
			prices[i] = sc.nextInt();
		}
		
		// dp 배열
		int[][] dp = new int[N+1][W+1];
		
		// 각 물건 하나씩 고려
		for (int i=1; i<=N; i++) {
			// 무게별로 고려
			for (int w=1; w<=W; w++) {
				// 가방 용량이 물건보다 작을 땐 패스
				if (weights[i] > w) continue;
				
				// 해당 물건을 넣었을 때와 넣지 않을 때 비교해서 큰거를 저장
				dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i]]+prices[i]);
			}
		}
		
		// 최대가치 출력
		System.out.println(dp[N][W]);
		
	}
}

// 물건의 개수 N
// 배낭의 무게 W
// 각 물건 무게 w, 가격 p

//4
//10
//5 10
//4 40
//6 30
//3 50