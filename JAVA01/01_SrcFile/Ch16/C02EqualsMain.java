package Ch16;

class C02Simple{
	int n;
	C02Simple(int n){
		this.n=n;
	}
	//두 객체간의 n의값이 일치하면 동등객체 equals 재정의 예정
	@Override
	public boolean equals(Object obj) //Object obj=ob2;
	{
		if(obj instanceof C02Simple) {
			C02Simple down = (C02Simple)obj;
			return this.n==down.n;
		}
		return false;
	}	
}
class B{
}
public class C02EqualsMain {

	public static void main(String[] args) {
		
		C02Simple ob1 = new C02Simple(10);
		C02Simple ob2 = new C02Simple(10);
		C02Simple ob3 = new C02Simple(20);
		B ob4 = new B();
		System.out.println(ob1==ob2);
		System.out.println(ob1.equals(ob2));
		
		String a = "JAVA";
		String b = "JAVA";
		System.out.println();
		System.out.println(a==b);
		
	}

}
