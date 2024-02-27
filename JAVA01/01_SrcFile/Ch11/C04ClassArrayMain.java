package Ch11;


class C04Person{
	String name;
	int age;
	
	@Override
	public String toString() {
		return "C04Person [name=" + name + ", age=" + age + "]";
	}
	
}

public class C04ClassArrayMain {
	public static void main(String[] args) {
		
		C04Person list[] = new C04Person[3];
		list[0] = new C04Person();
		list[0].name="홍길동";
		list[0].age=55;
		
		list[1] = new C04Person();
		list[1].name="이정숙";
		list[1].age=34;
		
		list[2] = new C04Person();
		list[2].name="정우성";
		list[2].age=25;
		
		System.out.println(list[0]);
		System.out.println(list[1]);
		System.out.println(list[2]);
		
	}
}
