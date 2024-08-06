package Stack2;

public class 피보나치 {

	public static void main(String[] args) {
		
//		System.out.println(fibo(45));
//		System.out.println(fibo2(45));
		System.out.println(mfibo(45));

	}
	
	static int fibo(int N) {
		if (N<=1) 
			return 1;
		return fibo(N-1) + fibo(N-2);
	}
	
	static int fibo2(int N) {
		int[] arr = new int[N+1];
		arr[0] = 0;
		arr[1] = 1;
		for (int i=2; i<=N; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[N];
	}
	
	static int[] dp = new int[500];
	
	static int mfibo(int N) {
		if (N <= 1) 
			return N;
		if (dp[N] > 0) {
			return dp[N];
		}
		return dp[N] = mfibo(N-1) + mfibo(N-2);
	}

}
