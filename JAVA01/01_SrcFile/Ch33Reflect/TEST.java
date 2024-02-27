package Ch33Reflect;

class TEST{
	String myField;

	
	public TEST(){
		myField="TEST VALUE";
	}
	public TEST(String myField) {
		this.myField = myField;
	}
	public String getMyField() {
		return myField;
	}

	public void setMyField(String myField) {
		this.myField = myField;
	}
	
	public void TestFunc1() {
		System.out.println("THIS IS TESTFUCT1 !!");
	}
	public void TestFunc2() {
		System.out.println("THIS IS TESTFUCT2 !!");
	}	
	
}