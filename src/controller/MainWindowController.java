/**
 * 
 */
package controller;

import model.*;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import eventhandler.BoardMouseAdapter;
import eventhandler.BoardMouseMotionAdapter;

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

		this._view.getPanel().addMouseListener(new BoardMouseAdapter(_model.getBoard()));
		this._view.getPanel().addMouseMotionListener(new BoardMouseMotionAdapter(_model.getBoard()));
		
		this._view.getBtnStart().addActionListener(e -> this.Update());
//		this._view.getBtnStart().addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent ae) {
//				_model.getBoard().UpdateBoard();
//			}
//			
//		});


		DrawBoard();
		setFrameSize();

	}
	
	public void DrawBoard() {
		System.out.println(_view.getRdbtnGrid().isSelected());
			
		DrawBoard drawBoard = new DrawBoard(15,_model.getBoard(),_view);
		
//		_view.getFrame().setBounds(_view.getPanel().getBounds().x,_view.getPanel().getBounds().y + 150,_view.getPanel().getBounds().width,_view.getPanel().getBounds().height + 100);
//		_view.getPanel().setBounds(0,0,drawBoard.getWidth() * drawBoard.getColumn(),drawBoard.getHeight() * drawBoard.getRow());
		_view.getPanel().add(drawBoard);
//		drawBoard.setBounds(0,0,919,402);
//		_view.getFrame().add(drawBoard);
	}
	
	
	public void setFrameSize() {
		
	}
	
	private void Update() {

		int count = _model.getBoard().getCountGeneration() + 1;
		_view.getLblGeneration().setText("Generation: " + count);
		_model.getBoard().UpdateBoard();

	}
}
