package main;
import java.awt.EventQueue;

import view.MainWindowView;
import model.Game;
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
					Game game = new Game(2.0);
					
					MainWindowController controller = new MainWindowController(window,game);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
