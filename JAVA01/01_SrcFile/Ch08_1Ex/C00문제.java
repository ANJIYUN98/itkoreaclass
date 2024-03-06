package Ch08_1Ex;


// 13번
//class Member{
//	String name;
//	String id;
//	String password;
//	int age;
//	
//	Member(String name, String id){
//		this.name = name;
//		this.id = id;
//	}
//}



//class MemberServiceEx{
//	public static void man(String[] args) {
//		MemberService memberService = new MemberService();
//		boolean result = memberService.login("hong","12345");
//		if(result) {
//			System.out.println("로그인 되었습니다.");
//			memberService.logout("hong");
//		}else {
//			System.out.println("id 또는 password가 올바르지 않습니다.");
//		}
//	}
//}
//
//
//class MemberService{
//	boolean login(String id, String password) {
//		if("hong".equals(id) && "12345".equals(password))
//			return true;
//		else
//			return false;
//	}
//
//	void logout(String id) {
//		System.out.println("로그아웃 되었습니다.");
//	}
//	
//}





class PrinterExample{
	public static void main(String[] args) {
		Printer printer = new Printer();
		printer.println(10);
		printer.println(true);
		printer.println(10.5);
		printer.println("홍길동");
		
		
	}
}


class Printer{
	void println(int x) {
		System.out.println(x);
	}
	void println(boolean x) {
		System.out.println(x);
	}
	void println(double x) {
		System.out.println(x);
	}
	void println(String x) {
		System.out.println(x);
	}
}



public class C00문제 {
	
	

	public static void main(String[] args) {
		

	}

}
