/**
 * 
 */
package controller;

import view.MainWindowView;
import model.*;
import view.DrawBoard;

/**
 * @author minh
 *
 */

public class MainWindowController {
	
	private MainWindowView _view;
	private Game _model;
	
	public MainWindowController() {
		this._view = new MainWindowView();
		this._model = new Game();

	}
	
	public MainWindowController(MainWindowView View, Game Model) {
		this._view = View;
		this._model = Model;
		
		DrawBoard();
	}
	
	public void DrawBoard() {
		
		DrawBoard drawBoard = new DrawBoard(10,10,20,_view.getPanel().getLocationOnScreen());
		
//		_view.getPanel().setSize(drawBoard.getSize());
		
		
		_view.getPanel().add(drawBoard);
	}
	
	

}
