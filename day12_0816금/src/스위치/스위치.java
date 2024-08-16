import java.util.Scanner;

public class 스위치 {

	static int N;
	static int[] light;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력
		N = sc.nextInt();
		light = new int[N];
		for (int i=0; i<N; i++) {
			light[i] = sc.nextInt();
		}
		
		// 학생 수 입력
		int num_student = sc.nextInt();
		
		// 학생 수만큼 반복
		for (int iter=0; iter<num_student; iter++) {
			
			// 학생 성별과 스위치 위치 입력
			int gender = sc.nextInt();
			int index = sc.nextInt() - 1;
			
			// 남학생
			if (gender == 1) {
				boy(index+1);
			}
			// 여학생
			else {
				light[index] = 1 - light[index]; // 가운데 스위치 변경
				girl(index-1, index+1);
			}
			
		}
		// 출력
		for (int i=0; i<N; i++) {
			System.out.print(light[i] + " ");
		}
	}
	// 남학생 메소드
	static void boy(int index) {
		for (int i=index-1; i<N; i+=index) {
			light[i] = 1 - light[i];
		}
	}
	
	// 여학생 메소드
	static void girl(int left, int right) {
		// 기저조건
		if (left<0 || right >=N)
			return;
		
		// 재귀 부분
		if (light[left] == light[right]) {
			light[left] = 1 - light[left];
			light[right] = 1 - light[right];
			girl(left-1, right+1);
		}
	}
}

// 남학생 메소드
// for 문 n부터 N까지 n씩 증가
// 스위치 바꾸어줌

// 여학생 메소드 (int left, int right)
// 
// 기저조건
// 인덱스 범위 초과 시 종료
// 재귀
// left와 right가 같으면 스위치 변경
// method(left-1, right+1)