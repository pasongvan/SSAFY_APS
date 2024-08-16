import java.util.Arrays;
import java.util.Scanner;

public class 신입사원분반교육 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 입력
			int N = sc.nextInt();
			int min = sc.nextInt();
			int max = sc.nextInt();
			int answer = 1000;
			int[] score = new int[N];
			for (int i=0; i<N; i++ ) {
				score[i] = sc.nextInt();
			}
			
			// 점수 배열 오름차순 정렬
			Arrays.sort(score);
			
			// 분반 나누는 모든 조합 순회
			for (int i=1; i<=N-2*min; i++) {
				for (int j=i+1; j<=N-min; j++) {
					
					// 만약 score1이나 score2를 가진 학생이 중복된다면 하나만 세줌
					if (score[i]==score[i-1] || score[j]==score[j-1])
						continue;
					
					// 각 반 인원
					int[] numClass = new int[3]; 
					numClass[0] = i; // 미흡
					numClass[1] = j-i; // 보통
					numClass[2] = N-j; // 우수
					
					// 인원 적은 수대로 정렬
					Arrays.sort(numClass);
					
					// 가장 적은 반 인원이 최소보다 적거나
					// 가장 많은 반 인원이 최대보다 크면 통과
					if (numClass[0]<min || numClass[2]>max)
						continue;
					
					// 차가 최소보다 적다면 최솟값 갱신
					int diff = numClass[2] - numClass[0];
					if (answer > diff) {
						answer = diff;
					}
				}
			}
			// 분반 나누기가 불가능 하다면 정답에 -1 저장
			if (answer == 1000)
				answer = -1;
			
			// 출력
			System.out.println("#" + test_case + " " + answer);
		}
	}
}

// 1차원 배열로 점수 받음
// 정렬
// 1 3 3 5 5 5
// 이중 반복문
// i: 1 ~ N-2*min
// j: i+1 ~ N-min
// 만약 [i]==[i-1] 이거나 [j][j-1]이면 안됨
// 부진 반 인원: i명
// 보통 반 인원: j-i명
// 우수 반 인원: N-j명
// 각각 최소인원, 최대인원 안에 있는지 확인
// 가장 많은 분반, 적은 분반 학생 수 차 계산
// 최솟값 갱신