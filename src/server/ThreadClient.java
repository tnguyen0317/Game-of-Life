/**
 * 
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import model.*;
	
/**
 * @author thong
 *
 */
public class ThreadClient{

	
	public ObjectOutputStream out;
	public ObjectInputStream in;
	
	private Socket socket;
	private Board board;

	
	private Thread client;

	
	public ThreadClient() throws IOException {

	}
	/**
	 * Sets up a socket with an IP address and a port.
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public void connect() throws UnknownHostException, IOException {
		
		socket = new Socket("127.0.0.1",1546);
		
		in = new ObjectInputStream(socket.getInputStream());
		out = new ObjectOutputStream(socket.getOutputStream());
		
		if(socket.isConnected())
			System.out.println("CONNECTED LETS GO");
		
	}

	

}
