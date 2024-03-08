package Ch11_1;


class Company{
	
	int n1;
	int n2;
	
	//싱글톤 패턴 코드
	private static Company Instance; // 전역 객체변수로 사용하기 위해 static 객체변수로 생성
	private Company() {
		
	}//생성자를 외부에서 호출할 수 없도록 private로 접근 제한
	public static Company getInstance() {
		if(Instance==null) // 최초 한번만 new 연산자를 통하여 메모리에 할당함
			Instance = new Company();
		return Instance;
	}
	
	@Override
	public String toString() {
		return "Company [n1=" + n1 + ", n2=" + n2 + "]";
	}
	
}

public class C03SingleTonPatternMain {

	public static void main(String[] args) {
		Company com1 = Company.getInstance();
		Company com2 = Company.getInstance();
		com1.n1=100;
		com1.n2=200;
		
		System.out.println(com2);

	}// getInstance()는 싱글톤에서 유일하게 외부에서 객체를 얻는 방법

}
