/**
 * 
 */
package controller;

import view.MainWindowView;
import model.*;

/**
 * @author minh
 *
 */

public class MainWindowController {
	
	public MainWindowView View;
	public Game Model;
	
	public MainWindowController(MainWindowView View, Game Model) {
		this.View = View;
		this.Model = Model;
	}
	
	private void DrawBoard() {
		// Draw grid on JPanel based on column and row size
		
	}
	
}
