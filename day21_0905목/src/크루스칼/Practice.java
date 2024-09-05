package 크루스칼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
	int A, B, W;

	public Edge(int a, int b, int w) {
		A = a;
		B = b;
		W = w;
	}

	@Override
	public int compareTo(Edge o) {
		return this.W - o.W;
	}
	
	
}

class Practice {
	
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		// 간선 정보 저장 리스트 배열
		List<Edge>[] edgeList = new ArrayList[V];
		
		// 간선 정보 저장
		for (int i=0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			Edge edge = new Edge(A, B, W);
			edgeList[A].add(edge); 
		}
		
		// 방문, 정점 별 거리 배열 선언
		boolean[] visit = new boolean[V];
		int[] dist = new int[V];
		Arrays.fill(dist, INF);
		
		// 우선순위 큐 선언
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		// 0번 정점부터 시작
		visit[0] = true;
		dist[0] = 0;
		int pick = 1;
		pq.addAll(edgeList[0]);
		
		// 모든 정점 선택될 때까지 반복
		while (pick < V) {
			// 큐에 들어있는 정점 폴
			Edge edge = pq.poll();
		}
		
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