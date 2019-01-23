package main;
import java.awt.EventQueue;

import view.MainWindowView;
import model.Game;
import server.ThreadClient;
import controller.MainWindowController;

/**
 * 
 */

/**
 * @author thong
 *
 */
public class Main {

	/**
	 * @param args
	 */
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindowView window = new MainWindowView();
					
					ThreadClient client = new ThreadClient();
					
					client.connect();
					
					Game game = new Game(2.0);
					
					MainWindowController controller = new MainWindowController(window,game,client);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
