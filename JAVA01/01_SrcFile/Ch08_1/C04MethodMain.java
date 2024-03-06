package Ch08_1;

import java.util.Scanner;

class MethodTest{
	//속성
	Scanner sc = new Scanner(System.in);

	
	//기능
	int sum1(int n1, int n2) {return n1+n2;} //인자o, 반환o
	int sum2() {return sc.nextInt() + sc.nextInt();} //인자x, 반환o
	void sum3(int n1, int n2) {System.out.println(n1+n2);} //인자o, 반환x
	void sum4() {System.out.println( sc.nextInt() + sc.nextInt() );} //인자x, 반환x
	

}

public class C04MethodMain {

	public static void main(String[] args) {
		MethodTest sumCalc = new MethodTest();
		System.out.println(sumCalc.sum1(10,2));
		System.out.println(sumCalc.sum2());
		sumCalc.sum3(10,20); //return 없어도 돌아오지만 값을 가지고 들어오지 않음
		sumCalc.sum4();
		

	}

}
