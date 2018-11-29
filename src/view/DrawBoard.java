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

		for(int i = 0; i < column; i++)
			for(int j = 0; j < row; j++) {
				g.drawRect(i * this.size,  j * this.size, this.size, this.size);
				
//				50 + i * this.size, 20 + j * this.size
			}
		
	}
}
