package Ch08_1;

//멤버 변수

//지역 변수 : {} 내에서 선언되어지는 변수
//        : {} 에서 더이상 실행 로직이 없다면 공간 반환(없어진다..) 
//		  : 변수명 중복시 좁은 지역의 변수가 적용
// 		  : 매개변수, 멤버변수, 일반변수
//전역 변수 : static 예약어 사용시, 전역변수는 왠만하면 사용하지 않는 것이 좋다.


class C05Simple{
	int num=5; //멤버 변수, static 사용하면 전역변수 됨
	void Func1() {
		System.out.println("멤버변수 num : " + num);
		int num = 10; //이름이 중복되면 좁은 지역(15줄)에 있는 num을 사용하게 된다. (넓은 지역은 12줄의 num)
		System.out.println("Func1 지역변수 num : " + num);
		System.out.println("this.num : " + this.num); //지역변수가 아닌 멤버변수를 사용하고 싶으면 this를 사용하면 된다.
		// this. 는 지역변수와 멤버변수를 구분할 때 사용한다
	}
	void Func2() {
		System.out.println("멤버변수 num : " + num);
		if(true) {
			int num=22;
			System.out.println("if 내의 지역 num : " + num);
		}
		System.out.println("멤버변수 num : " + num);
//		while(num<10) {
//			int num=5;
//			num++;
//		} // 무한루프에 빠짐
	}
	void Func3(int num) {
		System.out.println("num : " + this.num);
	}
	void Func4() {}
}

public class C05LocalVarMain {

	public static void main(String[] args) {
		C05Simple obj = new C05Simple();
		obj.Func1();
		obj.Func2();
		obj.Func3(100);

	}

}
