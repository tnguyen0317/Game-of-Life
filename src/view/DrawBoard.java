/**
 * 
 */
package view;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

import helpers.CheckDataInput;
import model.Board;
import model.Cell;
import model.Point;

/**
 * @author thong
 *
 */
public class DrawBoard extends JPanel{


	private final int size;
	private Board board;
	private MainWindowView view;
	
	
	public DrawBoard(int size,Board b,MainWindowView View) {


		this.size = size;
		board = b;
		this.view = View;
		
//		setBoard();
		
	}
	
//	private void setBoard(){
//		Point matrixSize;
//		matrixSize = getMatrixSize();
//
//		if (matrixSize == null) {	
//			System.out.println("Matrix is either incorrectly input on the [width]x[height] format\nor it is simply too large.");
//			return;
//		}
//		
//		System.out.println("Width: " + matrixSize.X + "\nHeight: " + matrixSize.Y);
//		board.sizeColumn = matrixSize.X;
//		board.sizeRow = matrixSize.Y;
//	
//	}
//	public Point getMatrixSize() {
//		
//		String lblmatrixSize = view.getLblmatrixSize().getText();
//		
//		view.getLblmatrixSize().setText(lblmatrixSize + view.getComboBox().getSelectedItem().toString());
//		
//		String matrixSize = view.getComboBox().getSelectedItem().toString();
//		
//		if (CheckDataInput.checkMatrixInput(matrixSize)) {
//			
//			String[] parts = matrixSize.split("x");
//			
//			int width = Integer.parseInt(parts[0]);
//			
//			int height = Integer.parseInt(parts[1]);
//			
//			//Won't allow for grids with width or height higher than 100
//			if (width > 100 || height > 100)
//				return null;
//			
//			
//			Point size = new Point(width,height);
//			
//			return size;
//		}
//		
//
//		return null;
//	}
	
	@Override
	public void paintComponent(Graphics g) {


		
		super.paintComponent(g);
		for(int i = 0; i < board.sizeColumn; i++)
			for(int j = 0; j < board.sizeRow; j++) {
				
				if(view.getRdbtnGrid().isSelected()) {
					g.setColor(Color.black);
					g.drawRect(i * this.size,  j * this.size, this.size, this.size);
				}

				
				Cell cell = board.GetCell(i, j);
				
				g.setColor(Color.black);
				if (cell.isAlive()) {
					g.fillRect(i * this.size,  j * this.size, this.size, this.size);
				}
				repaint();
			}

	}
}
