package swea_1217_거듭제곱;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case=1; test_case<=10; test_case++) {
			
			sc.nextInt();
			
			// 입력
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// 출력
			System.out.println("#" + test_case + " " + pow(N, M));
		}

	}
	// 거듭제곱 메소드
	static long pow(int N, int M) {
		// 기저조건
		if (M == 1) return N;
		else if (M == 0) return 1;
		
		// M이 짝수일 때
		if (M%2 == 0) {
			long tmp = pow(N, M/2);
			return tmp * tmp;
		}
		// M이 홀수일 때
		else {
			long tmp = pow(N, M/2);
			return tmp * tmp * N;
		}
	}

}
