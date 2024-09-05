package 크루스칼;

import java.util.Arrays;
import java.util.Scanner;

public class Prim반복문 {
	
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt(); // 정점 개수
		int E = sc.nextInt(); // 간선의 수
		
		// 인접행렬 방식
		int[][] adjArr = new int[V][V];
		
		for (int i=0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			adjArr[A][B] = adjArr[B][A] = W; // 무향
		}

		boolean[] visited = new boolean[V]; // 방문체크 배열
		int[] p = new int[V]; // 부모 정점이 누구인지
		int[] dist = new int[V]; // 정점 간 거리 저장 배열
		
		// 1. 초기화
		Arrays.fill(dist, INF);
		Arrays.fill(p, -1);
		
		// 2. 시작 정점 결정
		dist[0] = 0;
		
		// 3. 최소 가중치를 골라 방문체크 반복
		for (int i=0; i<V; i++) {
			
			int min = INF;
			int idx = -1; // 뽑을 정점 인덱스
			
			// 방문x & 가장 작은 가중치 가져오기
			for (int j=0; j<V; j++) {
				if (visited[j]) continue;
				
				if (min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			// 방문처리
			visited[idx] = true;
			
			// 방문x => 갱신
			for (int j=0; j<V; j++) {
				if(visited[j]) continue;
				
				if (adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
					dist[j] = adjArr[idx][j];
					p[j] = idx;
				}
			}
		}
		// 결과 출력
		int ans = 0;
		for (int i=0; i<V; i++) {
			ans += dist[i];
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
