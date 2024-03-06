package Ch08_1;

class C03Person{
	//속성
	String name;
	int age;
	float height;
	double weight;
		
	//기능
	
	//말하다
	void talk() {
		System.out.println(this.name + " 이 말합니다");
	}
	
	//걷다
	void walk() {
		System.out.println(this.name + " 이 걷습니다");
	}
	
	//정보확인
	void showInfo() {
		System.out.printf("%s %d %f %f\n", name, age, height, weight);
	}

	//정보확인
	@Override
	public String toString() {
		return "C03Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	} // 상속관계
	
	
}// 한 파일안에 파일명과 다른 클래스 두고 싶으면 public 한정자 사용하면 안됨



public class C03PersonMain {

	public static void main(String[] args) {
		//C01Person hong 은 stack영역에 들어가고 heap영역에는 hong._____이 들어가 있음
		
		C03Person hong = new C03Person();
		hong.name="홍길동";
		hong.age = 55;
		hong.height = 177.5f;
		hong.weight = 70.4;
		
		hong.talk();
		hong.walk();
		hong.showInfo();
		
		System.out.println("-------------");
		System.out.println(hong);
		
		
		//System.out.printf("%s %d %f %f\n", hong.name, hong.age, hong.height, hong.weight);
		// 위(22번줄)에 void showInfo()있으니까 없애도 됨
		

	}

}