/**
 * 
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import model.*;
	
/**
 * @author thong
 *
 */
public class ThreadClient implements Runnable{

	private final Socket socket;
	private Scanner scan;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Board board;
	
	private Thread client;
	private Game model;
	
	public ThreadClient() throws IOException {
		
		socket = new Socket("localhost",1546);
		
		in = new ObjectInputStream(socket.getInputStream());
		out = new ObjectOutputStream(socket.getOutputStream());
		
		if(socket.isConnected())
			System.out.println("CONNECTED LETS GO");
		
	}
	
	public void sendToSocket(Board board) throws IOException {
		out.writeObject(board);
		
		
	}
	
	public void readFromSocket() throws ClassNotFoundException, IOException {
		this.board = (Board) in.readObject();
				
		
	}
	
	@Override
	public void run() {
		while(!!!false) {
			
		}
		
	}

}
