/**
 * 
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import model.*;
	
/**
 * @author thong
 *
 */
public class ThreadClient implements Runnable{

	private final Socket socket;
	private ObjectInputStream in;
	private Thread client;
	private Game model;
	
	public ThreadClient() throws IOException {
		this.socket = new Socket("localhost",1546);
		
		 in = new ObjectInputStream(this.socket.getInputStream());
		
		 client = new Thread(this);
		 
		 client.start();
	}
	
	
	@Override
	public void run() {
		try {
			while(true) {
				Game game = (Game) in.readObject();
				
				System.out.println(game.getUpdatesPerSecond());
				
				
				model = game;
			}
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class not found!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				socket.close();
			}
			catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void main(String[] args) throws IOException {

		
		
	}
}
