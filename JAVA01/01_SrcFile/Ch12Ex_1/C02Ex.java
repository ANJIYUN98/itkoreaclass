package Ch12Ex_1;

class Employee{
	public String name;
	protected int age;
	private String addr;

//getter and setter
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	// 여기까지
	
	public Employee(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}	
	
}
class Parttimer extends Employee{
	private int hour_pay;
	
	public Parttimer(String name, int age, String addr, int hour_pay) {
		super(name, age, addr);
		this.hour_pay = hour_pay;
	}

	public void setHour_pay(int hour_pay) {
		this.hour_pay = hour_pay;
	}

	@Override
	public String toString() {
		return "Parttimer [hour_pay=" + hour_pay + ", name=" + name + ", age=" + age + ", getAge()=" + getAge()
				+ ", getAddr()=" + getAddr() + "]";
	}

	

}


class Regular extends Employee{
	private int salary;
	
	public Regular(String name, int age, String addr, int salary) {
		super(name, age, addr);
		this.salary = salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Regular [salary=" + salary + ", name=" + name + ", age=" + age + ", getAge()=" + getAge()
				+ ", getAddr()=" + getAddr() + "]";
	}

	
	
	
}


public class C02Ex {
	
	public static void ShowInfo(Employee emp) {
		if(emp instanceof Regular) {
			Regular down = (Regular)emp;
			System.out.println(down.toString());
		}else if(emp instanceof Parttimer) {
			Parttimer down = (Parttimer)emp;
			System.out.println(down.toString());
		}
	}
	
	public static void main(String[] args) {
		Parttimer emp1 = new Parttimer("홍길동",25,"대구",20000);
		Regular emp2 = new Regular("서길동",45,"울산",50000000);
		System.out.println(emp1);
		System.out.println(emp2);
		
	}
}
