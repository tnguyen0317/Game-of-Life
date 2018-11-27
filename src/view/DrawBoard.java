/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Point;
/**
 * @author thong
 *
 */
public class DrawBoard extends JPanel{

	private final int column;
	private final int row;
	private final int size;
	private final Point position;

	public DrawBoard(int column, int row,int size,Point position) {
		this.column = column;
		this.row = row;
		this.size = size;
		this.position = position;
		
	}
	
	public void paintComponent(Graphics g) {

		int column = 10;
		int row = 10;
		for(int i = 0; i < column; i++)
			for(int j = 0; j < row; j++) {
				g.drawRect((int)position.getX() + i * this.size,(int)position.getY() + j * this.size, this.size, this.size);
//				50 + i * this.size, 20 + j * this.size
			}
		
	}
}
