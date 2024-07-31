package 배열2차원;

import java.util.Arrays;

public class Practice {

	public static void main(String[] args) {
		// 문제 1
		int N = 5;
		int[][] board = new int[N][N];	
		int[][] sum = new int[N][N];
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				board[r][c] = (int) (100 * Math.random());
			}
		}
		System.out.println(Arrays.deepToString(board));
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				if (r-1 >= 0 )
					sum[r][c] += Math.abs(board[r-1][c] - board[r][c]);
				if (r+1 < N )
					sum[r][c] += Math.abs(board[r+1][c] - board[r][c]);
				if (c+1 < N )
					sum[r][c] += Math.abs(board[r][c+1] - board[r][c]);
				if (c-1 >= 0)
					sum[r][c] += Math.abs(board[r][c-1] - board[r][c]);
			}
		}
		
		// 달팽이 숫자
		
		
		
		// 사과나무 영양분
		
		
		
		
		// 지그재그 순회
		int[][] arr1 = new int[5][5];
		int num = 0;
		for (int r=0; r<5; r++) {
			for (int c=0; c<5; c++) {
				arr1[r][r%2==0 ? c : N-1-c] = num++;
			}
		}
		System.out.println(Arrays.deepToString(arr1));
		
		// 델타 배열
		int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
		int[] dc = {0, 0, -1, 1};
		
		// 전치 행렬
		int[][] arr3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		for (int r=0; r<3; r++) {
			for (int c=r+1; c<3; c++) {
				int tmp = arr3[r][c];
				arr3[r][c] = arr3[c][r];
				arr3[c][r] = tmp;
			}
		}
		System.out.println(Arrays.deepToString(arr3));
		
		
		// 배열 회전
		int[][] arr4 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] arr5 = new int[3][3];
		for (int r=0; r<3; r++) {
			for (int c=0; c<3; c++) {
				arr5[c][2-r] = arr4[r][c];
			}
		}
		System.out.println(Arrays.deepToString(arr5));
		

	}

}
