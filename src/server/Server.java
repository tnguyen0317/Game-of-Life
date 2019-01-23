/**
 * 
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import model.*;

/**
 * @author thong
 *
 */
public class Server{

	public static final int PORT = 1546;

	
	private static ArrayList<Object> b = new ArrayList<Object>();
	
	/**
	 * Reads an object from the socket which in this case is a Board object.
	 * It then uses the Board method UpdateBoard(); to update it.
	 * And writes it back to the socket.
	 * 
	 * @throws IOException throws exception if anything goes wrong in the input and output
	 * part of the server
	 * @throws ClassNotFoundException throws exception if the read object does not have 
	 * a class
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ServerSocket s = new ServerSocket(PORT);
		Socket socket = s.accept();
		
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

		if(socket.isConnected())
			System.out.println("Server connected");
		
		while(true) {

			b = (ArrayList<Object>) in.readObject(); // read Board object from client

			Board board = (Board) b.get(0);
			
			board.UpdateBoard(false); // update it
			
			out.flush();
			
			out.writeObject(b); // and then write it back to the socket
			
			
		}
		
	}
	
	
}
