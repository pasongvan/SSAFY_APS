package 분할정복;

public class 거듭제곱02_분할정복 {
	public static void main(String[] args) {
		int C = 2;
		int N = 10;

		System.out.println(pow(C, N));
	}

	public static int pow(int C, int N) {
		// 기저조건
		if (N == 1 || N == 0) return C;
		
		// 재귀 부분: 짝수인 경우 / 홀수인 경우
		if(N % 2 == 0) {
			int tmp = pow(C, N/2);
			return tmp * tmp;
		}
		else {
			int tmp = pow(C, (N-1)/2);
			return tmp * tmp * C;
		}
	}
}
