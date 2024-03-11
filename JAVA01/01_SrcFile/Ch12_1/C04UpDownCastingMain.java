package Ch12_1;


class Super{
	int n1;
}
class Sub extends Super{
	int n2;
}


public class C04UpDownCastingMain {

	public static void main(String[] args) {
		
		//NoCasting
		Super ob1 = new Super(); // 자료형이 일치해서 형변환시킬 필요 x
		ob1.n1 = 10;
		Sub ob2 = new Sub();
		ob2.n1 = 10;
		ob2.n2 = 20;
		
		
		//UpCasting : 상위클래스 참조변수 = 하위클래스 객체
		//UpCasting은 상위클래스형으로 형변환을 하는 문법
		//UpCasting은 자동 형변환이 된다.
		//객체를 연결하기 위한 공통된 참조변수가 필요하기 때문에 UpCasting을 함
		Super ob3 = new Sub(); //상위클래스의 참조변수로 하위클래스를 연결함
							   //원래는 Super ob3 = (Super) new Sub(); 이렇게 형변환 해줘야함
		ob3.n1 = 100; //n1에는 접근 가능하지만 
//		ob3.n2 = 200; //n2에는 접근 못함
		
		
		//DownCasting : 하위클래스 참조변수 = 상위클래스 형객체
		//DownCasting은 하위클래스형으로 형변환을 시도하는 문법
		//DownCasting은 강제형변환을 한다. 메모리의 접근영역문제가 생기기 때문이다.
		//확장된 부분에 접근하기 위해 DownCasing함
		Sub ob4 = (Sub)ob3; // 자식클래스형으로 맞춰줌
		
//		Sub ob4 = (Sub)new Super(); //이렇게 강제로 형변환하면 공간이 없기 때문에 다른 공간을 침범하게 될 수도 있음
		ob4.n1 = 100;
		ob4.n2= 200;
		

		
	}

}
