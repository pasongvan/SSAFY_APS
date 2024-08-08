package SWEA_2805_농작물수확하기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 농장 입력
			int N = sc.nextInt();
			int[][] farm = new int[N][N];
			for (int i=0; i<N; i++) {
				String oneLine = sc.next();
				for (int j=0; j<N; j++) {
					farm[i][j] = Integer.parseInt(oneLine.substring(j, j+1));
				}
			}
			
			// 농작물 수확량
			int crop = 0;
			
			// 위 절반 더하기
			for (int i=0; i<=N/2; i++) {
				for (int j=N/2-i; j<=N/2+i; j++) {
					crop += farm[i][j];
				}
			}
			
			// 아래 절반 더하기
			for (int i=N/2+1; i<N; i++) {
				for (int j=N/2 - (N-1-i); j<=N/2 + (N-1-i); j++) {
					crop += farm[i][j];
				}
			}
			
			// 출력
			System.out.println("#" + test_case + " " + crop);
		}
	}
}