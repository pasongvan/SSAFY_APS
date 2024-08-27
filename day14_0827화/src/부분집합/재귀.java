package 부분집합;

import java.util.Arrays;

public class 재귀 {

	static String[] grad = {"단무지", "햄", "오이", "시금치"};
	static int N = 4;
	static boolean[] sel = new boolean[N];
	
	public static void main(String[] args) {

		powerset(0);

	}
	static void powerset(int idx) {
		// 기저조건
		if (idx == N) {
			String tmp = "김밥: ";
			for (int i=0; i<N; i++) {
				if (sel[i])
					tmp += grad[i] + " ";
			}
			System.out.println(tmp);
			return;
		}
		
		// 재귀부분
		sel[idx] = true;
		powerset(idx + 1);
		
		sel[idx] = false;
		powerset(idx + 1);
	}

}
