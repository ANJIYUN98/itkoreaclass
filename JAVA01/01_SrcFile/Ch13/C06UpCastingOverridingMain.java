package Ch13;


class C06Super{
	void SuperFunc() {System.out.println("SuperFunc 호출!!");}	
}
class C06Sub extends C06Super{
	void SubFunc() {System.out.println("SubFunc 호출!!");}
	
	void SuperFunc() {System.out.println("Sub클래스에서 재정의한 SuperFunc 호출!!");}
}

public class C06UpCastingOverridingMain {

	public static void main(String[] args) {
			
		C06Super ob = new C06Sub(); //Upcasting
		ob.SuperFunc();//물려받은 멤버는 접근 가능
		//ob.SubFunc(); //확장된 멤버는 접근 불가
		
		//Upcasting 을 사용하면
		//확장된 멤버에 접근가능 ? x -> Downcasting을 통해 확장된 멤버에 접근
		//오버라이딩된 멤버에 접근가능 ? o
		
		
	}

}
