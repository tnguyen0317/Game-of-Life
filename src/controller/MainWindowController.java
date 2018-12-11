/**
 * 
 */
package controller;

import model.*;
import view.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import eventhandler.*;

import helpers.CheckDataInput;

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
		
		_model.setBoard(new Board(61,26,15));
		_view.getLblmatrixSize().setText("Current size: " + _model.getBoard().sizeColumn + "x" + _model.getBoard().sizeRow);
		_model.getBoard().InitBoard();
		

		this._view.getPanel().addMouseListener(new BoardMouseAdapter(_model.getBoard()));
		this._view.getPanel().addMouseMotionListener(new BoardMouseMotionAdapter(_model.getBoard()));
		
//		this._view.getBtnStart().addActionListener(e -> this.Update());

		
		this._view.getBtnSetMatrix().addActionListener(e -> this.setMatrix());
		
		this._view.getBtnClear().addActionListener(e -> this.ClearBoard());
		
		this._view.getBtnPause().addActionListener(e -> this.PauseGame());
		
		setFrameSize();
		
		DrawBoard();
//		setBoard();


		this._view.getBtnStart().addActionListener(new StartActionListener(_model,_view) {
		});

	}
	
	public void PauseGame() {
		
		if(this._model.isPaused()) {
			this._model.setPaused(false);
			this._view.getBtnPause().setText("Pause");
		}

		else {
			this._model.setPaused(true);
			this._view.getBtnPause().setText("Resume");
		}
		
	}
	
	public void SetCellSize() {
		
		int size = Integer.parseInt(_view.getTextFieldCellSize().getText());
		
		if (size != 0) {
			_model.getBoard().size = size;
					
			_model.getBoard().InitBoard();
			
		}
		else
			System.out.println("Can't be 0");
		
	}
	public void setMatrix() {
		
		int width = Integer.parseInt(_view.getTextFieldWidth().getText());
		int height = Integer.parseInt(_view.getTextFieldHeight().getText());

		if (width != 0 && height != 0) {
			
			_model.getBoard().sizeColumn = width;
			_model.getBoard().sizeRow = height;
			
//			_model.setBoard(new Board(width,height));
			_model.getBoard().InitBoard();
			_view.getLblmatrixSize().setText("Current size: " + width + "x" + height);
		}
		else
			System.out.println("Empty");


	}
	
	public void DrawBoard() {	
		DrawBoard drawBoard = new DrawBoard(_model.getBoard(),_view);
		
//		_view.getFrame().setBounds(_view.getPanel().getBounds().x,_view.getPanel().getBounds().y + 150,_view.getPanel().getBounds().width,_view.getPanel().getBounds().height + 100);
//		_view.getPanel().setBounds(0,0,drawBoard.getWidth() * drawBoard.getColumn(),drawBoard.getHeight() * drawBoard.getRow());
		_view.getPanel().add(drawBoard);
//		drawBoard.setBounds(0,0,919,402);
//		_view.getFrame().add(drawBoard);
	}
	
	
	public void setFrameSize() {
		
	}
	
	public void ClearBoard() {
		
		
		_model.getBoard().ClearBoard();
	}
	
	public void Update() {

		int count = _model.getBoard().getCountGeneration() + 1;
		_view.getLblGeneration().setText("Generation: " + count);
		_model.getBoard().UpdateBoard();


	}
}
