package Ch09_1;



class Engine{
	private void 흡입() {System.out.println("외부로부터 공기르 빨아들인다");}
	private void 압축() {System.out.println("가둔 공기를 압축시킨다");}
	private void 폭발() {System.out.println("일정 수준 압축되면 폭발!");}
	private void 배기() {System.out.println("가스를 외부로 보낸다");}
	
	public void EngineStart() {
		
		흡입();
		압축();
		폭발();
		배기();
	} //캡슐화, 순서에 맞게 실행된다. 외부 버튼과 연결함
}
class Car{
	Engine engine;
	Car(){
		engine = new Engine();
	}
	
	void run() {
		engine.EngineStart();
	} // 캡슐화시킨 것과 연결
}

public class C02캡슐화 {
	
	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.run();
	}

}
