package Ch15;

interface Tire{
	void run();
}
class 한국타이어 implements Tire{
	@Override
	public void run() { System.out.println("한국타이어가 굴러갑니다");}
}
class 금호타이어 implements Tire{
	@Override
	public void run() { System.out.println("금호타이어가 굴러갑니다");}
}

class Car{
	Tire FL;
	Tire FR;
	Tire BL;
	Tire BR;
	Car(){
		FL=new 한국타이어();	//Upcasting
		FR=new 한국타이어();	//Upcasting
		BL=new 한국타이어();	//Upcasting
		BR=new 한국타이어();	//Upcasting
	}
	void run() {
		FL.run();
		FR.run();
		BL.run();
		BR.run();
	}
}
public class C02InterfaceMain {
	public static void main(String[] args) {
		Car car1 = new Car();
		car1.run();
		
		car1.FR=new 금호타이어();
		System.out.println();
		car1.run();
		

	}

}
