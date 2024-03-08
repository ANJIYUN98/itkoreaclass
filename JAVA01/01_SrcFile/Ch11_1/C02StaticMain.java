package Ch11_1;


C02Simple {
	int n1; // 객체를 생성해야 만들 수 있음
	static int n2;
	
	void func1() {
		n1 = 10;
		n2 = 20;
	}
	
	static void func2() {
		n1 = 400;
		n2 = 30;
	}//객체 생성 이전에 쓸 수 있음
}

public class C02StaticMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
