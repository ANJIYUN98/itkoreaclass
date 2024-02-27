package Ch25;

public class C03Woker2 implements Runnable{
	C01GUI gui;
	
	C03Woker2(C01GUI gui){
		this.gui = gui;
	}
	
	@Override
	public void run() {
		while(true) {
			gui.area2.append("Thread2....\n");
			try{Thread.sleep(500);}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
