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

	private Board board;
	private MainWindowView view;
	
	
	public DrawBoard(Board b,MainWindowView View) {
		board = b;
		this.view = View;

	}
	/**
	 * Fill a cell with black if it is alive
	 */
	@Override
	public void paintComponent(Graphics g) {

		int size = board.size;
		
		super.paintComponent(g);
		for(int i = 0; i < board.sizeColumn; i++)
			for(int j = 0; j < board.sizeRow; j++) {
				
				if(view.getRdbtnGrid().isSelected()) {
					g.setColor(Color.black);
					g.drawRect(i * size,  j * size, size, size);
				}

				
				Cell cell = board.GetCell(i, j);
				
				g.setColor(Color.black);
				if (cell.isAlive()) {
					g.fillRect(i * size,  j * size, size, size);
				}
				repaint();
			}

	}
}
