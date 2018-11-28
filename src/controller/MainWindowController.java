/**
 * 
 */
package controller;

import view.MainWindowView;
import eventhandler.JPanelMouseListener;
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
		
		_model.setBoard(new Board(61,26));
		
		this._view.getPanel().addMouseListener(new JPanelMouseListener(_model.getBoard()));
		DrawBoard();
		setFrameSize();
	}
	
	public void DrawBoard() {
		
		DrawBoard drawBoard = new DrawBoard(61,26,15);
		
//		_view.getFrame().setBounds(_view.getPanel().getBounds().x,_view.getPanel().getBounds().y + 150,_view.getPanel().getBounds().width,_view.getPanel().getBounds().height + 100);
//		_view.getPanel().setBounds(0,0,drawBoard.getWidth() * drawBoard.getColumn(),drawBoard.getHeight() * drawBoard.getRow());
		_view.getPanel().add(drawBoard);
	}
	
	public void setFrameSize() {
		
	}
	

}
