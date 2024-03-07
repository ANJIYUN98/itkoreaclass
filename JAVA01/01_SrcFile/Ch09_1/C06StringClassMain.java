package Ch09_1;

import java.util.Scanner;

public class C06StringClassMain {

	public static void main(String[] args) {

		String str1 = "Java Powerful";
		String str2 = new String ("Java Programing");
		String str3 = str1 + str2;
		String str4 = str1.concat(str2);
		
		//문자열 덧붙이는 작업 반복 (StringBuffer, StringBulider)
		StringBuffer str5 = new StringBuffer();
		System.out.println("------------------");
		System.out.printf("%x\n", System.identityHashCode(str5)); //덧붙이기 전 위치 확인
		str5.append(str1).append(str2).append(str3).append(str4); //덧붙일땐 .append 사용하면 됨
		System.out.printf("%x\n", System.identityHashCode(str5)); //덧붙인 후 위치 확인
		System.out.println("------------------");
		
		System.out.println(str5);
		
		
		//문자열 확인
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
		
		
		//위치확인
		System.out.printf("%x\n", System.identityHashCode(str1));
		System.out.printf("%x\n", System.identityHashCode(str2));
		System.out.printf("%x\n", System.identityHashCode(str3));
		System.out.printf("%x\n", System.identityHashCode(str4));

		//문자열 길이 확인
		System.out.println("----------------");
		System.out.println("문자열 길이 : " + (str1.length()));
		System.out.println("문자열 길이 : " + (str1.charAt(1)));
		
//		Scanner sc = new Scanner(System.in);
//		char ch = sc.next().charAt(0);
		
		//indexOf : 문자 찾기
		System.out.println("문자 찾기 : " + (str1.indexOf("a")));
		System.out.println("문자 찾기 : " + (str1.lastIndexOf("a"))); //뒤에서 찾음
		
		
		// .contains : 해당 문자열을 포함하고 있는지 물음
		System.out.println("문자 포함 여부 : " + (str1.contains("va")));
		System.out.println("문자 포함 여부 : " + (str1.contains("abs")));
		
		// trim : 양 끝 빈공간 제거
//		Scanner sc = new Scanner(System.in);
//		String tmp = sc.nextLine();
//		System.out.println(tmp.length());
//		System.out.println(tmp.trim().length());
		
		//subString(시작인덱스, 끝인덱스) : 문자열 자르기
		System.out.println("문자열 자르기 : " + (str1.substring(2,6)));
		
		//.split : 반복되는 문자를 잘라서 배열형태로 제공
		String str6 = "홍길동,남길동,서길동,동길동,길동길동";
		String[] result = str6.split(",");
		for(String val : result) {
			System.out.println(val);
		}
		
	}

}
