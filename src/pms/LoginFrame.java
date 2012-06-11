package pms;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentListener;
import pms.Patient.Gender;

/**
 * LoginFrame of Patient Monitoring System.
 *
 * @author charmjunewonder
 * @version 0.1
 */
public class LoginFrame extends JFrame{
	private JLabel addressLabel;
	private JTextField addressTextField;
	private JLabel ageLabel;
	private JTextField ageTextField;
	private ButtonGroup genderButtonGroup;
	private JRadioButton femaleRadioButton;
	private JLabel genderLabel;
	private JLabel heightLabel;
	private JTextField heightTextField;
	private JButton okButton;
	private JLabel jLabel1;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JRadioButton maleRadioButton;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JTextField patientNumberTextField;
	private JLabel patientNumerLabel;
	private JLabel specificLabel;
	private JTextArea specificTextArea;
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
		
		genderButtonGroup = new ButtonGroup();
		jPanel1 = new JPanel();
		jLabel1 = new JLabel();
		nameLabel = new JLabel();
		addressLabel = new JLabel();
		patientNumerLabel = new JLabel();
		ageLabel = new JLabel();
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
		jScrollPane1 = new JScrollPane();
		specificTextArea = new JTextArea();
		maleRadioButton = new JRadioButton();
		femaleRadioButton = new JRadioButton();
		okButton = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new java.awt.Dimension(640, 480));
		setPreferredSize(new java.awt.Dimension(640, 480));
		setResizable(false);

		jPanel1.setMinimumSize(new java.awt.Dimension(640, 480));
		jPanel1.setPreferredSize(new java.awt.Dimension(640, 480));
		jPanel1.setRequestFocusEnabled(false);
		jPanel1.setLayout(null);

		jLabel1.setText("Patient Monitoring System");
		jPanel1.add(jLabel1);
		jLabel1.setBounds(180, 10, 184, 17);

		nameLabel.setText("Name: ");
		jPanel1.add(nameLabel);
		nameLabel.setBounds(70, 50, 40, 15);

		addressLabel.setText("Address: ");
		jPanel1.add(addressLabel);
		addressLabel.setBounds(70, 80, 54, 15);

		patientNumerLabel.setText("PatientNumber: ");
		jPanel1.add(patientNumerLabel);
		patientNumerLabel.setBounds(70, 110, 100, 15);

		ageLabel.setText("Age: ");
		jPanel1.add(ageLabel);
		ageLabel.setBounds(70, 140, 30, 15);

		genderLabel.setText("Gender: ");
		jPanel1.add(genderLabel);
		genderLabel.setBounds(70, 170, 48, 15);

		weightLabel.setText("Weight: ");
		jPanel1.add(weightLabel);
		weightLabel.setBounds(70, 200, 48, 15);

		heightLabel.setText("Height: ");
		jPanel1.add(heightLabel);
		heightLabel.setBounds(70, 230, 48, 15);

		specificLabel.setText("Specific Medical Condition: ");
		jPanel1.add(specificLabel);
		specificLabel.setBounds(10, 265, 168, 20);

		jPanel1.add(nameTextField);
		nameTextField.setBounds(190, 50, 270, 21);

		jPanel1.add(addressTextField);
		addressTextField.setBounds(190, 80, 270, 21);
		jPanel1.add(patientNumberTextField);
		patientNumberTextField.setBounds(190, 110, 270, 21);
		jPanel1.add(ageTextField);
		ageTextField.setBounds(190, 140, 271, 21);
		jPanel1.add(weightTextField);
		weightTextField.setBounds(190, 200, 271, 21);
		jPanel1.add(heightTextField);
		heightTextField.setBounds(190, 230, 271, 21);

		specificTextArea.setColumns(20);
		specificTextArea.setRows(5);
		jScrollPane1.setViewportView(specificTextArea);

		jPanel1.add(jScrollPane1);
		jScrollPane1.setBounds(190, 260, 271, 106);

		genderButtonGroup.add(maleRadioButton);
		maleRadioButton.setText("Male");

		jPanel1.add(maleRadioButton);
		maleRadioButton.setBounds(240, 170, 60, 23);

		genderButtonGroup.add(femaleRadioButton);
		femaleRadioButton.setText("Female");

		jPanel1.add(femaleRadioButton);
		femaleRadioButton.setBounds(350, 170, 70, 23);

		okButton.setText("OK");
		okButton.setEnabled(false);

		jPanel1.add(okButton);
		okButton.setBounds(550, 420, 70, 23);

		getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
		
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
