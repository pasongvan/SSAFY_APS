package SWEA_1209_Sum;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            sc.nextInt();
            // 변수 설정 및 입력================================
            int max = -2147483648;
            int sum;
            int[][] board = new int[100][100];
            for (int r=0; r<100; r++) {
                for (int c=0; c<100; c++) {
                    board[r][c] = sc.nextInt();
                }
            }
            // 가로 검사=====================================
            for (int r=0; r<100; r++) {
                sum = 0;
                for (int c=0; c<100; c++) {
                    sum += board[r][c];
                }
                if (max < sum)
                    max = sum;
            }
            // 세로 검사=====================================
            for (int c=0; c<100; c++) {
                sum = 0;
                for (int r=0; r<100; r++) {
                    sum += board[r][c];
                }
                if (max < sum)
                    max = sum;
            }
            // 우하향 대각선 검사===============================
            sum = 0;
            for (int i=0; i<100; i++) {
                sum += board[i][i];
            }
            if (max < sum)
                    max = sum;
            // 좌하향 대각선 검사===============================
            sum = 0;
            for (int i=0; i<100; i++) {
                sum += board[i][99-i];
            }
            if (max < sum)
                    max = sum;
            // 출력=========================================
            System.out.println("#" + test_case + " " + max);
		}
	}
}