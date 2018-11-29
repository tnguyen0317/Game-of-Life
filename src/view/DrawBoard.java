/**
 * 
 */
package view;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Board;
import model.Cell;

/**
 * @author thong
 *
 */
public class DrawBoard extends JPanel{


	private final int size;
	private Board board;

	public DrawBoard(int size,Board b) {

		this.size = size;
		board = b;
	}
	
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		for(int i = 0; i < board.sizeColumn; i++)
			for(int j = 0; j < board.sizeRow; j++) {
				g.setColor(Color.black);
				g.drawRect(i * this.size,  j * this.size, this.size, this.size);
				
				Cell cell = board.GetCell(i, j);
				
				
//				System.out.println("x: " + i + " y: " + j);
				g.setColor(Color.MAGENTA);
				if (cell.isAlive()) {
					g.fillRect(i * this.size,  j * this.size, this.size, this.size);
//					repaint();
				}
				repaint();
			}

	}
}
