package Ch35LamDa;


//덧셈, 뺄셈, 곱셈, 나눗셈을 수행하는 함수형 인터페이스 정의
interface Calculator {
 int calculate(int num1, int num2);
}

public class C04LamDa {
	public static void main(String[] args) {
		
		//람다 표현식을 사용하여 Calculator 객체 생성 및 사용
		Calculator addition = (num1, num2) -> num1 + num2;
		System.out.println("Addition: " + addition.calculate(5, 3));

		Calculator subtraction = (num1, num2) -> num1 - num2;
		System.out.println("Subtraction: " + subtraction.calculate(5, 3));

		Calculator multiplication = (num1, num2) -> num1 * num2;
		System.out.println("Multiplication: " + multiplication.calculate(5, 3));

		Calculator division = (num1, num2) -> num1 / num2;
		System.out.println("Division: " + division.calculate(5, 3));
		
		//여러줄일때 람다 
		
		
		
	}
}
