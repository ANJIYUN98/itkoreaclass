package Ch16;

public class C04StringBuffer {

	public static void main(String[] args) {
		
//		String str1 = "Hello";
//		System.out.println("STR1 : " + System.identityHashCode(str1));
//		String str2 = "World";
//		str1 = str1.concat(str2);//문자열 덧붙이기 함수
//		System.out.println(str1);
//		System.out.println("STR1 : " + System.identityHashCode(str1));

		
		long startTime = System.currentTimeMillis();
		
		//기본덧붙이기
//		String str="";
//		for(int i=0;i<=500000;i++) {
//			str+="H";
//		}
		//StringBuffer로 문자열 붙이기
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<=500000;i++) {
			buffer.append("H");
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("소요시간 : " + (endTime-startTime)+"ms");
		System.out.println(buffer);
	}

}
