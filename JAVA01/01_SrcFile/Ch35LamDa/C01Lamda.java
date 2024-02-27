package Ch35LamDa;

public class C01Lamda {
	public static void main(String[] args) {
		// 람다 표현식을 사용하여 Runnable 객체 생성
		Runnable runnable = () -> {
		    for (int i = 0; i < 5; i++) {
		        System.out.println("Hello, World!");
		    }
		};

		// 스레드 실행
		Thread thread = new Thread(runnable);
		thread.start();
		
	}
}
