package Ch15_1;

public class C01NullPointerExceptionMain {

	public static void main(String[] args) {

		//null
		try {
			String str = null; //컴파일 에러는 아님
			System.out.println(str.toString());
			
		}catch(NullPointerException e) {
//			System.out.println("예외 발생!" + e);
			System.out.println(e.getCause()); //원인에 대해 간략하게 표시
			System.out.println(e.toString());
			System.out.println(e.getStackTrace());
			e.printStackTrace(); // 빨간색으로 나타나는 부분, 가급적 안쓰는게 좋음
			
		}
		System.out.println("HELLOWORLD");
	}

}
