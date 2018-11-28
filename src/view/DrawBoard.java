/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author thong
 *
 */
public class DrawBoard extends JPanel{

	private final int column;
	private final int row;
	private final int size;

	public int getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}


	public DrawBoard(int column, int row,int size) {
		this.column = column;
		this.row = row;
		this.size = size;

	}
	
	public void paintComponent(Graphics g) {

		for(int i = 0; i < column; i++)
			for(int j = 0; j < row; j++) {
				g.drawRect(i * this.size,  j * this.size, this.size, this.size);
				
//				50 + i * this.size, 20 + j * this.size
			}
		
	}
}
