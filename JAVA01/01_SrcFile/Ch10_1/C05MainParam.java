package Ch10_1;

public class C05MainParam {
	
	public static void main(String[] args) {
		System.out.println("Paramlengths : "+ args.length);
		for(String param : args) {
			System.out.println(param);
		}
	}

}
