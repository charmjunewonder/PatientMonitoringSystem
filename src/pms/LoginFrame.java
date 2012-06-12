package pms;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentListener;
import pms.PatientInfo.Gender;

/**
 * LoginFrame of PatientInfo Monitoring System.
 *
 * @author charmjunewonder
 * @version 0.1
 */
public class LoginFrame extends JFrame{
	
	private JLabel addressLabel;
	private JTextField addressTextField;
	private JLabel ageHintLabel;
	private JLabel ageLabel;
	private JTextField ageTextField;
	private JScrollPane conditionScrollPane;
	private ButtonGroup genderButtonGroup;
	private JRadioButton femaleRadioButton;
	private JLabel genderLabel;
	private JLabel heightLabel;
	private JTextField heightTextField;
	private JPanel loginPanel;
	private JRadioButton maleRadioButton;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JButton okButton;
	private JLabel patientNumberLabel;
	private JTextField patientNumberTextField;
	private JLabel specificLabel;
	private JTextArea specificTextArea;
	private JLabel titleLabel;
	private JLabel weightLabel;
	private JTextField weightTextField;
	
	/**
	 * Constructs a login Frame.
	 */
	public LoginFrame(){
		initComponents();
	}
	
	/**
	 * Initialize components. 
	 */
	private void initComponents() {
		loginPanel = new JPanel();
		titleLabel = new JLabel();
		nameLabel = new JLabel();
		addressLabel = new JLabel();
		patientNumberLabel = new JLabel();
		ageHintLabel = new JLabel();
		genderLabel = new JLabel();
		weightLabel = new JLabel();
		heightLabel = new JLabel();
		specificLabel = new JLabel();
		nameTextField = new JTextField();
		addressTextField = new JTextField();
		patientNumberTextField = new JTextField();
		ageTextField = new JTextField();
		weightTextField = new JTextField();
		heightTextField = new JTextField();
		conditionScrollPane = new JScrollPane();
		specificTextArea = new JTextArea();
		genderButtonGroup = new ButtonGroup();
		maleRadioButton = new JRadioButton();
		femaleRadioButton = new JRadioButton();
		okButton = new JButton();
		ageLabel = new JLabel();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new java.awt.Dimension(640, 480));
		setResizable(false);

		loginPanel.setMinimumSize(new java.awt.Dimension(640, 480));
		loginPanel.setPreferredSize(new java.awt.Dimension(640, 480));
		loginPanel.setRequestFocusEnabled(false);
		loginPanel.setLayout(null);

		titleLabel.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
		titleLabel.setText("Patient Monitoring System");
		loginPanel.add(titleLabel);
		titleLabel.setBounds(230, 10, 185, 21);

		nameLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		nameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		nameLabel.setText("Name: ");
		nameLabel.setPreferredSize(new java.awt.Dimension(60, 22));
		loginPanel.add(nameLabel);
		nameLabel.setBounds(10, 50, 170, 20);

		addressLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		addressLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		addressLabel.setText("Address: ");
		loginPanel.add(addressLabel);
		addressLabel.setBounds(10, 80, 170, 20);

		patientNumberLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		patientNumberLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		patientNumberLabel.setText("PatientNumber: ");
		loginPanel.add(patientNumberLabel);
		patientNumberLabel.setBounds(10, 110, 170, 20);

		ageHintLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		ageHintLabel.setText("[1~999]");
		ageHintLabel.setPreferredSize(new java.awt.Dimension(150, 20));
		loginPanel.add(ageHintLabel);
		ageHintLabel.setBounds(470, 140, 150, 20);

		genderLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		genderLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		genderLabel.setText("Gender: ");
		loginPanel.add(genderLabel);
		genderLabel.setBounds(10, 170, 170, 20);

		weightLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		weightLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		weightLabel.setText("Weight: ");
		loginPanel.add(weightLabel);
		weightLabel.setBounds(10, 200, 170, 20);

		heightLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		heightLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		heightLabel.setText("Height: ");
		loginPanel.add(heightLabel);
		heightLabel.setBounds(10, 230, 170, 20);

		specificLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		specificLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		specificLabel.setText("Medical Condition: ");
		loginPanel.add(specificLabel);
		specificLabel.setBounds(10, 260, 170, 20);

		loginPanel.add(nameTextField);
		nameTextField.setBounds(190, 50, 270, 21);

		loginPanel.add(addressTextField);
		addressTextField.setBounds(190, 80, 270, 21);
		loginPanel.add(patientNumberTextField);
		patientNumberTextField.setBounds(190, 110, 270, 21);

		ageTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
		loginPanel.add(ageTextField);
		ageTextField.setBounds(190, 140, 271, 21);
		loginPanel.add(weightTextField);
		weightTextField.setBounds(190, 200, 271, 21);
		loginPanel.add(heightTextField);
		heightTextField.setBounds(190, 230, 271, 21);

		specificTextArea.setColumns(20);
		specificTextArea.setRows(8);
		conditionScrollPane.setViewportView(specificTextArea);

		loginPanel.add(conditionScrollPane);
		conditionScrollPane.setBounds(190, 260, 271, 160);

		maleRadioButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		maleRadioButton.setSelected(true);
		maleRadioButton.setText("Male");
		genderButtonGroup.add(maleRadioButton);

		loginPanel.add(maleRadioButton);
		maleRadioButton.setBounds(240, 170, 60, 25);

		femaleRadioButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		femaleRadioButton.setText("Female");
		genderButtonGroup.add(femaleRadioButton);

		loginPanel.add(femaleRadioButton);
		femaleRadioButton.setBounds(350, 170, 80, 25);

		okButton.setFont(okButton.getFont().deriveFont(okButton.getFont().getSize() + 2f));
		okButton.setText("OK");

		loginPanel.add(okButton);
		okButton.setBounds(550, 440, 70, 25);

		ageLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		ageLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		ageLabel.setText("Age: ");
		ageLabel.setPreferredSize(new java.awt.Dimension(150, 20));
		loginPanel.add(ageLabel);
		ageLabel.setBounds(10, 140, 170, 20);

		getContentPane().add(loginPanel, java.awt.BorderLayout.CENTER);

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int X = (screen.width / 2) - (getWidth() / 2); // Center horizontally.
		int Y = (screen.height / 2) - (getHeight() / 2); // Center vertically.

		setLocation(X, Y);

		pack();
	}
	
	public String getPatientName() {
		return nameTextField.getText();
	}
	
	public String getPatientNumber() {
		return patientNumberTextField.getText();
	}
	
	public String getPatientAddress() {
		return addressTextField.getText();
	}
	
	public String getPatientAge() {
		return ageTextField.getText();
	}
	
	public Gender getPatientGender() {
		if(maleRadioButton.isSelected()) {
			return Gender.MALE;
		}
		else if(femaleRadioButton.isSelected()) {
			return Gender.FEMALE;
		}
		else {
			return null;
		}
	}
	
	public String getPatientWeight() {
		return weightTextField.getText();
	}
	
	public String getPatientHeight() {
		return heightTextField.getText();
	}
	
	public String getPatientSpecificCondition() {
		return specificTextArea.getText();
	}
	
	public void addOkButtonActionListener(ActionListener actionListener) {
		okButton.addActionListener(actionListener);
	}
	
	public void setOkButtonEnabled(boolean enabled) {
		okButton.setEnabled(enabled);
	}
	
	public void addChangedListener(DocumentListener documentListener) {
		nameTextField.getDocument().addDocumentListener(documentListener);
		patientNumberTextField.getDocument().addDocumentListener(documentListener);
		addressTextField.getDocument().addDocumentListener(documentListener);
		ageTextField.getDocument().addDocumentListener(documentListener);
		weightTextField.getDocument().addDocumentListener(documentListener);
		heightTextField.getDocument().addDocumentListener(documentListener);
		specificTextArea.getDocument().addDocumentListener(documentListener);
	}
	
}
