package SWEA_1954_달팽이숫자;

import java.util.Scanner;

// 반시계 달팽이

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
		int T = 1;
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 변수 및 입력============================================
			int N = sc.nextInt();
			// 달팽이 배열
			int[][] snail = new int[N][N];
			// 델타 배열
			int[] dr = {1, 0, -1, 0};
			int[] dc = {0, 1, 0, -1};
			int idx = 0;
			// 인덱스
			int row = 0;
			int col = 0;
			
			// 달팽이 숫자 저장==========================================
			for (int num=1; num<=N*N; num++) {
				snail[row][col] = num;
				row += dr[idx];
				col += dc[idx];
				if (row>=N || row<0 || col>=N || col<0 || snail[row][col]>0) {
					row -= dr[idx];
					col -= dc[idx];
					idx = (++idx)%4;
					row += dr[idx];
					col += dc[idx];
				}
			}
			// 출력====================================================
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}