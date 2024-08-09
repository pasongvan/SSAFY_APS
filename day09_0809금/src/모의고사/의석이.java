import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 의석이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 1차원 크기 5 2차원 배열
			String[][] letters = new String[5][];
			
			// 문자열 한 줄씩 받고 split으로 배열 저장
			for (int i=0; i<5; i++) {
				String oneLine = sc.next();
				letters[i] = oneLine.split("");
			}
			
			// 이중 반복문으로 리스트에 넣기
			List<String> list = new ArrayList<>();
			for (int j=0; j<15; j++) {
				for (int i=0; i<55; i++) {
					try {
						list.add(letters[i][j]);
					}
					catch (Exception e) {
						continue;
					}
				}
			}
			// 출력
			System.out.print("#" + test_case + " ");
			for (int i=0; i<list.size(); i++) {
				System.out.print(list.get(i));
			}
			System.out.println();
		}
		// 0. 1차원 크기 5 2차원 배열
		// 1. 문자열 한줄씩 받고 split으로 배열 저장
		// 2. 이중 반복문 i: 0~4, j: 0~14
		// try catch로 없는 인덱스는 넘김
		// 3. 리스트에 넣어서 순서대로 출력
	}

}
