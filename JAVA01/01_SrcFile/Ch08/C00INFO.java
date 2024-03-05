package Ch08;

public class C00INFO {

	//1 객체 - Object
	// - 존재(배타적,독립적인 공간을차지)하는 사물(Object)

	//2 객체 구조
	//속성(Attribute) : 객체만의 고유한 Data -> (멤버)변수를 통해 저장 
	//기능(Function)	 : 객체가 수행할 수 있는 Action..->(멤버)함수를 통해 구현
	
	//3 객체 지향
	//현실 객체의 정보(속성/기능)중에 필요한 일부만 추출(추상화) 하여 프로그램에 적재하기
	//위해 고안된 문법체계
	
	
	//4 클래스(자료형)?
	//동일한 종류의 객체에 필요한 메모리공간을 제공하기 위한 선언된 자료형
	//클래스는 선언하기 전에는 기본적으로 메모리 공간을 차지하지 않는다
	//클래스 자료형에 의해 객체가 정의되는 순간 클래스에서 선언한 속성과 기능대로
	//공간이 형성되어진다
	
	

	//5 자바의 메모리 영역
	//1) 스택영역				: { } 내에서 생성되는 공간(int,double....)(멤버변수, 지역변수)
	//2) 클래스(메서드)영역		: 공유메모리 영역(생성자,일반매서드,static매서드,static변수)(공유영역)
	//3) 힙영역				: 객체 저장 영역(new 예약어 사용시 할당)
	
	
	//6 코드 해석
	//Scanner sc = new Scanner(System.in);
	
	//new 	: 힙영역에 객체 저장
	//Scanner() : 객체에 필요한 초기값을 부여하기 위한 생성자매서드
	//Scanner sc : Scanner라는 클래스 자료형으로 정의된 참조변수 sc
	
	//힙영역에 Scanner객체를 생성한뒤 객체의 주소를 sc이름의 참조변수에 저장
	
	
	
	
	//
	// C 
	// struct person{
	// char name[10];
	// int age;
	// }typedef Person
	
	
	// C 구조체만들기
	// int main(){
	// Person * hone = (Person *) malloc(sizeof(Person)); 
	// }
	
	
	
	//C++
	// class Person{
	// String name;
	// int age;
	
	//C++
	//Person & hong = new Person();
	
	
	//JAVA 
	// class Person{
	//String name;
	//int age;
	//}
	
	
	
	
}
