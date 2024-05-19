import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DashboardWindow implements ActionListener{

	JFrame frame = new JFrame("Dashboard");
	JLabel studentNameLabel = new JLabel("Student name: ");
	JTextField studentNameField = new JTextField();
	JButton studentNameButton = new JButton("Add Student");
	JButton studentEditButton = new JButton("Edit Student");
	JPanel northPanel = new JPanel();
	
	JLabel nameLabel = new JLabel("Selected Student Name: ");
	JTextField nameField = new JTextField(15);
	JLabel ageLabel = new JLabel("Age: ");
	JTextField ageField = new JTextField(15);
	JLabel addressLabel = new JLabel("Address: ");
	JTextField addressField = new JTextField(15);
	JLabel courseLabel = new JLabel("Course: ");
	JTextField courseField = new JTextField(15);
	JLabel yearLevelLabel = new JLabel("Year Level: "); 
	JComboBox yearLevelComboBox = new JComboBox(new String[]{"No Year Level", "1st Year", "2nd Year", "3rd Year", "4th Year"});;
	JButton resetNameButton = new JButton("Delete");
	JButton resetAgeButton = new JButton("Delete");
	JButton resetAddressButton = new JButton("Delete");
	JButton resetCourseButton = new JButton("Delete");
	JButton resetYearLevelButton = new JButton("Delete");
	JButton updateButton = new JButton("Update changes");
	JPanel leftPanel = new JPanel();
	
	JTable studentTable = new JTable();
	DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Name", "Age", "Address", "Course", "Year Level"}, 0);
	JPanel centerPanel = new JPanel();
	
	int editSelectedRow;
	
	public DashboardWindow() {

		frame.setLayout(new BorderLayout());
		
		studentNameField.setPreferredSize(new Dimension(275, 25));
		studentNameButton.setPreferredSize(new Dimension(125, 25));
		studentNameButton.setBackground(new Color(201, 233, 255));
		studentNameButton.setFocusable(false);
		studentNameButton.addActionListener(this);
		studentEditButton.setPreferredSize(new Dimension(125, 25));
		studentEditButton.setBackground(new Color(252, 255, 168));
		studentEditButton.setFocusable(false);
		studentEditButton.addActionListener(this);
		
		northPanel.setBackground(Color.WHITE);
		northPanel.setBorder(BorderFactory.createEtchedBorder());
		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		northPanel.add(studentNameLabel);
		northPanel.add(studentNameField);
		northPanel.add(studentNameButton);
		northPanel.add(studentEditButton);
		frame.add(northPanel, BorderLayout.NORTH);
		
		nameField.setEnabled(false);
		ageField.setEnabled(false);
		addressField.setEnabled(false);
		courseField.setEnabled(false);
		yearLevelComboBox.setEnabled(false);
		resetNameButton.setEnabled(false);
		resetAgeButton.setEnabled(false);
		resetAddressButton.setEnabled(false);
		resetCourseButton.setEnabled(false);
		resetYearLevelButton.setEnabled(false);
		updateButton.setEnabled(false);
		
		nameLabel.setPreferredSize(new Dimension(160, 20));
		resetNameButton.setPreferredSize(new Dimension(80, 25));
		resetNameButton.setBackground(new Color(255, 51, 95));
		resetNameButton.setFocusable(false);
		resetNameButton.addActionListener(this);
		ageLabel.setPreferredSize(new Dimension(160, 20));
		resetAgeButton.setPreferredSize(new Dimension(80, 25));
		resetAgeButton.setBackground(new Color(255, 51, 95));
		resetAgeButton.setFocusable(false);
		resetAgeButton.addActionListener(this);
		addressLabel.setPreferredSize(new Dimension(160, 20));
		resetAddressButton.setPreferredSize(new Dimension(80, 25));
		resetAddressButton.setBackground(new Color(255, 51, 95));
		resetAddressButton.setFocusable(false);
		resetAddressButton.addActionListener(this);
		courseLabel.setPreferredSize(new Dimension(160, 20));
		resetCourseButton.setPreferredSize(new Dimension(80, 25));
		resetCourseButton.setBackground(new Color(255, 51, 95));
		resetCourseButton.setFocusable(false);
		resetCourseButton.addActionListener(this);
		yearLevelLabel.setPreferredSize(new Dimension(160, 20));
		yearLevelComboBox.setPreferredSize(new Dimension(150, 25));
		resetYearLevelButton.setPreferredSize(new Dimension(80, 25));
		resetYearLevelButton.setBackground(new Color(255, 51, 95));
		resetYearLevelButton.setFocusable(false);
		resetYearLevelButton.addActionListener(this);
		updateButton.setPreferredSize(new Dimension(175, 50));
		updateButton.setBackground(new Color(201, 233, 255));
		updateButton.setFocusable(false);
		updateButton.addActionListener(this);
		
		leftPanel.setBackground(Color.WHITE);
		leftPanel.setPreferredSize(new Dimension(200, 600));
		leftPanel.setBorder(BorderFactory.createEtchedBorder());
		leftPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		leftPanel.add(nameLabel);
		leftPanel.add(nameField);
		leftPanel.add(resetNameButton);
		leftPanel.add(ageLabel);
		leftPanel.add(ageField);
		leftPanel.add(resetAgeButton);
		leftPanel.add(addressLabel);
		leftPanel.add(addressField);
		leftPanel.add(resetAddressButton);
		leftPanel.add(courseLabel);
		leftPanel.add(courseField);
		leftPanel.add(resetCourseButton);
		leftPanel.add(yearLevelLabel);
		leftPanel.add(yearLevelComboBox);
		leftPanel.add(resetYearLevelButton);
		leftPanel.add(updateButton);
		frame.add(leftPanel, BorderLayout.WEST);
		
		centerPanel.setLayout(new BorderLayout());
		studentTable.setModel(tableModel);
		studentTable.setBackground(Color.WHITE);
		centerPanel.add(new JScrollPane(studentTable), BorderLayout.CENTER);
		studentTable.getColumnModel().getColumn(0).setPreferredWidth(175);
		studentTable.getColumnModel().getColumn(1).setPreferredWidth(50);
		studentTable.getColumnModel().getColumn(2).setPreferredWidth(250);
		studentTable.getColumnModel().getColumn(3).setPreferredWidth(75);
		studentTable.getColumnModel().getColumn(4).setPreferredWidth(75);
		tableModel.addRow(new Object[]{"Raphael Bariquit", "19", "Zapatera, Cebu City", "BSIT", "1st Year"});
		tableModel.addRow(new Object[]{"Krist Dave Ferrer", "21", "Gun-ob, Lapu-Lapu City", "BSIT", "1st Year"});
		tableModel.addRow(new Object[]{"Lance Eigenman Omega", "19", "Labangon, Cebu City", "BSIT", "1st Year"});
		tableModel.addRow(new Object[]{"RJ Roble", "19", "Sambag 1, Cebu city", "BSIT", "1st Year"});
		frame.add(centerPanel, BorderLayout.CENTER);
		
		frame.setSize(950, 550);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == studentNameButton) {
			
			String studentName = studentNameField.getText();
			boolean isNameExisted = false;
			
			for(int i = 0; i < tableModel.getColumnCount()-1; i++) {
				if(studentName.contains(tableModel.getValueAt(i, 0).toString())) {
					isNameExisted = true; 
				}
			}
			if(studentName.isBlank()) {
				JOptionPane.showMessageDialog(frame, "Student name is empty. Try again", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if(isNameExisted) {
				JOptionPane.showMessageDialog(frame, "Student name is already existed", "ERROR", JOptionPane.ERROR_MESSAGE);
				studentNameField.setText("");
			}
			else {
				tableModel.addRow(new Object[]{studentName, "", "", "", "No Year Level"});
				studentNameField.setText("");
			}
			
		}
		if(e.getSource() == studentEditButton) {
			
			editSelectedRow = studentTable.getSelectedRow();
			
			if(editSelectedRow < 0) {
				JOptionPane.showMessageDialog(frame, "Please select the student you want to edit", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				nameField.setEnabled(true);
				ageField.setEnabled(true);
				addressField.setEnabled(true);
				courseField.setEnabled(true);
				yearLevelComboBox.setEnabled(true);
				resetNameButton.setEnabled(true);
				resetAgeButton.setEnabled(true);
				resetAddressButton.setEnabled(true);
				resetCourseButton.setEnabled(true);
				resetYearLevelButton.setEnabled(true);
				updateButton.setEnabled(true);
				
				nameField.setText(tableModel.getValueAt(editSelectedRow, 0).toString());
				ageField.setText(tableModel.getValueAt(editSelectedRow, 1).toString());
				addressField.setText(tableModel.getValueAt(editSelectedRow, 2).toString());
				courseField.setText(tableModel.getValueAt(editSelectedRow, 3).toString());
				
				for(int i = 0; i < yearLevelComboBox.getItemCount(); i++) {
					if(yearLevelComboBox.getItemAt(i).toString().contains(tableModel.getValueAt(editSelectedRow, 4).toString())) {
						yearLevelComboBox.setSelectedIndex(i);
					}
				}
				
			}
		}
		if(e.getSource() == resetNameButton) {
			
			if(nameField.getText().isBlank()) {
				JOptionPane.showMessageDialog(frame, "Please select the student you want to edit", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				nameField.setText("");
			}
		}
		if(e.getSource() == resetAgeButton) {
			ageField.setText("");
		}
		if(e.getSource() == resetAddressButton) {
			addressField.setText("");
		}
		if(e.getSource() == resetCourseButton) {
			courseField.setText("");
		}
		if(e.getSource() == resetYearLevelButton) {
			yearLevelComboBox.setSelectedIndex(0);
		}
		if(e.getSource() == updateButton) {
			
			boolean isAgeValid = false;

			for(char c: ageField.getText().toCharArray()) {
				if(Character.isDigit(c)) {
					isAgeValid = true;
				}
				else if(Character.isLetter(c)) {
					isAgeValid = false;
					break;
				}
			}
			if(ageField.getText().isBlank()) {
				isAgeValid = true;
			}
			
			if(nameField.getText().isBlank()) {
				JOptionPane.showMessageDialog(frame, "Selected student name can't be left blank", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if(!isAgeValid) {
				JOptionPane.showMessageDialog(frame, "Student's age must be in numerical", "ERROR", JOptionPane.ERROR_MESSAGE);
				ageField.setText("");
			}
			else {
				String editedInfo = "\n\nName: " + nameField.getText() +
									"\nAge: " + ageField.getText() +
									"\nAddress: " + addressField.getText() +
									"\nCourse: " + courseField.getText() +
									"\nYear Level: " + yearLevelComboBox.getSelectedItem().toString();
				
				int confirmResult = JOptionPane.showConfirmDialog(frame, "Are you sure you want to make these changes? " + editedInfo, "Confirmation", JOptionPane.YES_NO_OPTION);
				if(confirmResult == JOptionPane.YES_OPTION) {
					tableModel.setValueAt(nameField.getText(), editSelectedRow, 0);
					tableModel.setValueAt(ageField.getText(), editSelectedRow, 1);
					tableModel.setValueAt(addressField.getText(), editSelectedRow, 2);
					tableModel.setValueAt(courseField.getText(), editSelectedRow, 3);
					tableModel.setValueAt(yearLevelComboBox.getSelectedItem().toString(), editSelectedRow, 4);
					
					nameField.setEnabled(false);
					ageField.setEnabled(false);
					addressField.setEnabled(false);
					courseField.setEnabled(false);
					yearLevelComboBox.setEnabled(false);
					resetNameButton.setEnabled(false);
					resetAgeButton.setEnabled(false);
					resetAddressButton.setEnabled(false);
					resetCourseButton.setEnabled(false);
					resetYearLevelButton.setEnabled(false);
					updateButton.setEnabled(false);
				}
			}
		}
	}
}
