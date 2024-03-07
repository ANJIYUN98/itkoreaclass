package Ch09_1;

public class C05StringClassMain {

	public static void main(String[] args) {
		
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java");
		String str4 = new String("java");
		
		//위치값 비교
		System.out.printf("%x\n", System.identityHashCode(str1));
		System.out.printf("%x\n", System.identityHashCode(str2));
		System.out.printf("%x\n", System.identityHashCode(str3));
		System.out.printf("%x\n", System.identityHashCode(str4));
		
		System.out.println("str1==str2 ? " + (str1==str2));// 주소 같아서 true
		System.out.println("str3==str4 ? " + (str3==str4)); //참조변수 안에 있는 주소 값 비교
		System.out.println("str1==str3 ? " + (str1==str3)); //힙이라는 공간의 메모리 영역에 값이 들어가 주소를 가리킴 
		System.out.println("str1==str4 ? " + (str1==str4));//각각 다른 힙이라는 공간의 메모리 영역에 값이 들어가 주소를 가리킴
		
		System.out.println("========================");
		//.equals 를 사용하여 문자열 비교
		//.equals 는 최상위의 obj에서 물려받은 것
		System.out.println("str1==str2 ? " + (str1.equals(str2)));
		System.out.println("str3==str4 ? " + (str3.equals(str4))); 
		System.out.println("str1==str3 ? " + (str1.equals(str3)));
		System.out.println("str1==str4 ? " + (str1.equals(str4)));

	}

}
