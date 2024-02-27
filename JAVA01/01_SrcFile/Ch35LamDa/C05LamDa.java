package Ch35LamDa;

//덧셈, 뺄셈, 곱셈, 나눗셈을 수행하는 함수형 인터페이스 정의
interface Calculator2 {
 int calculate(int num1, int num2);
}


public class C05LamDa {

	public static void main(String[] args) {
		// 람다 표현식을 사용하여 Calculator2 객체 생성 및 사용
		Calculator2 addition = (num1, num2) -> {
		    int result = num1 + num2;
		    System.out.println("Addition: " + result);
		    return result;
		};
		addition.calculate(5, 3);

		Calculator2 subtraction = (num1, num2) -> {
		    int result = num1 - num2;
		    System.out.println("Subtraction: " + result);
		    return result;
		};
		subtraction.calculate(5, 3);

		Calculator2 multiplication = (num1, num2) -> {
		    int result = num1 * num2;
		    System.out.println("Multiplication: " + result);
		    return result;
		};
		multiplication.calculate(5, 3);

		Calculator2 division = (num1, num2) -> {
		    int result = num1 / num2;
		    System.out.println("Division: " + result);
		    return result;
		};
		division.calculate(5, 3);

	}

}
