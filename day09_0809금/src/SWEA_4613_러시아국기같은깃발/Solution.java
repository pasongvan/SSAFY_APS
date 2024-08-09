package SWEA_4613_러시아국기같은깃발;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 입력
			int N = sc.nextInt();
			int M = sc.nextInt();
			char[][] colors = new char[N][M];
			for (int i=0; i<N; i++) {
				String oneLine = sc.next();
				for (int j=0; j<M; j++) {
					colors[i][j] = oneLine.charAt(j);
				}
			}
			
			// 최소 카운트 변수
			int min = 2500;
			
			// 색깔이 바뀌는 두 줄의 조합 => 이중 반복문
			for (int w2b=1; w2b<=N-2; w2b++) { // w2b: 흰색에서 파란줄로 바뀌는 행 인덱스
				for (int b2r=w2b+1; b2r<=N-1; b2r++) { // b2r: 파란색에서 빨간줄로 바뀌는 행 인덱스
					
					int count = 0; // 바꿔야하는 칸의 개수 카운트 변수
					
					// 모든 칸 순회
					for (int row=0; row<N; row++) {
						for (int col=0; col<M; col++) {
							// 흰색 행 => 흰색이 아닌 칸 카운트
							if (row < w2b && colors[row][col] != 'W')
								count++;
							// 파란색 행 => 파란색 아닌 칸 카운트
							else if (row >= w2b && row < b2r && colors[row][col] != 'B')
								count++;
							// 빨간색 행 => 빨간색 아닌 칸 카운트
							else if (row >= b2r && colors[row][col] != 'R')
								count++;
						}
					}
					
					// 최소값 갱신
					if (min > count) 
						min = count;
				}
			}
			
			// 출력
			System.out.println("#" + test_case + " " + min);
		}
	}
}