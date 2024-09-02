package 그래프;

import java.util.Scanner;

public class 그래프_인접행렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt(); // 정점의 개수 (0 또는 1로 시작)
		int E = sc.nextInt(); // 간선의 개수

		int[][] adjArr = new int[V][V]; // 시작 정점 0
		
		for (int i=0; i<E; i++) {
			// 두개의 정점과 가중치
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			adjArr[A][B] = W;
			adjArr[B][A] = W; // 무향이라면 반대도 같이 작성
			
		}
	}

}
