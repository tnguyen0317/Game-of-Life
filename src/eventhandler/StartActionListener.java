/**
 * 
 */
package eventhandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import controller.MainWindowController;
import model.Board;
import model.Game;
import view.*;
import server.*;

/**
 * @author thong
 *
 */
public class StartActionListener implements ActionListener, Runnable, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5064562578370221224L;
	
	private Game game;
	private MainWindowView view;
	private Thread t1;
	private Board board;
	private ThreadClient client;
	private ArrayList<Object> b;
	private MainWindowController cont;
	
	public StartActionListener(Game model, MainWindowView view, ThreadClient client,MainWindowController cont) {
		game = model;
		this.view = view;
		this.client = client;
		this.cont = cont;
		
		t1 = new Thread(this);
	}
	/**
	 * This method is called upon when the start button is clicked.
	 * Basically just disables a few buttons, and then starts up a thread.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		

		this.start();
		
		view.getBtnStart().setEnabled(false);
		view.getBtnClear().setEnabled(false);
		view.getBtnSetCellSize().setEnabled(false);
		view.getBtnSetMatrix().setEnabled(false);
		view.getButtonReset().setEnabled(false);
		
		game.setPaused(false);
		

	}

	public void start() {

		t1.start();
	}
	/**
	 * Runs the thread which will update the board through the server 
	 * for a constant period of time.
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		double frameRate = 1000000000.0 / game.getUpdatesPerSecond();
		
		long currentTime = System.nanoTime();;
		long previousTime = currentTime;
		long elapsedTime = 0;
		
		double updateTimer = 0.0;
		
		long frameCounter = System.currentTimeMillis();
		int genCount = game.getBoard().getCountGeneration();
		
		while(true)
		{
			previousTime = currentTime;
			currentTime = System.nanoTime();
			elapsedTime = currentTime - previousTime;
			
			updateTimer += elapsedTime;
			
			if(updateTimer > frameRate)
			{
				updateTimer = 0.0;
				
				if (!game.isPaused())
				{

//					game.getBoard().UpdateBoard(view.getRdbtnEnableInitializationProbability().isSelected());
					
					try {
						ArrayList<Object> b = new ArrayList<Object>();
						
						b.add(game.getBoard());
						
						sendToSocket(b);
						
						readFromSocket();
						
						
					} catch (IOException | ClassNotFoundException e) {
						e.printStackTrace();
					}
					

					
					genCount++;
					view.getLblGeneration().setText("Generation: " + genCount);
				}


			}
			
			if(System.currentTimeMillis() - frameCounter >= 1000)
			{
				frameCounter = System.currentTimeMillis();
				System.out.println("Generation : " + genCount);

			}

		}
	}
	
	/**
	 * Writes an ArrayList<Object> to the socket from the client class
	 * @param b
	 * @throws IOException
	 */
	public void sendToSocket(ArrayList<Object> b) throws IOException {
		
		client.out.writeObject(b);
		
	}
	
	/**
	 * Reads from the socket in the client class
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void readFromSocket() throws ClassNotFoundException, IOException {
		this.b = (ArrayList<Object>) client.in.readObject();
		
		game.getBoard().UpdateBoard(view.getRdbtnEnableInitializationProbability().isSelected());
		
		this.board = (Board) b.get(0);
		
	}

}
