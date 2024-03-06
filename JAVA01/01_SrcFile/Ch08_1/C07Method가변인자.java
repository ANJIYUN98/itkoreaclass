package Ch08_1;

class Simple07{
	
	int sum(int ...arg) {
//		System.out.println(arg);
		for(int num :arg) {
			System.out.print(num + " ");
		}
		return 0;
	}//가변인자라 몇개 들어올지 몰라서 'int ...arg'로 처리, 배열형태로 전달됨
	
	
	//가변인자 vs 오버로딩
	// 공통점 : 함수이름을 같게하여 여러개를 가질 수 있다.
	// 차이점 : 가변인자는 지정된 자료형만 받을 수 있다.

}

public class C07Method가변인자 {

	public static void main(String[] args) {
		
		Simple07 obj = new Simple07();
		obj.sum(10);
		System.out.println();
		obj.sum(10,20);
		System.out.println();
		obj.sum(10,20,30);
		System.out.println();
	}

}
