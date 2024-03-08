package Ch12Ex_1;


//[1번] 다음 main() 메소드와 실행 결과를 참고하여 TV를 상속받은 ColorTV 클래스를 작성하라.

//출력 결과
//32인치 1024컬러

class TV{
	   private int size;
	   public TV(int size) { this.size = size; }
	   protected int getSize() { return size; }//상속관계에 있는 하위클래스에서만 protected 적용 가능
	}

class ColorTV extends TV{
	int color;
	ColorTV(int size, int color){
		super(size);
		this.color = color;
	}
	void printProperty() {
		System.out.printf("%d인치 %d컬러\n", this.getSize(), this.color);
	}
}


public class C01 {

	public static void main(String[] args) {
		
		ColorTV myTV = new ColorTV(32, 1024);
		myTV.printProperty(); // 32인치 1024컬러 가 나오면 해결!

	}

}
