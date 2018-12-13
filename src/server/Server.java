/**
 * 
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author thong
 *
 */
public class Server implements Runnable{

	public static final int PORT = 1546;
	
	public Server() {
	}
	
	public void Start() throws IOException {
		
		ServerSocket socket = new ServerSocket(PORT);
		
		try {
		
			while(true) {
				Socket s = socket.accept();
				
				System.out.println("Connection accepted.");
				System.out.println("The new socket: " + s);
				
				
			}
			
			
			
		}
		catch(IOException e){
			System.out.println("Server Error: " + e.getMessage());
			
		}
		finally {
			socket.close();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
