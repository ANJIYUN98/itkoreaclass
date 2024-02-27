package Ch21;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class C03OutputStream {

	public static void main(String[] args) throws Exception{
		OutputStream out = new FileOutputStream("c:\\iotest\\test.png");
		out.write("가".getBytes(StandardCharsets.UTF_8));//문자열을 byte배열로변환전달
		out.write('b');
		out.write('c');
		out.flush();
		out.close();
	}

}
