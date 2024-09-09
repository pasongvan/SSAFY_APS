package 위상정렬;

import java.util.Scanner;
import java.util.Stack;

public class Practice스택 {
	
	static String[] cook = {"", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육복음만들기", "식사", "뒷정리", "채소손질", "밥하기"};
	static int V, E;
	static boolean[][] edges;
	static boolean[] visit;
	static Stack<Integer> stack;
	static int[] inDegree;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(input);
		V = sc.nextInt();
		E = sc.nextInt();
		
		edges = new boolean[V+1][V+1];
		inDegree = new int[V+1];
		
		for (int i=0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			edges[from][to] = true;
			inDegree[to]++;
		}
		
		visit = new boolean[V+1];
		stack = new Stack<>();
		
		for (int i=1; i<=V; i++) {
			if (inDegree[i] != 0) continue;
			dfs(i);
		}
		
		while(!stack.isEmpty())
			System.out.print(cook[stack.pop()] + " ");

	}
	static void dfs(int i) {
		visit[i] = true;
		
		for (int j=1; j<=V; j++) {
			if (visit[j] || !edges[i][j]) continue;
			dfs(j);
		}
		
		stack.add(i);
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
