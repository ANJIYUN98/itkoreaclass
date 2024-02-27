package Ch25;

public class C03Woker1 implements Runnable{

	C01GUI gui;
	
	C03Woker1(C01GUI gui){
		this.gui = gui;
	}
	
	@Override
	public void run() {
		while(true) {
			try{
				gui.area1.append("Thread1....\n");
				Thread.sleep(500);
				
			}
			catch(InterruptedException e1) {
				break;
			}
			catch(Exception e1) {
				System.out.println(e1);
//				e1.printStackTrace();
			}
		}
		
	}

}
