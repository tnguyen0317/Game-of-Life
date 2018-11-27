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

//	private final int column;
//	private final int row;
//	
//	public DrawBoard(int column, int row) {
//		this.column = column;
//		this.row = row;
//		
//	}
//	
	public void paintComponent(Graphics g) {
		int size = 34;
	private final int column;
	private final int row;
	private final int size;
	private final Point position;

	public DrawBoard(int column, int row,int size,Point position) {
		this.column = column;
		this.row = row;
		this.size = size;
		this.position = position;
		
		int column = 10;
		int row = 10;
		for(int i = 0; i < column; i++)
			for(int j = 0; j < row; j++) {
//				Rectangle board = new Rectangle(50 + i * size, 20 + j * size, size,size);
				g.drawRect(50 + i * size, 20 + j * size, size, size);
//			     g.setColor(Color.red);
//			     g.drawLine(20, 20, 20, 120);
//			 
//			     //horizontal line
//			     g.setColor(Color.green);
//			     g.drawLine(20, 20, 120, 20);
//			 
//			     //diagonal line 
//			     g.setColor(Color.blue);
//			     g.drawLine(20, 20, 120, 120);
			}
		
	}
	public static void main(String[] args) {
//	    JFrame.setDefaultLookAndFeelDecorated(true);
	    JFrame frame = new JFrame("Draw Line");
//	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBackground(Color.blue);
	    frame.setSize(640, 480);
	 
	    DrawBoard panel = new DrawBoard();
	 
	    frame.add(panel);
	 
	    frame.setVisible(true);
	  }
}
