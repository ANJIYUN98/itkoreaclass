package Ch17;

public class C03NumberFormatExceptionMain {

	public static void main(String[] args) {

		String data1 = "100";
		String data2 = "200";
		int value1=0;
		int value2=0;
		try {
			value1 = Integer.parseInt(data1);
			value2 = Integer.parseInt(data2); // 문자가 포함된 내용 Integer로 변환
		} catch (NumberFormatException e) {
//			e.printStackTrace();
			System.out.println("예외발생시 실행코드");

		}finally {
			System.out.println("예외발생과는 상관없이 무조건 실행코드");
		}

		int result = value1 + value2;
		System.out.println(data1 + "+" + data2 + "=" + result);

	}

}
