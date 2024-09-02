package 그래프;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_인접리스트 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt(); // 정점의 개수 (0 또는 1로 시작)
		int E = sc.nextInt(); // 간선의 개수

		List<Integer>[] adjList = new ArrayList[V];

		// 공간 할당
		for (int i=0; i<V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i=0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			// 가중치 저장하고 싶다면 1. 클래스 정의 or 2. int[] 사용
			adjList[A].add(B);
			adjList[B].add(A);
		}
	}

}
