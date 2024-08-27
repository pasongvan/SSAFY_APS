package 부분집합;

import java.util.Arrays;

public class 비트마스킹 {

	static String[] grad = {"단무지", "햄", "오이", "시금치"};
	static int N = 4;
	static int[] sel = new int[N];
	
	public static void main(String[] args) {

		// 2**N(김밥 가짓수) 만큼 반복
		for (int i=0; i<(1<<N); i++) {
			
			String tmp = "";
			
			// 재료 확인 반복문
			for (int j=0; j<N; j++) {
				// & 연산
				if ((i & (1<<j)) > 0) {
					// 해당 재료 있음
					tmp += grad[j] + " ";
				}
			}
			System.out.println(tmp);
		}

	}

}
