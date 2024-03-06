package Ch08_1;



//클래스 선언시 생성자함수를 1개 이상 명시하게 되면 디폴트 생성자가 자동 주입되지 않으니 주의!

class C09Simple{
	int num;
	
	C09Simple(){}
	public C09Simple(int num) {
		super();
		this.num = num;
	}
//	C09Simple(int num){this.num = num;} // 이렇게 하면 15번째 줄에서 undefined 문제가 생긴다. 
	                                    //defalut 생성자가 있는데 또 생성자를 만든거라서
}


public class C09ConstructorMain {
	
	public static void main(String[] args) {
		
		C09Simple ob = new C09Simple();
	}

}
