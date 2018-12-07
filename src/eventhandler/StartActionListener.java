/**
 * 
 */
package eventhandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Game;
import view.*;

/**
 * @author thong
 *
 */
public class StartActionListener implements ActionListener, Runnable{

	private Game game;
	private MainWindowView view;
	
	public StartActionListener(Game model, MainWindowView view) {
		game = model;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.start();
		
		view.getBtnStart().setEnabled(false);
	}

	public void start() {
		new Thread(this).start();
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
				if (!game.isPaused())
				{
					updateTimer = 0.0;
					game.getBoard().UpdateBoard();
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
