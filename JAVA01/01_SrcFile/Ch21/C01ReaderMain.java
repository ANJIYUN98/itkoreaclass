package Ch21;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class C01ReaderMain {

	public static void main(String[] args) throws IOException {
		
		try {
			Reader in = new FileReader("c:\\iotest\\test1.txt");
			StringBuffer buffer = new StringBuffer();
			while(true)
			{
				int data=in.read();
				if(data==-1)
					break;
				buffer.append((char)data);
				
			}
			System.out.println(buffer);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
