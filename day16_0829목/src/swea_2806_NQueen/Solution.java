package swea_2806_NQueen;

import java.util.Scanner;

public class Solution {
	
	// static 변수
	static int[] queen;
	static int N;
	static int cases;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			
			// N 입력
			N = sc.nextInt();
			
			// 변수 초기화
			queen = new int[N];
			cases = 0;
			
			// method 호출
			method(1);
			
			// 경우의 수 출력
			System.out.println("#" + tc + " " + cases);
		}

	}
	
	// 경우의 수 계산 메소드
	static void method(int row) {
		
		// 기저조건: 모든 퀸을 위치시켰으면 경우의 수 +1
		if (row > N) {
			cases++;
			return;
		}
		
		// 재귀 부분
		for (int col=0; col<N; col++) {
		
			// 열 방향 겹치면 continue
			if (queen[col] != 0) continue;
			
			// 대각선 방향으로 겹치면 continue
			boolean OK = true;
			for (int i=0; i<N; i++) {
				// 본인은 넘김
				if (i == col) continue;
				// 대각선 겹치는지 확인
				if (queen[i]>0 && (queen[i]-row == i-col || queen[i]-row == col-i)) {
					OK = false;
					break;
				}
			}
			if (!OK) continue;

			// 겹치지 않으면
			queen[col] = row;
			method(row+1);
			queen[col] = 0;
		}
	}
}










