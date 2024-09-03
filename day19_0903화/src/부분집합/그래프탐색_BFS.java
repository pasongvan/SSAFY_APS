package 부분집합;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 그래프탐색_BFS {

	static int V, E; // 정점의 개수, 간선의 개수
	static List<Integer>[] adj; // 인접리스트
	static boolean[] visited; // 방문체크
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		V = sc.nextInt();
		E = sc.nextInt();
		
		adj = new ArrayList[V+1];
		for (int i=0; i<=V; i++) {
			adj[i] = new ArrayList<>();
		}
		
		visited = new boolean[V+1];
		
		for (int i=0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			adj[A].add(B);
			adj[B].add(A);
		}
		
		bfs(1);
		
	} // main
	
	// v: 시작 정점
	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(v);
		visited[v] = true;
		
		while (!queue.isEmpty()) {
			int curr = queue.poll(); // 정점 하나 꺼내기
			System.out.println(curr);
			
			// 인접하면서 방문하지 않은 원소 방문
			for (int w: adj[curr]) {
				if (visited[w]) continue;
				
				queue.add(w);
				visited[w] = true;
			}
		}
	}
	
	
	
	static String input = "7 9\r\n"
			+ "1 2\r\n"
			+ "1 3\r\n"
			+ "1 6\r\n"
			+ "2 4\r\n"
			+ "2 7\r\n"
			+ "3 4\r\n"
			+ "4 7\r\n"
			+ "5 6\r\n"
			+ "5 7";
}
