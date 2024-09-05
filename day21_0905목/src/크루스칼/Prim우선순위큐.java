package 크루스칼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim우선순위큐 {
	
	static class Edge implements Comparable<Edge> {
		int A, B, W;

		public Edge(int a, int b, int w) {
			super();
			A = a;
			B = b;
			W = w;
		}
		
		public int compareTo(Edge o) {
			return Integer.compare(this.W, o.W);
		}
	}
	
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt(); // 정점 개수
		int E = sc.nextInt(); // 간선의 수
		
		// 인접리스트
		List<Edge>[] adjList = new ArrayList[V];
		
		for (int i=0; i<V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		
		for (int i=0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			adjList[A].add(new Edge(A, B, W));
			adjList[B].add(new Edge(A, B, W));
		}

		boolean[] visited = new boolean[V]; // 방문체크 배열
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		visited[0] = true; // 0번부터 시작
		
		int ans = 0;
		int pick = 1;
		
//		// 1번방식
//		for (int i=0; i<adjList[0].size(); i++) {
//			pq.add(adjList[0].get(i));
//		}
//		// 2번방식
//		for (Edge e : adjList[0])
//			pq.add(e);
		// 3번방식
		pq.addAll(adjList[0]);
		
		while (pick != V) {
			Edge e= pq.poll();
			if (visited[e.B]) continue;
			
			ans += e.W;
			visited[e.B] = true;
			pick++;
			
			pq.addAll(adjList[e.B]);
		}
		
		System.out.println(ans);
		
		
		
	}

	
	
	
	
	
	static String input = "7 11\r\n"
			+ "0 1 32\r\n"
			+ "0 2 31\r\n"
			+ "0 5 60\r\n"
			+ "0 6 51\r\n"
			+ "1 2 21\r\n"
			+ "2 4 46\r\n"
			+ "2 6 25\r\n"
			+ "3 4 34\r\n"
			+ "3 5 18\r\n"
			+ "4 5 40\r\n"
			+ "4 6 51";
}
