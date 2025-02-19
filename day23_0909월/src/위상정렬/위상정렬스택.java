package 위상정렬;

import java.util.Scanner;
import java.util.Stack;

public class 위상정렬스택 {
	
	static String[] cook = {"", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육복음만들기", "식사", "뒷정리", "채소손질", "밥하기"};
	static int V, E;
	static int[][] adjArr;
	static int[] degree;
	static boolean[] visited;
	static Stack<Integer> ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt(); // 정점의 개수 (1번부터 시작)
		E = sc.nextInt(); // 간선의 개수
		
		// 인접 행렬
		adjArr = new int[V+1][V+1];
		degree = new int[V+1];
		visited = new boolean[V+1];
		ans = new Stack<>();
		
		for (int i=0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adjArr[A][B] = 1; // A=>B 간선 존재
			degree[B]++; // B의 진입차수 증가
		}
		
		// 위상 정렬
		for (int i=1; i<=V; i++) {
			if (degree[i] == 0)
				dfs(i);
		}
		
		while(!ans.empty()) {
			// 스택에 있는거 다 뽑기
			System.out.println(cook[ans.pop()]);
		}
	
	}
	
	static void dfs(int curr) {
		// 방문처리
		visited[curr] = true;
		
		// 나머지 선행 조건 체크
		for (int i=1; i<=V; i++) {
			// 간선이 존재하고, 방문하지 않았으면
			if(adjArr[curr][i]==1 && !visited[i])
				dfs(i);
		}
		ans.push(curr); // 연결되어 있는 모든 정점 방문시 스택에 추가
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
