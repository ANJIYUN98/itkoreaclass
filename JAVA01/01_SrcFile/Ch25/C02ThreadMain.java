package Ch25;

public class C02ThreadMain {

	public static void main(String[] args) throws Exception{
		
		//Main Thread에서의 실행흐름
		

		//1 작업스레드객체 생성
		C02Worker1 worker1 = new C02Worker1();
		C02Worker2 worker2 = new C02Worker2();
	
		//2 각각의 독립된 작업공간에 작업스레드를 할당
		Thread th1 = new Thread(worker1);
		Thread th2 = new Thread(worker2);
		
		//3 작업스레드 실행
		th1.start();
		th2.start();
		
		
		//[참고]1,2,3단계 동시수행
		//Thread독립 공간 만들고 작업내용을 동시에 부여함(참조변수는 생략해서 Thread만들기)
	
		new Thread() {
			@Override
			public void run()  {
				for(int i=0;i<5;i++) {
					System.out.println("TASK3!!!!!!!!..");
					try {Thread.sleep(500);} catch (InterruptedException e) {	 e.printStackTrace();}
				}
				
			}
			
		}.start();
		
		//1,2,3단계 동시수행 + Lamda( ()->{} )
		//new Thread(()->{  System.out.println("실행로직들");   }).start(); 
		new Thread(()->{  
			for(int i=0;i<5;i++) {
				System.out.println("TASK4!!!!!!!!------------..");
				try {Thread.sleep(500);} catch (InterruptedException e) {	 e.printStackTrace();}
			}
		}).start();
		
		
		//
		for(int i=0;i<5;i++) {
			System.out.println("MAIN!!!!!!!!..");
			Thread.sleep(500);
		}



	}

}
