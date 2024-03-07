package Ch10_1;


class C04Person{
	String name;
	int age;
	
	public C04Person(){}// default 생성자
	
	public C04Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}//Counstructor usin field 받아오기

	@Override
	public String toString() {
		return "C04Person [name=" + name + ", age=" + age + "]";
	}// toString 받아오기
	
	

}

public class C04ClassArrayMain {

	public static void main(String[] args) {
		
		C04Person list[] = new C04Person[3]; //동적할당하겠다.
		
		list[0] = new C04Person();
		list[0].name = "홍길동";
		list[0].age = 55;
		
		list[1] = new C04Person();
		list[1].name = "김영희";
		list[1].age = 35;
		
		list[2] = new C04Person();
		list[2].name = "김범수";
		list[2].age = 40;

		for(C04Person obj : list) {
			System.out.println(obj);
		}
	}

}
