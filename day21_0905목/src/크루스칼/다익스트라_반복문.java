package 크루스칼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 다익스트라_반복문 {
	
	static class Node {
		int V, W;

		public Node(int v, int w) {
			V = v;
			W = w;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static List<Node>[] adjList;
	static int[] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		// 입력==============================================
		V = sc.nextInt();
		E = sc.nextInt();
		
		adjList = new ArrayList[V];
		for (int i=0; i<V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		dist = new int[V];
		Arrays.fill(dist, INF);
		
		for (int i=0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			adjList[A].add(new Node(B, W));
		}
		//=================================================
		
		dijkstra(0);
		
		System.out.println(Arrays.toString(dist));
	}
	
	static void dijkstra(int st) {
		boolean[] visited = new boolean[V];
		
		dist[st] = 0; // 시작 노드까지의 거리는 0
		
		for (int i=0; i<V; i++) {
			int min = INF;
			int idx = -1;
			
			for (int j=0; j<V; j++) {
				if (!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			
			// 방문할 수 있는 곳이 없다!
			if (idx == -1) break;
			
			visited[idx] = true; // 해당 지점 뽑았음 표시
			
			for (Node node : adjList[idx]) {
				if (!visited[node.V] && dist[node.V] > dist[idx]+node.W) {
					dist[node.V] = dist[idx] + node.W;
				}
			}
		}
	}
	
	
	
	
	
	
	
	static String input = "6 11\r\n"
			+ "0 1 4\r\n"
			+ "0 2 2\r\n"
			+ "0 5 25\r\n"
			+ "1 3 8\r\n"
			+ "1 4 7\r\n"
			+ "2 1 1\r\n"
			+ "2 4 4\r\n"
			+ "3 0 3\r\n"
			+ "3 5 6\r\n"
			+ "4 3 5\r\n"
			+ "4 5 12";

}
