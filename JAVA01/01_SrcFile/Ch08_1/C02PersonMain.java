package Ch08_1;


class C02Person{
	//속성
	String name;
	int age;
	float height;
	double weight;
		
	//기능
	
}// 한 파일안에 파일명과 다른 클래스 두고 싶으면 public 한정자 사용하면 안됨



public class C02PersonMain {

	public static void main(String[] args) {
		//C01Person hong 은 stack영역에 들어가고 heap영역에는 hong._____이 들어가 있음
		
		C01Person hong = new C01Person();
		hong.name="홍길동";
		hong.age = 55;
		hong.height = 177.5f;
		hong.weight = 70.4;
		System.out.printf("%s %d %f %f\n", hong.name, hong.age, hong.height, hong.weight);
		

	}

}
