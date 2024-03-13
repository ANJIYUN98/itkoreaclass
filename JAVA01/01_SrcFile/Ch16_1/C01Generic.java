package Ch16_1;

class 재료{
	
}

//호빵에 들어가는 재료 클래스
class 팥 extends 재료{

	public 팥() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "팥 []";
	}
	
}
class 야채 extends 재료{

	@Override
	public String toString() {
		return "야채 []";
	}
	
}
class 슈크림 extends 재료{

	@Override
	public String toString() {
		return "슈크림 []";
	}
	
}
class 민초{

	@Override
	public String toString() {
		return "민초 []";
	}
	
}

//호빵 클래스
class 호빵<T extends 재료>{
	private T meterial;
	
	호빵(T meterial){
		this.meterial = meterial;
	}//호빵 생성자, 재료를 상속받는 것만 사용
	
	void showInfo() {
		System.out.println(meterial+"으로 만든 호빵!");
	}
}//제네릭 타입이 T



public class C01Generic {

	public static void main(String[] args) {
		호빵<팥> ob1 = new 호빵<팥>( new 팥() );
		ob1.showInfo();
		
		호빵<야채> ob2 = new 호빵<야채>( new 야채() );
		ob2.showInfo();
		
		호빵<슈크림> ob3 = new 호빵<슈크림>( new 슈크림() );
		ob3.showInfo();
		
//		호빵<민초> ob4 = new 호빵<민초>( new 민초() );
//		ob4.showInfo(); //민초는 재료의 상속 안받음

	}

}
