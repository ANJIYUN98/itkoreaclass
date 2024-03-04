package Ch99;


class Buyer{
	 private int myMoney; // '-' 붙었으므로 private 하게
	 private int appleCnt;
	Buyer(int money, int cnt){
		this.myMoney = money;
		this.appleCnt = cnt;
	} //생성자 함수
	
	public void pay(Seller seller, int money) {
		// Seller에게 돈 주기 전에 
		myMoney -= money;              			// 1. myMoney에서 전달받은 money 만큼 차감시키기
		int cnt = seller.receive(money);        // 2. seller01의 receive 메서드를 이용해서 receive(money) 를 전달하기
		appleCnt += cnt;						// 6. 리턴되는 사과개수를 받아 appleCnt에 누적시키기
		
	}

	public void showinfo() {
		System.out.println("보유금액 : " + myMoney); //buyer의 구매 후 남은 보유금액 출력
		System.out.println("사과개수 : " + appleCnt); //buyer의 구매할 사과개수 출력
		
	};
} //구매하기 함수

class Seller{
	private int myMoney;
	private int appleCnt;
	public int price; // '+' 붙었으므로 public 하게
	Seller(int money,int cnt,int price){
		this.myMoney = money;
		this.appleCnt = cnt;
		this.price = price;
	}// 생성자 함수
	
	public int receive(int money) {
		myMoney += money; 			// 3. myMoney 에 전달받은 money를 누적시키기
		int cnt = money/price;
		appleCnt -= cnt; 			// 4. 보유사과개수(appleCnt)에 전달받은 받은금액만큼의 사과개수(money/price)를 차감시키기
		return cnt; 				// 5. 호출했던 위치(구매자의 pay함수)로 사과개수(money/price)를 전달하기
		
	}

	public void showinfo() {
		System.out.println("보유금액 : " + myMoney); //seller의 보유금액 출력
		System.out.println("사과개수 : " + appleCnt); //seller의 보유 사과개수 출력
		System.out.println("개당가격 : " + price); //사과의 개당 가격 출력
		
	};
} //돈 받기위한 함수


public class test {

	public static void main(String[] args) {
		
		Seller seller01 = new Seller(100000,100,1000); //(보유금액, 사과개수, 사과1개 가격)
		Buyer buyer01 = new Buyer(10000, 0);  // (가진 금액, 사과 개수)
		Buyer buyer02 = new Buyer(20000, 0);
		Buyer buyer03 = new Buyer(30000, 0);
		
		
		buyer01.pay(seller01, 2000); // seller에게 2000원 지불
		buyer02.pay(seller01, 5000); // seller에게 5000원 지불
		buyer03.pay(seller01, 3000); // seller에게 3000원 지불
		
		System.out.println("---판매자 정보---");
		seller01.showinfo();
		System.out.println("---구매자 정보---");
		System.out.println("-buyer01-");
		buyer01.showinfo();
		System.out.println("-buyer02-");
		buyer02.showinfo();
		System.out.println("-buyer03-");
		buyer03.showinfo();
		
		
//		System.out.printf("%d,%d\n", buyer01.myMoney, buyer01.appleCnt);
//		System.out.printf("%d,%d\n", seller01.myMoney, seller01.appleCnt);

	}

}
