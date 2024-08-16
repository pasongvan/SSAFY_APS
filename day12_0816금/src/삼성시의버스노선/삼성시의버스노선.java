import java.util.Scanner;

public class 삼성시의버스노선 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			
			int N = sc.nextInt();
			
			// 버스 배열
			int[][] bus = new int[N+1][2]; // 0: 최소A 1: 최대B
			
			// 버스 입력
			for (int i=1; i<=N; i++) {
				bus[i][0] = sc.nextInt();
				bus[i][1] = sc.nextInt();
			}
			
			// P 입력 및, 정류장 배열
			int P = sc.nextInt();
			int[][] busstop = new int[P+1][2]; // 0: 정류장 번호, 1: 노선 개수
			
			// 모든 정류장 노선 수 계산
			for (int i=1; i<=P; i++) {
				busstop[i][0] = sc.nextInt();
				
				// 모든 버스 순회
				for (int j=1; j<=N; j++) {
					if (bus[j][0]<=busstop[i][0] && bus[j][1]>=busstop[i][0]) {
						busstop[i][1]++;
					}
				}
			}
			// 출력
			System.out.print("#" + test_case + " ");
			for (int i=1; i<=P; i++) {
				System.out.print(busstop[i][1] + " ");
			}
			System.out.println();
		}
	}
}

// bus[N+1][2] 0: 최소A 1: 최대B
// 모두 입력

// P만큼 반복
// busstop[P+1]
// bus 배열 모두 순회
// busstop 인덱스가 버스 최소 최대 사이라면 +1