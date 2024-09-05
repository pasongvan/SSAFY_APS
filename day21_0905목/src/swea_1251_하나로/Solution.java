package swea_1251_하나로;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			
			int N = sc.nextInt();
			
			// 섬 좌표 배열
			long[][] island = new long[N][2];
			for (int i=0; i<N; i++) {
				island[i][0] = sc.nextInt();
			}
			for (int i=0; i<N; i++) {
				island[i][1] = sc.nextInt();
			}
			
			// 세율 입력
			double ecoFee = sc.nextDouble();
			
			// 섬 간 거리 배열
			long[][] edges = new long[N][N]; // [시작][끝]
			for (int i=0; i<N-1; i++) {
				for (int j=i+1; j<N; j++) {
					edges[i][j] = edges[j][i] = (island[i][0] - island[j][0])*(island[i][0] - island[j][0]) + (island[i][1] - island[j][1])*(island[i][1] - island[j][1]);
					if (edges[i][j] < 0) edges[i][j] = edges[j][i] = Long.MAX_VALUE; 
				}
			}
			
			// 방문 배열, 거리 배열
			boolean[] visit = new boolean[N];
			long[] dist = new long[N];
			Arrays.fill(dist, Long.MAX_VALUE);
			
			// 0번부터 시작
			dist[0] = 0;
			
			// 모든 섬 방문할 때까지 반복
			for (int i=0; i<N; i++) {
				
				long min = Long.MAX_VALUE;
				int index = -1;
				// dist 배열 중 가장 작은 값 찾기
				for (int j=0; j<N; j++) {
					// 방문했거나 최솟값보다 크거나 같으면 넘김
					if (visit[j] || min <= dist[j]) continue;
					// 인덱스, 최솟값 갱신
					min = dist[j];
					index = j;
				}
				
				// 방문 처리
				visit[index] = true;
				
				// 선택된 섬에서 거리 계산하며 dist 배열 조정
				for (int j=0; j<N; j++) {
					// 방문했거나 dist보다 크거나 같으면 넘김
					if (visit[j] || dist[j] <= edges[index][j]) continue;
					// dist 갱신
					dist[j] = edges[index][j];
				}
			}
			// 다리 길이 총합 계산
			long sum = 0;
			for (long d : dist) {
				sum += d;
			}
			// 세율 곱한 정답 계산
			long ans = Math.round(ecoFee * sum);
			// 출력
			System.out.println("#" + tc + " " + ans);
		}

	}

}
