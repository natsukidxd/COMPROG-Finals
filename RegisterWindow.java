import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterWindow implements ActionListener{
	
	private JFrame frame = new JFrame("Registration");
	private JLabel ucLabel = new JLabel(new ImageIcon("C:\\Users\\natsu\\eclipse-workspace\\GUI FINALS\\src\\uc-logo.jpg"));
	private JLabel ccsLabel = new JLabel(new ImageIcon("C:\\Users\\natsu\\eclipse-workspace\\GUI FINALS\\src\\ccs-logo.jpg"));
	private JButton registerButton = new JButton("REGISTER");
	private JButton resetButton = new JButton("RESET");
	private JTextField usernameField = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private JPasswordField confirmPassField = new JPasswordField();
	private JLabel userIDLabel = new JLabel("New username");
	private JLabel passwordLabel = new JLabel("New password");
	private JLabel confirmPassLabel = new JLabel("Confirm password");
	private JButton loginButton = new JButton("Already have an account?");
	
	public RegisterWindow() {
		
		frame.setLayout(null);
		
		ucLabel.setBounds(5, 15, 150, 80);
		ccsLabel.setBounds(130, 5, 150, 95);
		
		userIDLabel.setBounds(25, 100, 100, 25);
		usernameField.setBounds(25, 125, 235, 25);
		usernameField.setBackground(new Color(247, 253, 255));
		
		passwordLabel.setBounds(25, 160, 100, 25);
		passwordField.setBounds(25, 185, 235, 25);
		passwordField.setBackground(new Color(247, 253, 255));
		
		confirmPassLabel.setBounds(25, 220, 125, 25);
		confirmPassField.setBounds(25, 245, 235, 25);
		confirmPassField.setBackground(new Color(247, 253, 255));
		
		registerButton.setBounds(25, 300, 110, 25);
		registerButton.setBackground(new Color(51, 173, 255));
		registerButton.setFocusable(false);
		registerButton.addActionListener(this);
		
		resetButton.setBounds(150, 300, 110, 25);
		resetButton.setBackground(new Color(255, 51, 95));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		loginButton.setBounds(25, 345, 235, 25);
		loginButton.setBackground(new Color(201, 233, 255));
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		frame.add(ucLabel);
		frame.add(ccsLabel);
		frame.add(userIDLabel);
		frame.add(passwordLabel);
		frame.add(usernameField);
		frame.add(passwordField);
		frame.add(confirmPassLabel);
		frame.add(confirmPassField);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(registerButton);
		
		frame.getRootPane().setDefaultButton(registerButton);
		frame.getContentPane().setBackground(Color.white);
		frame.setSize(300, 450);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == loginButton) {
			frame.dispose();
			new LoginWindow();
		}
		
		if(e.getSource() == registerButton) {
			
			String userTemp = usernameField.getText();
			String passwordTemp = String.valueOf(passwordField.getPassword());
			String confirmPasswordTemp = String.valueOf(confirmPassField.getPassword());
			boolean hasLetters = false;
			boolean hasDigits = false;
			
			for(char c : passwordTemp.toCharArray()) {
				if(Character.isLetter(c)) {
					hasLetters = true;
				}
				if(Character.isDigit(c)) {
					hasDigits = true;
				}
			}
			
			if(userTemp.isBlank() || passwordTemp.isBlank()) {
				JOptionPane.showMessageDialog(frame, "Fields are blank", "ERROR", JOptionPane.ERROR_MESSAGE);
				usernameField.setText("");
				usernameField.requestFocusInWindow();
				passwordField.setText("");
				confirmPassField.setText("");
			}
			else if(userTemp.contains(" ") || passwordTemp.contains(" ")) {
				JOptionPane.showMessageDialog(frame, "Fields contain spaces", "ERROR", JOptionPane.ERROR_MESSAGE);
				usernameField.setText("");
				usernameField.requestFocusInWindow();
				passwordField.setText("");
				confirmPassField.setText("");
			}
			else if(passwordTemp.length() < 8) {
				JOptionPane.showMessageDialog(frame, "Your password must be at least 8 characters long", "ERROR", JOptionPane.ERROR_MESSAGE);
				passwordField.setText("");
				passwordField.requestFocusInWindow();
				confirmPassField.setText("");
			}
			else if(!hasLetters || !hasDigits) {
				JOptionPane.showMessageDialog(frame, "Your password must be in alphanumeric", "ERROR", JOptionPane.ERROR_MESSAGE);
				passwordField.setText("");
				passwordField.requestFocusInWindow();
				confirmPassField.setText("");
			}
			else if(!passwordTemp.equals(confirmPasswordTemp)) {
				JOptionPane.showMessageDialog(frame, "Your password do not match", "ERROR", JOptionPane.ERROR_MESSAGE);
				confirmPassField.setText("");
				confirmPassField.requestFocusInWindow();
			}
			else {
				new LoginWindow().addLoginCreds(userTemp, passwordTemp);
				frame.dispose();
			}
		}
		
		if (e.getSource() == resetButton) {
			usernameField.setText("");
			usernameField.requestFocusInWindow();
			passwordField.setText("");
			confirmPassField.setText("");
		}
	}
}
