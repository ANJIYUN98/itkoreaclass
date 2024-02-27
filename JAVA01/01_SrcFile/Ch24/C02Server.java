package Ch24;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class C02Server {
	public static void main(String[] args) throws Exception {

		// Server Socket 192.168.2.254:5000
		ServerSocket server = new ServerSocket(8000);
		System.out.println("[INFO] Server Socket Listening..");

		// 1:1 Socket Communication's Stream
		Socket client = server.accept();
		System.out.println("Client 접속 IP : " +client.getInetAddress());
		DataInputStream din = new DataInputStream(client.getInputStream());
		DataOutputStream dout = new DataOutputStream(client.getOutputStream());
		
		Scanner sc = new Scanner(System.in);
		String recv=null;
		String send=null;
		while (true) {
			
			//수신
			recv=din.readUTF();
			if(recv.equals("q")||recv==null)
				break;
			System.out.println("[Client] "+recv);
			
			//송신
			System.out.print("[Server(q:종료)] ");
			send=sc.nextLine();
			dout.writeUTF(send);
			dout.flush();
			if(send.equals("q"))
				break;
		}

	}
}
