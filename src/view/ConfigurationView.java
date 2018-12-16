/**
 * 
 */
package view;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author thong
 *
 */
public class ConfigurationView {
	
	private JFrame frame;
	private JTextField textFieldWidth;
	private JTextField textFieldHeight;
	private JTextField textFieldSize;
	private JTextField textFieldInitProbRate;
	private JButton btnSave;

	public ConfigurationView() {
		Initialize();
		
	}

	private void Initialize() {
		frame = new JFrame("Configurations");
		frame.setBounds(100, 100, 390, 383);
//		frame.setDefaultCloseOperation(JFr);
		frame.getContentPane().setLayout(null);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(106, 273, 143, 44);
		frame.getContentPane().add(btnSave);
		
		JLabel lblSetMatrixSize = new JLabel("Set matrix size:");
		lblSetMatrixSize.setBounds(25, 11, 82, 14);
		frame.getContentPane().add(lblSetMatrixSize);
		
		JLabel lblSetCellSize = new JLabel("Set cell size:");
		lblSetCellSize.setBounds(25, 95, 82, 14);
		frame.getContentPane().add(lblSetCellSize);
		
		textFieldWidth = new JTextField();
		textFieldWidth.setColumns(10);
		textFieldWidth.setBounds(61, 33, 28, 20);
		frame.getContentPane().add(textFieldWidth);
		
		textFieldHeight = new JTextField();
		textFieldHeight.setColumns(10);
		textFieldHeight.setBounds(61, 64, 28, 20);
		frame.getContentPane().add(textFieldHeight);
		
		textFieldSize = new JTextField();
		textFieldSize.setColumns(10);
		textFieldSize.setBounds(61, 120, 28, 20);
		frame.getContentPane().add(textFieldSize);
		
		JLabel lblInitializationProbabilityRate = new JLabel("Initialization probability rate:");
		lblInitializationProbabilityRate.setBounds(25, 178, 143, 14);
		frame.getContentPane().add(lblInitializationProbabilityRate);
		
		textFieldInitProbRate = new JTextField();
		textFieldInitProbRate.setColumns(10);
		textFieldInitProbRate.setBounds(140, 203, 28, 20);
		frame.getContentPane().add(textFieldInitProbRate);
		
		JLabel lblWidth = new JLabel("Width:");
		lblWidth.setBounds(25, 36, 46, 14);
		frame.getContentPane().add(lblWidth);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setBounds(25, 67, 46, 14);
		frame.getContentPane().add(lblHeight);
		
		frame.setVisible(true);
		
	}
}
