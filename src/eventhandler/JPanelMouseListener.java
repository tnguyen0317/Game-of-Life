/**
 * 
 */
package eventhandler;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.MainWindowView;
import model.Board;
import model.Game;

/**
 * @author thong
 *
 */
public class JPanelMouseListener implements MouseListener {

	private Board board;
	
	public JPanelMouseListener(Board b){
		board = b;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < board.sizeColumn; i++)
			for(int j = 0; j < board.sizeRow; j++) {
				if(board.GetCell(i, j).getBoundary().contains(new Point(e.getX(),e.getX()))) {
					board.GetCell(i, j).setAlive(true);
					System.out.println("X: " + e.getX() + " Y: " + e.getY());
				}

				else
					board.GetCell(i, j).setAlive(false);
			}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	
}
