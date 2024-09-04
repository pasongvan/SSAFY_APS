package 그래프DFSBFS;

import java.util.Arrays;
import java.util.Scanner;

public class 크루스칼 {
	
	static class Edge implements Comparable<Edge> {
		int A, B, W;

		public Edge(int a, int b, int w) {
			A = a;
			B = b;
			W = w;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.W - o.W;
		}
	}
	
	static int[] p; // 대표자 저장 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // 정점 개수
		int E = sc.nextInt(); // 간선 개수
		
		Edge[] edges = new Edge[E];
		
		for (int i=0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			edges[i] = new Edge(A, B, W);
		}
		
		// 크루스칼=================================================
		// 1. 가중치 순 정렬
		Arrays.sort(edges);
		
		// 2. V-1개의 간선 뽑기 (사이클 발생하지 않도록)
		p = new int[V];
		
		// 2-1. make-set을 통해 자신을 대표로 만드는 작업 수행
		for (int i=0; i<V; i++) {
			makeSet(i);
		}
		
		// 2-2. 낮은 가중치 순으로 트리 저장
		int ans = 0; // 최소비용
		int pick = 0; // 뽑은 간선의 개수
		
		for (int i=0; i<E; i++) {
			int x = edges[i].A;
			int y = edges[i].B;
			
			// 사이클 발생 여부 검사
			if (findSet(x) != findSet(y)) { // 사이클이 아니라면
				union(x, y);
				ans += edges[i].W;
			}
			
			if (pick == V-1) break;
			
			
		}
		for (Edge edge : edges) {
			System.out.println(edge.toString());
		}
		
	}

	static void makeSet(int x) {
		p[x] = x;
	}
	
	static int findSet(int x) {
//		if (x == p[x]) return x;
//		return findSet(p[x]);
		
		if (x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
		// x와 y가 대표자여야만 한다.
		p[findSet(y)] = findSet(x); // y그룹을 x그룹에 넣는다
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
