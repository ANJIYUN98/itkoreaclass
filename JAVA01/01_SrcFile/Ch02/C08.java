package Ch02;

public class C08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		byte a = 'a';
//		byte b = '가';
//		byte c = 'ㄱ';
//		short d = '가'; // 안됨. 범위가 넘어가서 , short는 음수 사용하므로 -32,768 ~ 32,767 가 범위
//		short e = 'ㄱ';
//		char f = '가';
		
		
		System.out.println((int)'ㄱ');// 결과 : 12593
		System.out.println((int)'가'); //결과 : 44032

		System.out.println((byte)'a'); //결과 : 97
		
		System.out.println((byte)'가'); //결과 : 0
		System.out.println((byte)'ㄱ'); //결과 : 49
		
		System.out.println((short)'가'); //결과 : -21504
		System.out.println((short)'ㄱ'); //결과 : 12593
		
		System.out.println((char)'ㄱ'); //결과 : ㄱ
		System.out.println((char)'가'); //결과 : 가
		
		

		
		
		

	}

}
