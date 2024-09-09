package 위상정렬;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 위상정렬큐 {
	
	public static String[] cook = {"", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육복음만들기", "식사", "뒷정리", "채소손질", "밥하기"};

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt(); // 정점의 개수 (1번부터 시작)
		int E = sc.nextInt(); // 간선의 개수
		
		// 인접 행렬
		int[][] adjArr = new int[V+1][V+1];
		int[] degree = new int[V+1];
		
		for (int i=1; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adjArr[A][B] = 1; // A=>B 간선 존재
			degree[B]++; // B의 진입차수 증가
		}
		
		// 위상정렬 큐
		// 1. 진입차수가 0인 정점을 큐에 모두 넣기
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i=1; i<=V; i++) {
			if(degree[i] == 0) {
				queue.offer(i);
			}
		}
		
		// String builder
		StringBuilder sb = new StringBuilder();
		
		// 2. 큐가 빌 때까지 반복
		// 간선제거, 진입차수 -1, 새로이 진입차수 0된 정점 큐에 넣기
		while (!queue.isEmpty()) {
			int curr = queue.poll();
//			System.out.print(cook[curr] + " "); // 위상정렬 수행 결과
			sb.append(cook[curr]).append(" ");
			
			for (int i=1; i<=V; i++) {
				if (adjArr[curr][i] == 1) { // 유향 그래프 => 인덱스 순서 중요
					degree[i]--; // 진입차수 -1
					adjArr[curr][i] = 0; // 간선 제거
					
					// 진입 차수가 0이 되었다면 큐에 넣기
					if (degree[i] == 0)
						queue.add(i);
				}
			}
		}
		
		// 출력
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
