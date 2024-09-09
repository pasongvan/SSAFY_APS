package 위상정렬;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Practice큐 {
	
	static String[] cook = {"", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육복음만들기", "식사", "뒷정리", "채소손질", "밥하기"};

	public static void main(String[] args) {
		Scanner sc= new Scanner(input);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		int[] inDegree = new int[V+1];
		
		boolean[][] edges = new boolean[V+1][V+1];
		for (int i=0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			edges[from][to] = true;
			inDegree[to]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		// 진입 차수 0인 모든 노드 큐에 삽입
		for (int i=1; i<=V; i++) {
			if (inDegree[i] == 0)
				queue.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		
		// 큐가 빌 때까지 반복
		while (!queue.isEmpty()) {
			// 큐에서 원소 꺼내기
			int curr = queue.poll();
			sb.append(cook[curr]).append("=>");
			
			// 해당 노드에서 나가는 간선 제거, 연결된 노드 진입 차수 -1
			for (int i=1; i<=V; i++) {
				if (edges[curr][i]) {
					edges[curr][i] = false;
					inDegree[i]--;
					if (inDegree[i] == 0)
						queue.add(i);
				}
			}
		}
		
		System.out.println(sb.toString());

	}

	static String input = "9 9\r\n"
			+ "1 4\r\n"
			+ "1 8\r\n"
			+ "2 3\r\n"
			+ "4 3\r\n"
			+ "8 5\r\n"
			+ "3 5\r\n"
			+ "5 6\r\n"
			+ "9 6\r\n"
			+ "6 7";
}
