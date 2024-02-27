package Ch15;

interface Remocon{
	void ON();
	void OFF();
	void ChangeChannel(int channel);
}
class TV implements Remocon	{
	int channel;
	@Override
	public void ON() {System.out.println("TV를 켭니다");}
	@Override
	public void OFF() {System.out.println("TV를 끕니다");}
	@Override
	public void ChangeChannel(int channel) {
		System.out.println("TV채널 변경 : " + channel);
		this.channel=channel;
	}
}
interface Browser{
	void Searchable(String url);
}

class SmartTV extends TV implements Browser{

	@Override
	public void Searchable(String url) {
		System.out.println("브라우저에서 URL "+url + " 접속요청 합니다");	
	}
	
	
}

class Radio implements Remocon	{
	int channel;
	@Override
	public void ON() {System.out.println("RADIO를 켭니다");}
	@Override
	public void OFF() {System.out.println("RADIO를 끕니다");}
	@Override
	public void ChangeChannel(int channel) {
		System.out.println("Radio채널 변경 : " + channel);
		this.channel=channel;
	}	
}

public class C01InterfaceMain {
	public static void TurnOn(Remocon controller) //Remocon controller=tv1
	{
		controller.ON();
	}
	public static void TurnOff(Remocon controller) {
		controller.OFF();
	}
	public static void ChangeChannel(Remocon controller,int channel) {
		controller.ChangeChannel(channel);
	}
	public static void SearchBrowser(Browser browser,String url) {
		browser.Searchable(url);
	}
	public static void main(String[] args) {
		TV tv1 = new TV();
		Radio radio1 = new Radio();
			
//		TurnOn(tv1);
//		ChangeChannel(tv1,10);
//		TurnOn(radio1);
//		ChangeChannel(radio1,20);
//		TurnOff(tv1);
//		TurnOff(radio1);
	
		SmartTV tv2 = new SmartTV();
		TurnOn(tv2);
		 
		ChangeChannel(tv2,100);
		TurnOff(tv2);
		SearchBrowser(tv2,"www.naver.com");
	}

}
