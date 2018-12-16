/**
 * 
 */
package server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import model.*;

/**
 * @author thong
 *
 */
public class Server implements Runnable{

	public static final int PORT = 1546;
	private Thread server;
	private ServerSocket socket;
	
	public Server() {
		server = new Thread(this);
	}
	
	public void Start() throws IOException {
		
		socket = new ServerSocket(PORT);
		server.start();
		

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			while(true) {
				Socket s = socket.accept();
				
				System.out.println("Connection accepted.");
				System.out.println("The new socket: " + s);
				
				ThreadClient client = new ThreadClient();
				
				ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
				
				Game game = new Game(61,26,15);
				
				game.setUpdatesPerSecond(3.0);
				
				out.writeObject(game);
				
				System.out.println(game);
				
				
			}
			
			
			
		}
		catch(IOException e){
			System.out.println("Server Error: " + e.getMessage());
			
		}
		finally {
			try {
				this.socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws IOException {
		
		Server server = new Server();
		
		
	}
	
	
}
