/**
 * 
 */
package controller;

import model.*;
import server.ThreadClient;
import view.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import eventhandler.*;

import helpers.CheckDataInput;

/**
 * @author minh
 *
 */

public class MainWindowController {
	
	private MainWindowView _view;
	public Game _model;
	private ThreadClient _client;
	
	
	public MainWindowController() {
		this._view = new MainWindowView();
		this._model = new Game();

	}
	
	public MainWindowController(MainWindowView view, Game model, ThreadClient client){
		this._view = view;
		this._model = model;
		this._client = client;
		
		_model.setBoard(new Board(61,26,15));
		_view.getLblmatrixSize().setText("Current size: " + _model.getBoard().sizeColumn + "x" + _model.getBoard().sizeRow);
		_model.getBoard().InitBoard();
		
		ActionListener();

		DrawBoard(_model.getBoard());

	}
	/**
	 * Action listeners for every button on the window.
	 */
	private void ActionListener() {
		this._view.getPanel().addMouseListener(new BoardMouseAdapter(_model.getBoard()));
		this._view.getPanel().addMouseMotionListener(new BoardMouseMotionAdapter(_model.getBoard()));
		
		this._view.getBtnSetMatrix().addActionListener(e -> this.setMatrix());
		
		this._view.getBtnClear().addActionListener(e -> this.ClearBoard());
		
		this._view.getBtnPause().addActionListener(e -> this.PauseGame());
		
		this._view.getBtnSetCellSize().addActionListener(e -> this.SetCellSize());
		
		this._view.getButtonReset().addActionListener(e -> this.Reset());
		
		
		this._view.getBtnStart().addActionListener(new StartActionListener(_model,_view,_client,this)); 
	}
	
	public void Reset() {

	}
	/**
	 * Eventhandler for the pause button. Will pause the thread in StartActionListener class if pressed.
	 */
	public void PauseGame() {
		
		_view.getBtnClear().setEnabled(true);
		_view.getBtnSetCellSize().setEnabled(true);
		_view.getBtnSetMatrix().setEnabled(true);
		_view.getButtonReset().setEnabled(true);
		
		if(this._model.isPaused()) {
			this._model.setPaused(false);
			this._view.getBtnPause().setText("Pause");
		}

		else {
			this._model.setPaused(true);
			this._view.getBtnPause().setText("Resume");
		}
		
	}
	/**
	 * This method handles user configuration for cell size, initilization probability rate and update rate.
	 * Also handles if something is input incorrectly
	 */
	public void SetCellSize() {
		
		
		try {
			int size = Integer.parseInt(_view.getTextFieldCellSize().getText());
			
			double probRate = Double.parseDouble(_view.getTextFieldInitProbRate().getText());
			
			double updateRate = Double.parseDouble(_view.getTextFieldUpdateRate().getText());
			
			if (size != 0 && probRate != 0.0 && updateRate != 0.0) {
				
				_model.getBoard().setInitProbRate(probRate);
				
				_model.setUpdatesPerSecond(updateRate);
				
				_model.getBoard().size = size;
						
				_model.getBoard().InitBoard();
				
			}
			else
				System.out.println("Can't be 0");
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(_view.getFrame(), "Please fill in the fields correctly!");
		}

		
	}
	/**
	 * Set matrix size for the whole board.
	 * Handles all possible errors.
	 */
	public void setMatrix() {
		
		
		try {
			int width = Integer.parseInt(_view.getTextFieldWidth().getText());
			int height = Integer.parseInt(_view.getTextFieldHeight().getText());

			if (width != 0 && height != 0) {
				
				_model.getBoard().sizeColumn = width;
				_model.getBoard().sizeRow = height;
				
//				_model.setBoard(new Board(width,height));
				_model.getBoard().InitBoard();
				_view.getLblmatrixSize().setText("Current size: " + width + "x" + height);
			}
			else
				JOptionPane.showMessageDialog(_view.getFrame(), "Fields cannot be 0!");
		}
		catch(NumberFormatException e) {
			System.out.println("Please fill in all fields");
			JOptionPane.showMessageDialog(_view.getFrame(), "Please fill in all fields correctly!");
		}



	}
	/**
	 * Repaints everything if anything is changed within the matrix.
	 * @param board
	 */
	public void DrawBoard(Board board) {	
		DrawBoard drawBoard = new DrawBoard(board,_view);

		_view.getPanel().add(drawBoard);
	}
	
	
	public void setFrameSize() {
		
	}
	
	public void ClearBoard() {
		
		
		_model.getBoard().ClearBoard();
	}
	
	public void Update() {

		int count = _model.getBoard().getCountGeneration() + 1;
		_view.getLblGeneration().setText("Generation: " + count);

	}
}
