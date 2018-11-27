package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.GridLayout;


public class MainWindowView {

	private JFrame frame;
	private JButton btnStart;
	private JButton btnPause;
	private JPanel panel;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getBtnStart() {
		return btnStart;
	}

	public void setBtnStart(JButton btnStart) {
		this.btnStart = btnStart;
	}

	public JButton getBtnPause() {
		return btnPause;
	}

	public void setBtnPause(JButton btnPause) {
		this.btnPause = btnPause;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * Create the application.
	 */
	public MainWindowView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Game of Life");
		frame.setBounds(100, 100, 611, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnStart.setBounds(12, 206, 158, 34);
		frame.getContentPane().add(btnStart);
		
		panel = new JPanel(new BorderLayout()); 

		panel.setBounds(0, 0, 503, 173);
		frame.getContentPane().add(panel);

//		DrawBoard drawBoard = new DrawBoard(10,10);
//		
//		panel.add(drawBoard);

		btnPause = new JButton("Pause");
		btnPause.setBounds(12, 251, 117, 25);
		frame.getContentPane().add(btnPause);
		
		frame.setVisible(true);

	}
	
	
	
}
