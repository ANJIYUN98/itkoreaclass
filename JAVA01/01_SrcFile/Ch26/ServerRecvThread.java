package Ch26;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerRecvThread implements Runnable {

	Socket client;
	DataInputStream din;

	ServerRecvThread(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {

		try {

			din = new DataInputStream(client.getInputStream());
			String recv = null;
			while (true) {

				recv = din.readUTF();
				if (recv.equals("q") || recv == null)
					System.exit(-1); //종료 
				
				System.out.println();
				System.out.println("[Client] " + recv);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
