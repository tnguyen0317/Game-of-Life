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
		
		setBoard();

		

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
	
	private void setBoard(){
		Point matrixSize;
		
		try {

			matrixSize = getMatrixSize();
			
			System.out.println("Width: " + matrixSize.X + "\nHeight: " + matrixSize.Y);
			_model.setBoard(new Board(matrixSize.X,matrixSize.Y));
			
		}
		catch(NullPointerException e) {
			System.out.println("Matrix is either incorrectly input on the [width]x[height] format\nor it is simply too large.");
			System.exit(1);
			
		}

		
	}
	public Point getMatrixSize() {
		
		String lblmatrixSize = _view.getLblmatrixSize().getText();
		
		_view.getLblmatrixSize().setText(lblmatrixSize + _view.getComboBox().getSelectedItem().toString());
		
		String matrixSize = _view.getComboBox().getSelectedItem().toString();
		
		if (CheckDataInput.checkMatrixInput(matrixSize)) {
			
			String[] parts = matrixSize.split("x");
			
			int width = Integer.parseInt(parts[0]);
			
			int height = Integer.parseInt(parts[1]);
			
			//Won't allow for grids with width or height higher than 100
			if (width > 100 || height > 100)
				return null;
			
			
			Point size = new Point(width,height);
			
			return size;
		}
		

		return null;
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
