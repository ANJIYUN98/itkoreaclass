package Ch22;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class C04PrintStreamEx {

	public static void main(String[] args) throws Exception{
		
		FileOutputStream out  = new FileOutputStream("c:\\iotest\\test.txt");
		PrintStream pout = new PrintStream(out);
		
		pout.println("[프린트 보조 스트림사용 확인!]");
		pout.println("[프린트 보조 스트림사용 확인!]");

		pout.flush();
		pout.close();
	}

}
