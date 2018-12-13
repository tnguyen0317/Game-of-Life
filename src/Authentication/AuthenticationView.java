package Authentication;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class AuthenticationView {

	private JFrame frame;
	private JTextField textFieldUserName;
	private JLabel lblTitle;
	private JLabel lblUserName;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JPasswordField passwordField;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTextFieldUserName() {
		return textFieldUserName;
	}

	public void setTextFieldUserName(JTextField textFieldUserName) {
		this.textFieldUserName = textFieldUserName;
	}

	public JLabel getLblTitle() {
		return lblTitle;
	}

	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}

	public JLabel getLblUserName() {
		return lblUserName;
	}

	public void setLblUserName(JLabel lblUserName) {
		this.lblUserName = lblUserName;
	}

	public JLabel getLblPassword() {
		return lblPassword;
	}

	public void setLblPassword(JLabel lblPassword) {
		this.lblPassword = lblPassword;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					UserDB user = new UserDB();
					AuthenticationView window = new AuthenticationView();

					AuthenticationController controller = new AuthenticationController(window,user);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AuthenticationView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(103, 130, 200, 20);
		frame.getContentPane().add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		lblTitle = new JLabel("Conway's Game of Life");
		lblTitle.setFont(new Font("Monospaced", Font.PLAIN, 27));
		lblTitle.setBounds(34, 11, 351, 108);
		frame.getContentPane().add(lblTitle);
		
		lblUserName = new JLabel("Username:");
		lblUserName.setBounds(34, 133, 59, 14);
		frame.getContentPane().add(lblUserName);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(34, 164, 59, 14);
		frame.getContentPane().add(lblPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(155, 192, 96, 44);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(103, 161, 200, 20);
		frame.getContentPane().add(passwordField);
		
		
		frame.setVisible(true);
	}
}
