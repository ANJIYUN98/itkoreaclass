package Ch17;

public class C01NullPointerExceptionMain {

	public static void main(String[] args) {
		
		
		try {
		String str = null;
		System.out.println(str.toString());	//NullPointerException 예외객체가 생성되는 시점
		}
		catch(NullPointerException e)
		{
//			System.out.println("예외발생!!");
//			System.out.println(e.getCause());//예외원인
//			System.out.println(e.toString());	//예외객체 메시지
//			System.out.println(e.getStackTrace()); //예외객체 식별정보
			e.printStackTrace();
			
		}
		
		System.out.println("실행해야되는 코드1");
		System.out.println("실행해야되는 코드2");

	}

}
