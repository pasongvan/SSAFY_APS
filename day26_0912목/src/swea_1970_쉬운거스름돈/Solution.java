package swea_1970_쉬운거스름돈;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			
			// N 입력
			int N = sc.nextInt();
			
			// 화폐 종류 배열
			int[] type = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			
			// 화폐 개수 배열
			int[] cnt = new int[8];
			
			// 모든 화폐 종류에 대해 반복
			for (int i=0; i<8; i++) {
				// N이 type[i]보다 크다면 => 해당 화폐 사용 가능
				if (N >= type[i]) {
					// 돈 개수 카운트
					cnt[i] = N/type[i];
					// 돈 빼기
					N %= type[i];
				}
			}
			
			// 결과 출력
			System.out.println("#" + tc);
			for (int i=0; i<8; i++) {
				System.out.print(cnt[i] + " ");
			}
			System.out.println();
		}

	}

}
