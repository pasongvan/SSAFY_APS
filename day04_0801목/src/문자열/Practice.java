package 문자열;

import java.util.Arrays;

public class Practice {
	
	public static void main(String[] args) {
		
		// 문자열 뒤집기
		String str = new String("algorithm");
		char[] strnew = str.toCharArray();
				
		String reverse = new String(strnew);
		
		System.out.println(reverse);
		
		// 문자열 정수로 바꾸기
		String dddd = "1234";
		int num = 0;
		
		for (int i=0; i<dddd.length(); i++) {
			char tmp = dddd.charAt(i);
			num = num*10 + tmp - '0';
		}
		System.out.println(num);
		
		// 고지식한 패턴 찾기
		String issSt = "iss";
		String senSt = "This iss a book";
		int idx = -1;
		
		for (int i=0; i<(senSt.length() - issSt.length() + 1); i++) {
			int cnt = 0;
			for (int j=0; j<issSt.length(); j++) {
				if (issSt.charAt(j) != senSt.charAt(i+j)) {
					break;
				}
				cnt++;
				if (cnt == issSt.length())
					idx = i;
			}
		}
		System.out.println(idx);
	}

}
