package 그래프DFSBFS;

import java.util.Arrays;
import java.util.Scanner;

class 크루스칼실습 {
	
	static int[] rep;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// 간선 배열
		int[][] edges = new int[M][3];
		for (int i=0; i<M; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}
		
		// 대표자 배열
		rep = new int[N];
		for (int i=0; i<N; i++) {
			rep[i] = i;
		}
		
		// 크루스칼
		// 1. 가중치 오름차순으로 간선 정렬
		Arrays.sort(edges, (a, b) -> a[2] - b[2]);

		// 2. 가중치 순으로 간선 뽑기
		int min = 0; // 최소 비용
		int pick = 0; // 택한 간선 개수
		int idx = 0; // 택해야 할 간선 인덱스
		
		while (pick < N-1) {
			
			// 사이클이라면 그 다음 가중치 간선 선택
			if (findSet(rep[edges[idx][0]]) == findSet(rep[edges[idx][1]])) {
				idx++;
				continue;
			}
			// 가장 낮은 가중치 간선 선택
			union(edges[idx][0], edges[idx][1]);
			
			// 가중치 더하기
			min += edges[idx][2];
			
			// 인덱스, 택한 간선 개수 변경
			idx++;
			pick++;
		}
		
		// 최소비용 출력
		System.out.println(min);
		
	}
	
	static int findSet(int x) {
		if (x != rep[x])
			rep[x] = findSet(rep[x]);
		return rep[x];
	}
	
	static void union(int x, int y) {
		rep[findSet(x)] = findSet(y);
		return;
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