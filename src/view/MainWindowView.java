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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;


public class MainWindowView {

	private JFrame frame;
	private JButton btnStart;
	private JButton btnPause;
	private JPanel panel;
	private JLabel lblGeneration;
	private JRadioButton rdbtnGrid;
	private JLabel lblmatrixSize;
	private JTextField textFieldWidth;
	private JTextField textFieldHeight;
	private JButton btnSetMatrix;
	private JButton btnClear;
	private JTextField textFieldCellSize;
	private JButton btnSetCellSize;
	private JTextField textFieldInitProbRate;
	private JTextField textFieldUpdateRate;
	private JButton buttonReset;
	private JRadioButton rdbtnEnableInitializationProbability;

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

	public JLabel getLblGeneration() {
		return lblGeneration;
	}

	public void setLblGeneration(JLabel lblGeneration) {
		this.lblGeneration = lblGeneration;
	}

	public JRadioButton getRdbtnGrid() {
		return rdbtnGrid;
	}

	public void setRdbtnGrid(JRadioButton rdbtnGrid) {
		this.rdbtnGrid = rdbtnGrid;
	}

	public JLabel getLblmatrixSize() {
		return lblmatrixSize;
	}

	public void setLblmatrixSize(JLabel lblmatrixSize) {
		this.lblmatrixSize = lblmatrixSize;
	}

	public JTextField getTextFieldWidth() {
		return textFieldWidth;
	}

	public void setTextFieldWidth(JTextField textFieldWidth) {
		this.textFieldWidth = textFieldWidth;
	}

	public JTextField getTextFieldHeight() {
		return textFieldHeight;
	}

	public void setTextFieldHeight(JTextField textFieldHeight) {
		this.textFieldHeight = textFieldHeight;
	}

	public JButton getBtnSetMatrix() {
		return btnSetMatrix;
	}

	public void setBtnSetMatrix(JButton btnSetMatrix) {
		this.btnSetMatrix = btnSetMatrix;
	}

	public JButton getBtnClear() {
		return btnClear;
	}

	public void setBtnClear(JButton btnClear) {
		this.btnClear = btnClear;
	}
	public JTextField getTextFieldCellSize() {
		return textFieldCellSize;
	}

	public void setTextFieldCellSize(JTextField textFieldCellSize) {
		this.textFieldCellSize = textFieldCellSize;
	}

	public JButton getBtnSetCellSize() {
		return btnSetCellSize;
	}

	public void setBtnSetCellSize(JButton btnSetCellSize) {
		this.btnSetCellSize = btnSetCellSize;
	}

	public JTextField getTextFieldInitProbRate() {
		return textFieldInitProbRate;
	}

	public void setTextFieldInitProbRate(JTextField textFieldInitProbRate) {
		this.textFieldInitProbRate = textFieldInitProbRate;
	}

	public JTextField getTextFieldUpdateRate() {
		return textFieldUpdateRate;
	}

	public void setTextFieldUpdateRate(JTextField textFieldUpdateRate) {
		this.textFieldUpdateRate = textFieldUpdateRate;
	}

	public JButton getButtonReset() {
		return buttonReset;
	}

	public void setButtonReset(JButton buttonReset) {
		this.buttonReset = buttonReset;
	}

	public JRadioButton getRdbtnEnableInitializationProbability() {
		return rdbtnEnableInitializationProbability;
	}

	public void setRdbtnEnableInitializationProbability(JRadioButton rdbtnEnableInitializationProbability) {
		this.rdbtnEnableInitializationProbability = rdbtnEnableInitializationProbability;
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
		frame.setBounds(100, 100, 935, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnStart = new JButton("Start");

		btnStart.setBounds(10, 413, 158, 43);
		frame.getContentPane().add(btnStart);
		
		panel = new JPanel(new BorderLayout()); 

		panel.setBounds(0, 0, 919, 402);
		frame.getContentPane().add(panel);

		btnPause = new JButton("Pause");
		btnPause.setBounds(10, 460, 158, 43);
		frame.getContentPane().add(btnPause);
		
		lblGeneration = new JLabel("Generation: 0");
		lblGeneration.setBounds(338, 413, 152, 14);
		frame.getContentPane().add(lblGeneration);
		
		rdbtnGrid = new JRadioButton("Grid");
		rdbtnGrid.setSelected(true);
		rdbtnGrid.setBounds(338, 433, 53, 23);
		frame.getContentPane().add(rdbtnGrid);
		

		String[] matrixSizes = {
				"61x26",
				"10x10",
				"11x11",
				"12x12",
				"53x32"
		};
		JLabel selectSize = new JLabel("Select matrix size");
		
		lblmatrixSize = new JLabel("Current size: ");
		lblmatrixSize.setBounds(503, 413, 136, 14);
		frame.getContentPane().add(lblmatrixSize);
		
		textFieldWidth = new JTextField();
		textFieldWidth.setBounds(671, 413, 28, 20);
		frame.getContentPane().add(textFieldWidth);
		textFieldWidth.setColumns(10);
		
		textFieldHeight = new JTextField();
		textFieldHeight.setColumns(10);
		textFieldHeight.setBounds(671, 444, 28, 20);
		frame.getContentPane().add(textFieldHeight);
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(617, 427, 13, 14);
		frame.getContentPane().add(lblX);
		
		btnSetMatrix = new JButton("Set");

		btnSetMatrix.setBounds(671, 470, 66, 23);
		frame.getContentPane().add(btnSetMatrix);
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(174, 413, 158, 43);
		frame.getContentPane().add(btnClear);
		
		textFieldCellSize = new JTextField();
		textFieldCellSize.setBounds(781, 410, 35, 20);
		frame.getContentPane().add(textFieldCellSize);
		textFieldCellSize.setColumns(10);
		
		btnSetCellSize = new JButton("Set");
		btnSetCellSize.setBounds(826, 413, 66, 23);
		frame.getContentPane().add(btnSetCellSize);
		
		textFieldInitProbRate = new JTextField();
		textFieldInitProbRate.setColumns(10);
		textFieldInitProbRate.setBounds(781, 436, 35, 20);
		frame.getContentPane().add(textFieldInitProbRate);
		
		textFieldUpdateRate = new JTextField();
		textFieldUpdateRate.setColumns(10);
		textFieldUpdateRate.setBounds(781, 471, 35, 20);
		frame.getContentPane().add(textFieldUpdateRate);
		
		buttonReset = new JButton("Reset");
		buttonReset.setBounds(174, 460, 158, 43);
		frame.getContentPane().add(buttonReset);
		
		rdbtnEnableInitializationProbability = new JRadioButton("Enable initialization probability rate");
		rdbtnEnableInitializationProbability.setSelected(false);
		rdbtnEnableInitializationProbability.setBounds(338, 460, 197, 23);
		frame.getContentPane().add(rdbtnEnableInitializationProbability);
		
		
		frame.setVisible(true);

	}
}
