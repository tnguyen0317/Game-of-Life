/**
 * 
 */
package eventhandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.Game;
import view.*;
import server.*;

/**
 * @author thong
 *
 */
public class StartActionListener implements ActionListener, Runnable{

	private Game game;
	private MainWindowView view;
	private Thread t1;
	private ThreadClient client;
	
	public StartActionListener(Game model, MainWindowView view) {
		game = model;
		this.view = view;
		
		t1 = new Thread(this);
	}
	
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

					game.getBoard().UpdateBoard(view.getRdbtnEnableInitializationProbability().isSelected());
					
					
					
					
					genCount++;
					view.getLblGeneration().setText("Generation: " + genCount);
				}


			}
			
			if(System.currentTimeMillis() - frameCounter >= 1000)
			{
				frameCounter = System.currentTimeMillis();
				System.out.println("Generation : " + genCount);

				//_view.getLblGeneration().setText("Generation: " + count);
				
			}

		}
	}

}
