package Ch16;

import java.util.Objects;

import org.apache.commons.lang3.builder.HashCodeBuilder;

class C03Simple{
	private int id;	//동등객체여부 판단하는 기준
	int n;
	
	C03Simple(int id,int n){
		this.id=id;
		this.n=n;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public String toString() {
		return "C03Simple@"+hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof C03Simple) {
			C03Simple down = (C03Simple)obj;
			return Objects.equals(this.id, down.id);
		}
		return false;
	}
}

public class C03HashCodeMain {

	public static void main(String[] args) {
		C03Simple ob1 =new C03Simple(1,5);
		C03Simple ob2 =new C03Simple(1,6);
		System.out.println(ob1.equals(ob2));
		System.out.println(ob1);
		System.out.println(ob2);
		System.out.printf("%x\n",ob1.hashCode());
		
		System.out.println(ob1.hashCode());	//재정의된 hashcode
		System.out.println(ob2.hashCode());	//재정의된 hashcode
		System.out.println(System.identityHashCode(ob1));	//실제 객체위치 
		System.out.println(System.identityHashCode(ob2));	//실제 객체위치

	}

}
