package Ch35LamDa;


// 람다 표현식을 사용하여 인자를 출력하는 함수형 인터페이스 정의
interface Printer {
    void print(String message);
}

public class C02Lamda {
	public static void main(String[] args) {


		// 람다 표현식을 사용하여 Printer 객체 생성 및 사용(message파라미터를 받아 -> 이후 로직처리)
		Printer printer = message -> System.out.println(message);
		printer.print("Hello, World!");

		
	}
}
