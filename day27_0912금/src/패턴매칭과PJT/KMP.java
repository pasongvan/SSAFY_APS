package 패턴매칭과PJT;

public class KMP {

	public static void main(String[] args) {
		String text = "ABABABACABAABABACACA";
		String pattern = "ABABACA";

		kmp(text, pattern);
		
	}
	static void kmp(String T, String P) {
		int[] pi = getPi(P); // 점프테이블(실패함수테이블) 준비시킨다
		
		int j = 0; // 패턴의 인덱스
		// i: 본문의 인덱스
		for (int i=0; i<T.length(); i++) {
			// 달랐을 때
			while (j>0 && T.charAt(i) != P.charAt(j)) {
				j = pi[j-1]; // 점프
			}
			
			// 같았을 때
			if (T.charAt(i) == P.charAt(j)) {
				if (j == P.length()-1) { // j가 패턴 끝 도달
					System.out.println((i-P.length()+1)+"위치부터 시작하면 찾을 수 있다.");
					j = pi[j];
				}
				else
					j++;
			}
		}
	}
	
	
	static int[] getPi(String P) {
		int[] pi = new int[P.length()];
		
		int j = 0; // 여기까지는 같다
		for (int i=1; i<P.length(); i++) {
			// i와 j가 가리키는 값이 다르면
			while(j>0 && P.charAt(i)!=P.charAt(j))
				j = pi[j-1];
			
			// i와 j가 가리키는 값이 같으면
			if (P.charAt(i) == P.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}

}
