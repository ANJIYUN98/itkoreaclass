package Ch09_1;


// 접근 한정자
// 멤버 or 클래스의 접근범위를 제한을 위한 예약어
//public           : 모든 클래스에서 접근 가능
//private          : 해당 클래스에서만 접근 가능
//protected        : 상속 관계를 가지는 경우에 접근가능
//default(기본)     : 동일 패키지에 속한 클래스에서 접근가능
//                   (다른 패키지에서 사용하고 싶으면 import를 사용하여 특정위치를 나타내면 된다.)


// 일반인
// 이름     // 공개가능   //수정여부 o
// 나이     // 공개가능   //수정여부 o
// 주소     // 비공개     //수정여부 o
// 성별     // 공개가능   //수정여부 x
// 학력     // 비공개    //수정여부 o
// 연봉     // 비공개    //수정여부 o
// 주민번호  // 비공개    //수정여부 x
// ...


//연예인
//이름     // 비공개    //수정여부 o
//나이     // 비공개    //수정여부 o
//주소     // 비공개    //수정여부 o
//성별     // 공개가능   //수정여부 x
//학력     // 비공개    //수정여부 o
//연봉     // 비공개    //수정여부 o
//주민번호  // 비공개    //수정여부 x
//...



class C01Person{
	 String name;
	 int age;
	 String addr;
	//객체 생성할 때 기본 값은 private하게 주는 것이 좋다.(직접 접근 못하도록)
	//ob1. 하면 private 설정한 객체는 나타나지 않는다.
	
	public C01Person(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	} //generate construtor using field

	//getter
	String getName() {
		return this.name;
	} // 내가 지정한 특정함수로만 접근 가능함
	
	
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	//setter
	void setAge(int age) {
		this.age = age;
	}// 반환 할 것이 없으니까 void형으로 지정
	
	
	
//	@Override
//	public String toString() {
//		return "C01Person [name=" + name + ", age=" + age + ", addr=" + addr + "]";
//	}// generate toString // 정보은닉 위해서는 toString 사용하면 안됨
	
}

public class C01정보은닉 {

	public static void main(String[] args) {
		C01Person ob1 = new C01Person("홍길동",55,"대구");
		System.out.println(ob1.getName());
		ob1.setAge(66); //값 바꿀 수 있음
		ob1.
	}

}
