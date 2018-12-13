/**
 * 
 */
package server;

import java.io.IOException;
import java.net.Socket;
/**
 * @author thong
 *
 */
public class Client implements Runnable{

	private final Socket socket;
	
	public Client(Socket socket) throws IOException {
		this.socket = socket;
		
		
		
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	

}
