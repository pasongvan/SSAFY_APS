package 부분집합;

import java.util.Arrays;

// 반복문으로 부분집합 나타내기
public class Practice {

	static String[] grad = {"단무지", "햄", "오이", "시금치"};
	static int N = 4;
	static int[] sel = new int[N];
	
	public static void main(String[] args) {
		// 재료가 4개 => 반복문 4개
		for (int i=0; i<=1; i++) { // 단무지 포함 유무
			sel[0] = i;
			for (int j=0; j<=1; j++) { // 햄
				sel[1] = j;
				for (int k=0; k<=1; k++) { // 오이
					sel[2] = k;
					for (int l=0; l<=1; l++) { // 시금치
						sel[3] = l;
						System.out.println(Arrays.toString(sel));
					}
				}
			}
		}

	}

}
