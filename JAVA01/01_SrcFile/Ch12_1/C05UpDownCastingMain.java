package Ch12_1;


class A{
	int a;

	public A(int a) {
		super();
		this.a = a;
	}

	@Override
	public String toString() {
		return "A [a=" + a + "]";
	}
	
}

class B extends A{
	int b;

	public B(int a, int b) {
		super(a);
		this.b = b;
	}

	@Override
	public String toString() {
		return "B [b=" + b + ", a=" + a + "]";
	}	

}

class C extends A{
	int c;

	public C(int a, int c) {
		super(a);
		this.c = c;
	}

	@Override
	public String toString() {
		return "C [c=" + c + ", a=" + a + "]";
	}	

}

class D extends B{
	int d;

	public D(int a, int b, int d) {
		super(a, b);
		this.d = d;
	}

	@Override
	public String toString() {
		return "D [d=" + d + ", b=" + b + ", a=" + a + "]";
	}

}

class E extends B{
	int e;

	public E(int a, int b, int e) {
		super(a, b);
		this.e = e;
	}

	@Override
	public String toString() {
		return "E [e=" + e + ", b=" + b + ", a=" + a + "]";
	}

}

class F extends C{
	int f;

	public F(int a, int c, int f) {
		super(a, c);
		this.f = f;
	}

	@Override
	public String toString() {
		return "F [f=" + f + ", c=" + c + ", a=" + a + "]";
	}

}

class G extends C{
	int g;

	public G(int a, int c, int g) {
		super(a, c);
		this.g = g;
	}

	@Override
	public String toString() {
		return "G [g=" + g + ", c=" + c + ", a=" + a + "]";
	}

}


public class C05UpDownCastingMain {
	
	public static void UpDownTestFunc(A obj, int... args) {
		
		obj.a=args[0];
		
		if(obj instanceof B) {
			B down = (B)obj; //DownCasting
			down.b = args[1];
		} if (obj instanceof C) {
			C down = (C)obj;
			down.c = args[1];
		} //instanceof는 다운캐스팅의 선별용도로 사용하기도함
		
		if(obj instanceof D) {
			D down = (D)obj; //DownCasting
			down.d = args[1];
		} if (obj instanceof E) {
			E down = (E)obj;
			down.e = args[1];
		} if(obj instanceof F) {
			F down = (F)obj; //DownCasting
			down.f = args[2];
		} if (obj instanceof G) {
			G down = (G)obj;
			down.g = args[2];
		}// 만약 if, else if, else if ...로 하면 문제 생긴다.
		//D부터 문제가 생기는데 D는 B와도 상속관계가 있기때문에 하나로 묶으면 안되므로 if로만 바꿔주거나 순서를 바꿔주면 된다. 
		
//		obj.b=args[1]; //오류, 다운캐스팅안해서
		
		System.out.println(obj);
	}//매게변수에 A 쓰면 객체를 다 받을 수 있다.

	public static void main(String[] args) {
		
		A ob1 = new A(10);
		B ob2 = new B(11,12);
		C ob3 = new C(13,14);
		D ob4 = new D(15,16,17);
		E ob5 = new E(18,19,20);
		F ob6 = new F(21,22,23);
		G ob7 = new G(24,25,26);
		
		UpDownTestFunc(ob1, 15); //A ob1 = ob1은 NoCasting
		UpDownTestFunc(ob2, 99, 98); //A ob1 = ob2은 UpCasting
		UpDownTestFunc(ob3, 77,66,55); 
		UpDownTestFunc(ob4, 33, 44, 22); 
		UpDownTestFunc(ob5, 45,56,67); 
		UpDownTestFunc(ob6, 1,2,3); 
		UpDownTestFunc(ob7,4,5,6); 

	}

}
