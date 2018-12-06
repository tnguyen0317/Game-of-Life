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
	
	public StartActionListener(Game model) {
		game = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.start();
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
		int generations = 1;
		
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
					updateTimer = 0;
					game.getBoard().UpdateBoard();
					generations++;
				}

			}
			
			if(System.currentTimeMillis() - frameCounter >= 1000)
			{
				frameCounter = System.currentTimeMillis();
				System.out.println("Generation : " + generations);
			}

		}
	}

}
