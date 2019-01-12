/**
 * 
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import model.*;

/**
 * @author thong
 *
 */
public class Server{

	public static final int PORT = 1546;

	private static int[][] currentGen = new int[30][40];
	private static int[][] nextGen = new int[30][40];
	private static Object currentGenNum;
	private static Board board;
	private Thread server;
	private ServerSocket socket;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ServerSocket s = new ServerSocket(PORT);
		Socket socket = s.accept();
		
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		
		if(socket.isConnected())
			System.out.println("Server connected");
		
		while(true) {

			board = (Board) in.readObject(); // read Board object from client
			
			board.UpdateBoard(false); // update it
			
			out.writeObject(board); // and then write it back to the socket
			
			
		}
		
	}
	
	
}
