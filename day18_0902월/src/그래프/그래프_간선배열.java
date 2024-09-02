package 그래프;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_간선배열 {
	
	static class Edge {
		int A, B, W; // 시작, 끝, 가중치

		public Edge(int a, int b, int w) {
			A = a;
			B = b;
			W = w;
		}		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt(); // 정점의 개수 (0 또는 1로 시작)
		int E = sc.nextInt(); // 간선의 개수

		Edge[] edges = new Edge[E]; // 객체 배열
		for (int i=0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			edges[i] = new Edge(A, B, W);
		}
		
		// 방법 2 ========================================
		List<Edge> edges2 = new ArrayList<>();
		for (int i=0; i<E; i++) {
			edges2.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		// 방법 3 ========================================
		int[][] edges3 = new int[E][3]; // 0: 시작, 1: 도착, 2: 가중치
		
		for (int i=0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			edges3[i][0] = A; // 시작
			edges3[i][1] = B; // 도착
			edges3[i][2] = W; // 가중치
		}
	}

}
