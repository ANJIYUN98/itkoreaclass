package Ch09_1;

//this
// 클래스 내에서 사용되는 예약어
// 생성되는 객체의 위치정보( 메모리주소-해시코드값 )을 확인하는데 사용


//this : 멤버변수와 지역변수 구별에 사용
//this : 다른 생성자 호출 사용
class C04Simple{
	int x;
	int y;
	
	C04Simple(){
//		this.x = 0; //초기값
//		this.y = 0; //초기값
		this(0,0);
		
	}//default 생성자
	
	C04Simple(int x){
//		this.x = x; //멤버변수에 넣음  
//		this.y = 0;
		this(x,0);
	}
	
	C04Simple(int x, int y){
//		this.x = x; 
//		this.y = y;
		
	}
	
	
	C04Simple getThis() {
		return this;
	} //객체가 만들어졌다 가정하고 하는게 this.
}

public class C04ThisMain {

	public static void main(String[] args) {


//		C04Simple obj = new C04Simple();
//		System.out.println(obj);
//		System.out.println(obj.getThis());
//		System.out.println();
//		
//		C04Simple obj2 = new C04Simple();
//		System.out.println(obj2);
//		System.out.println(obj2.getThis());

		
		C04Simple ob1 = new C04Simple(); //default 생성자 사용
		C04Simple ob2 = new C04Simple(10); //인자 1개 받는 생성자 사용
		C04Simple ob3 = new C04Simple(10, 20); //인자 2개 받는 생성자 사용
		
	}

}
