package SWEA_2001_파리퇴치;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case=1; test_case<=T; test_case++) {
			// 변수 선언=========================================
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] flies = new int[N+M][N+M]; // 오른쪽 아래 테두리는 빈 공간 => 인덱스 처리 필요x
			int max = 0; 
			
			// 파리 수 입력=======================================
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					flies[i][j] = sc.nextInt();
				}
			}
			
			// 모든 칸 검사=======================================
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					// 파리채로 몇마리 잡는지
					int sum = catchFlies(flies, M, i, j);
					// 최댓값 갱신
					if (max < sum)
						max = sum;
				}
			}
			System.out.println("#" + test_case + " " + max);
		}
	}
	// 파리채로 몇마리 잡을 수 있는지 계산하는 메소드
	static int catchFlies(int[][] flies, int M, int i, int j) {
		int sum = 0;
		for (int di=0; di<M; di++) {
			for (int dj=0; dj<M; dj++) {
				sum += flies[i+di][j+dj];
			}
		}
		return sum;
	}
}