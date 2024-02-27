package Ch17;

public class C05ExceptionMain {


	public static void main(String[] args) {
	
		try {
		String str=null;	
		//String r = str.toString(); 	//Null예외
		int arr[] = {10,20,30};
		//arr[5]=100;		 			//배열예외
		System.out.println(15/0);	//산술 예외
		}
//		catch(NullPointerException e) {System.out.println("NULL예외");}
//		catch(ArrayIndexOutOfBoundsException e) {System.out.println("Arr예외");}
//		catch(ArithmeticException e) {System.out.println("산술예외");}
		catch(Exception e){
			System.out.println(e);
		}
		

	}

}
