import java.io.*;
import java.net.*;

public class Vulnerable {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
			System.out.println("Listening on "+serverSocket.getLocalPort());
			while(true) {
				Socket socket=serverSocket.accept();
				System.out.println("Connection received from "+socket.getInetAddress());				
				ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
				try {	
					///UNSAFE DESERIALIZATION HERE
					Object object = objectInputStream.readObject();		
					///HERE IT'S TOO LATE TO ACT		
				} catch(Exception e) {								
					e.printStackTrace();
				}				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
