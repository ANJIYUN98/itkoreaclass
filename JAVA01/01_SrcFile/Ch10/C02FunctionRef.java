package Ch10;


class TV{
	BasicController basicController;
	ExtraController extraController;
	TV(){
		basicController = new BasicController();
		extraController = new ExtraController();
	}
	void TvInfo() {
		basicController.showinfo();
	}
	
}
class BasicController{
	//Basic Controller
	// Module - ON/OFF
	// Module - ChangeChannel
	// Module - SetVolumn
	ONOFF onoff;
	Channel channel;
	Volumn volumn;
	void setOnoff(ONOFF onoff) {
		this.onoff = onoff;
	}
	void setChannel(Channel channel) {
		this.channel=channel;
	}
	void setVolumn(Volumn volumn) {
		this.volumn = volumn;
	}
	
	void showinfo() {
		System.out.println("현재 ONOFF : " + onoff.isOn);
		System.out.println("현재 Channel : " + channel.curChannel);
		System.out.println("현재 Volumn : " + volumn.curVolumn);
	}
	
}
class ONOFF{
	boolean isOn;
	void ON() {System.out.println("POWER ON"); isOn=true;}
	void OFF() {System.out.println("POWER OFF"); isOn=false;}
}
class Channel{
	int curChannel;
	void setChannel(int channel) {
		curChannel=channel;
	}
}
class Volumn{
	int curVolumn;
	void setVolumn(int volumn) {
		curVolumn=volumn;
	}
}

class ExtraController{
	//Extra Controller
	//Module - InternetSearching
	//Module - Netflex
	//
}

public class C02FunctionRef {

	public static void main(String[] args) {
		
		TV tv1 = new TV(); //basicController,extraController
		tv1.basicController.setOnoff(new ONOFF());
		tv1.basicController.setChannel(new Channel());
		tv1.basicController.setVolumn(new Volumn());
		
		tv1.TvInfo();
		tv1.basicController.onoff.ON();
		tv1.basicController.channel.setChannel(21);
		tv1.basicController.volumn.setVolumn(15);
		tv1.TvInfo();
	}

}
