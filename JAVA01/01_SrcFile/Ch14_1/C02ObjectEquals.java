package Ch14_1;


class C02Simple{
	int n;
	C02Simple(int n){
		this.n = n;
	}
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof C02Simple) {
			C02Simple down = (C02Simple)obj;
			return this.n == down.n;
		}// 기본으로 업캐스팅 되어 있으므로 다운캐스팅 해줘야함 
		
		return false;
	}

}


public class C02ObjectEquals {

	public static void main(String[] args) {
		
		C02Simple ob1 = new C02Simple(10);
		C02Simple ob2 = new C02Simple(10);
		C02Simple ob3 = new C02Simple(20);
		
		System.out.println(ob1.equals(ob2));
		System.out.println(ob1.equals(ob3));
		//equals를 재정의를 하지 않고 사용하면 참조변수간 비교함

		String str1 = new String("JAVA");
		String str2 = new String("JAVA");
		str1.equals(str2);
		
		str1.toString();
	}

}
