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
	private JLabel imageLabel = new JLabel(new ImageIcon("C:\\Users\\natsu\\eclipse-workspace\\GUI FINALS\\src\\rsz_university-of-cebu-logo.jpg"));
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
		
		imageLabel.setBounds(10, 10, 265, 80);
		
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
		
		frame.add(imageLabel);
		frame.add(userIDLabel);
		frame.add(passwordLabel);
		frame.add(usernameField);
		frame.add(passwordField);
		frame.add(confirmPassLabel);
		frame.add(confirmPassField);
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
			
			if(userTemp.equals("") || passwordTemp.equals("")) {
				JOptionPane.showMessageDialog(frame, "Do not leave it blank", "ERROR", JOptionPane.ERROR_MESSAGE);
				usernameField.setText("");
				passwordField.setText("");
				confirmPassField.setText("");
			}
			else if(userTemp.contains(" ") || passwordTemp.contains(" ")) {
				JOptionPane.showMessageDialog(frame, "No spaces allowed", "ERROR", JOptionPane.ERROR_MESSAGE);
				usernameField.setText("");
				passwordField.setText("");
				confirmPassField.setText("");
			}
			else if(passwordTemp.length() < 8) {
				JOptionPane.showMessageDialog(frame, "Your password must be at least 8 characters long", "ERROR", JOptionPane.ERROR_MESSAGE);
				passwordField.setText("");
				confirmPassField.setText("");
			}
			else if(!passwordTemp.equals(confirmPasswordTemp)) {
				JOptionPane.showMessageDialog(frame, "Your password do not match", "ERROR", JOptionPane.ERROR_MESSAGE);
				confirmPassField.setText("");
			}
			else {
				new LoginWindow().addLoginCreds(userTemp, passwordTemp);
				frame.dispose();
			}
		}
		
		if (e.getSource() == resetButton) {
			usernameField.setText("");
			passwordField.setText("");
			confirmPassField.setText("");
		}
	}
}
