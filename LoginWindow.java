import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginWindow implements ActionListener{

	private JFrame frame = new JFrame("Login");
	private JLabel ucLabel = new JLabel(new ImageIcon("C:\\Users\\natsu\\eclipse-workspace\\GUI FINALS\\src\\uc-logo.jpg"));
	private JLabel ccsLabel = new JLabel(new ImageIcon("C:\\Users\\natsu\\eclipse-workspace\\GUI FINALS\\src\\ccs-logo.jpg"));
	private JButton loginButton = new JButton("LOGIN");
	private JButton resetButton = new JButton("RESET");
	private JTextField usernameField = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private JLabel userIDLabel = new JLabel("Username");
	private JLabel passwordLabel = new JLabel("Password");
	private JButton registerButton = new JButton("No account? Register");
	private HashMap<String, String> loginCreds = new HashMap<String, String>();

	public LoginWindow() {
		
		loginCreds.put("admin", "admin");
		
		frame.setLayout(null);
		
		ucLabel.setBounds(5, 15, 150, 80);
		ccsLabel.setBounds(130, 5, 150, 95);
		
		userIDLabel.setBounds(25, 100, 75, 25);
		usernameField.setBounds(25, 125, 235, 25);
		usernameField.setBackground(new Color(247, 253, 255));
		
		passwordLabel.setBounds(25, 175, 75, 25);
		passwordField.setBounds(25, 200, 235, 25);
		passwordField.setBackground(new Color(247, 253, 255));
		
		loginButton.setBounds(25, 275, 110, 25);
		loginButton.setBackground(new Color(51, 173, 255));
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(150, 275, 110, 25);
		resetButton.setBackground(new Color(255, 51, 95));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		registerButton.setBounds(25, 315, 235, 25);
		registerButton.setBackground(new Color(201, 233, 255));
		registerButton.setFocusable(false);
		registerButton.addActionListener(this);
		
		frame.add(ucLabel);
		frame.add(ccsLabel);
		frame.add(userIDLabel);
		frame.add(passwordLabel);
		frame.add(usernameField);
		frame.add(passwordField);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(registerButton);
		
		frame.getContentPane().setBackground(Color.white);
		frame.setSize(300, 450);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	public void addLoginCreds(String username, String password) {
		
		loginCreds.put(username, password);
		JOptionPane.showMessageDialog(frame, "You are now registered to the system. Please login to continue", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == registerButton) {
			
			frame.setVisible(false);
			new RegisterWindow();
		}
		
		if(e.getSource() == loginButton) {
			
			String userTemp = usernameField.getText();
			String passwordTemp = String.valueOf(passwordField.getPassword());
			
			if(userTemp.isBlank() || passwordTemp.isBlank()) {
				JOptionPane.showMessageDialog(frame, "Fields are blank. Try again", "ERROR", JOptionPane.ERROR_MESSAGE);
				usernameField.setText("");
				passwordField.setText("");
			}
			else if(userTemp.contains(" ")) {
				JOptionPane.showMessageDialog(frame, "Invalid username. No spaces allowed", "ERROR", JOptionPane.ERROR_MESSAGE);
				usernameField.setText("");
				passwordField.setText("");
			}
			else if(passwordTemp.contains(" ")) {
				JOptionPane.showMessageDialog(frame, "Invalid password. No spaces allowed", "ERROR", JOptionPane.ERROR_MESSAGE);
				passwordField.setText("");
			}
			else {
				
				if(loginCreds.containsKey(userTemp)) {
					
					if(loginCreds.get(userTemp).equals(passwordTemp)) {
						JOptionPane.showMessageDialog(frame, "Login Successful!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						new DashboardWindow();
					}
					else {
						JOptionPane.showMessageDialog(frame, "Incorrect password", "ERROR", JOptionPane.ERROR_MESSAGE);
						passwordField.setText("");
					}
				}
				else {
					JOptionPane.showMessageDialog(frame, "Username was not found", "ERROR", JOptionPane.ERROR_MESSAGE);
					usernameField.setText("");
					passwordField.setText("");
				}
			}
		}
		
		if (e.getSource() == resetButton) {
			usernameField.setText("");
			passwordField.setText("");
		}
	}
}
