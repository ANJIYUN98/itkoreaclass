package Ch25;

public class C02Worker1 implements Runnable{

	@Override
	public void run() 
	{
		for(int i=0;i<5;i++) {	
			System.out.println("TASK1..");
			try {
				Thread.sleep(500);//0.5초 일시정지
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}

}
