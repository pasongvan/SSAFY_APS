package SWEA_1974_스도쿠검증;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 스도쿠 판 입력
			int[][] board = new int[9][9];
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			int result = 1;
			// 가로 검사
			result = hori(board);
			
			// 세로 검사
			if (result == 1) {
				result = vertical(board);
			}
			
			// 3x3 검사
			if (result == 1 ) {
				result = three(board);
			}
			
			// 출력
			System.out.println("#" + test_case + " " + result);
		}
	}
	
	// 가로 검사 메소드
	static int hori(int[][] board) {
		for (int i=0; i<9; i++) {
			int[] count = new int[10]; // 1~9를 담을 카운트 배열
			for (int j=0; j<9; j++) {
				count[board[i][j]]++;
				if (count[board[i][j]]==2)
					return 0;
			}
		}
		return 1;
	}
	
	// 세로 검사 메소드
	static int vertical(int[][] board) {
		for (int j=0; j<9; j++) {
			int[] count = new int[10];
			for (int i=0; i<9; i++) {
				count[board[i][j]]++;
				if (count[board[i][j]]==2)
					return 0;
			}
		}
		return 1;
	}
	
	// 3x3 검사 메소드
	static int three(int[][] board) {
		for (int i=0; i<=6; i+=3) {
			for (int j=0; j<=6; j+=3) {
				int[] count = new int[10];
				for (int di=0; di<=2; di++) {
					for (int dj=0; dj<=2; dj++) {
						count[board[i+di][j+dj]]++;
						if (count[board[i+di][j+dj]]==2)
							return 0;
					}
				}
			}
		}
		return 1;
	}
}