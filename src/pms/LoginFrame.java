package pms;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.event.DocumentListener;
import pms.PatientInfo.Gender;

/**
 * LoginFrame of PatientInfo Monitoring System.
 *
 * @author Anthony
 * @version 1.0
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
	private JButton safeLimitsButton;
	private JLabel specificLabel;
	private JTextArea specificTextArea;
	private JLabel titleLabel;
	private JLabel weightLabel;
	private JTextField weightTextField;
	private SafeLimitDialog safeLimitsDialog;
	
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
		
        genderButtonGroup = new javax.swing.ButtonGroup();
        loginPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        patientNumberLabel = new javax.swing.JLabel();
        ageHintLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        weightLabel = new javax.swing.JLabel();
        heightLabel = new javax.swing.JLabel();
        specificLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        patientNumberTextField = new javax.swing.JTextField();
        ageTextField = new javax.swing.JTextField();
        weightTextField = new javax.swing.JTextField();
        heightTextField = new javax.swing.JTextField();
        conditionScrollPane = new javax.swing.JScrollPane();
        specificTextArea = new javax.swing.JTextArea();
        maleRadioButton = new javax.swing.JRadioButton();
        femaleRadioButton = new javax.swing.JRadioButton();
        okButton = new javax.swing.JButton();
        ageLabel = new javax.swing.JLabel();
        safeLimitsButton = new javax.swing.JButton();
	safeLimitsDialog = new SafeLimitDialog(this, true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        nameLabel.setText("Name: ");
        nameLabel.setPreferredSize(new java.awt.Dimension(60, 22));
        loginPanel.add(nameLabel);
        nameLabel.setBounds(10, 50, 170, 20);

        addressLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        addressLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        addressLabel.setText("Address: ");
        loginPanel.add(addressLabel);
        addressLabel.setBounds(10, 80, 170, 20);

        patientNumberLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        patientNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        patientNumberLabel.setText("PatientNumber: ");
        loginPanel.add(patientNumberLabel);
        patientNumberLabel.setBounds(10, 110, 170, 20);

        ageHintLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ageHintLabel.setText("[1~999]");
        ageHintLabel.setPreferredSize(new java.awt.Dimension(150, 20));
        loginPanel.add(ageHintLabel);
        ageHintLabel.setBounds(470, 140, 150, 20);

        genderLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        genderLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        genderLabel.setText("Gender: ");
        loginPanel.add(genderLabel);
        genderLabel.setBounds(10, 170, 170, 20);

        weightLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        weightLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        weightLabel.setText("Weight: ");
        loginPanel.add(weightLabel);
        weightLabel.setBounds(10, 200, 170, 20);

        heightLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        heightLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        heightLabel.setText("Height: ");
        loginPanel.add(heightLabel);
        heightLabel.setBounds(10, 230, 170, 20);

        specificLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        specificLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
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
        conditionScrollPane.setBounds(190, 260, 271, 170);

        genderButtonGroup.add(maleRadioButton);
        maleRadioButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        maleRadioButton.setSelected(true);
        maleRadioButton.setText("Male");
        loginPanel.add(maleRadioButton);
        maleRadioButton.setBounds(240, 170, 60, 25);

        genderButtonGroup.add(femaleRadioButton);
        femaleRadioButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        femaleRadioButton.setText("Female");
        loginPanel.add(femaleRadioButton);
        femaleRadioButton.setBounds(350, 170, 80, 25);

        okButton.setFont(okButton.getFont().deriveFont(okButton.getFont().getSize()+2f));
        okButton.setText("OK");
        okButton.setEnabled(false);
        loginPanel.add(okButton);
        okButton.setBounds(550, 440, 70, 25);

        ageLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ageLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        ageLabel.setText("Age: ");
        ageLabel.setPreferredSize(new java.awt.Dimension(150, 20));
        loginPanel.add(ageLabel);
        ageLabel.setBounds(10, 140, 170, 20);

        safeLimitsButton.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        safeLimitsButton.setText("Safe Limits");
        loginPanel.add(safeLimitsButton);
        safeLimitsButton.setBounds(20, 440, 110, 27);

        getContentPane().add(loginPanel, java.awt.BorderLayout.PAGE_START);

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
	
	public void addSafeLimitsButtonListener(ActionListener actionListener) {
		safeLimitsButton.addActionListener(actionListener);
	}
	
	public void addSafeLimitsOkButtonListener(ActionListener actionListener) {
		safeLimitsDialog.okButton.addActionListener(actionListener);
	}
	
	public void addOkButtonActionListener(ActionListener actionListener) {
		okButton.addActionListener(actionListener);
	}
	
	public void setOkButtonEnabled(boolean enabled) {
		okButton.setEnabled(enabled);
	}
	
	public void setSafeLimitsOkButtonEnabled(boolean enabled) {
		safeLimitsDialog.okButton.setEnabled(enabled);
	}
	
	public void setSafeLimitsDialogVisiable(boolean isVisiable) {
		safeLimitsDialog.setVisible(isVisiable);
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
	
	public void addSafeLimitsChangedListener(DocumentListener docuementListener) {
		safeLimitsDialog.lowHeartRateTextField.getDocument().addDocumentListener(docuementListener);
		safeLimitsDialog.highHeartRateTextField.getDocument().addDocumentListener(docuementListener);
		safeLimitsDialog.lowBodyTemperatureTextField.getDocument().addDocumentListener(docuementListener);
		safeLimitsDialog.highBodyTemperatureTextField.getDocument().addDocumentListener(docuementListener);
		safeLimitsDialog.lowLowBloodPressureTextField.getDocument().addDocumentListener(docuementListener);
		safeLimitsDialog.lowHighBloodPressureTextField.getDocument().addDocumentListener(docuementListener);
		safeLimitsDialog.highLowBloodPressureTextField.getDocument().addDocumentListener(docuementListener);
		safeLimitsDialog.highHighBloodPressureTextField.getDocument().addDocumentListener(docuementListener);
		safeLimitsDialog.lowBloodGlucoseTextField.getDocument().addDocumentListener(docuementListener);
		safeLimitsDialog.highBloodGlucoseTextField.getDocument().addDocumentListener(docuementListener);
	}
	
	public String getLowHeartRate() {
		return safeLimitsDialog.lowHeartRateTextField.getText();
	}
	
	public String getHighHeartRate() {
		return safeLimitsDialog.highHeartRateTextField.getText();
	}
	
	public String getLowBodyTemperature() {
		return safeLimitsDialog.lowBodyTemperatureTextField.getText();
	}
	
	public String getHighBodyTemperature() {
		return safeLimitsDialog.highBodyTemperatureTextField.getText();
	}
	
	public String getLowLowBloodPressure() {
		return safeLimitsDialog.lowLowBloodPressureTextField.getText();
	}
	
	public String getLowHighBloodPressure() {
		return safeLimitsDialog.lowHighBloodPressureTextField.getText();
	}
	
	public String getHighLowBloodPressure() {
		return safeLimitsDialog.highLowBloodPressureTextField.getText();
	}
	
	public String getHighHighBloodPressure() {
		return safeLimitsDialog.highHighBloodPressureTextField.getText();
	}
	
	public String getLowBloodGlucose() {
		return safeLimitsDialog.lowBloodGlucoseTextField.getText();
	}
	
	public String getHighBloodGlucose() {
		return safeLimitsDialog.highBloodGlucoseTextField.getText();
	}
	
	@Override
	public void dispose() {
		safeLimitsDialog.dispose();
		super.dispose();
	}
	
	
	private class SafeLimitDialog extends JDialog {
		
		private JLabel BodyTemperatureLabel;
		private JPanel SafeLimitPanel;
		private JLabel bglUnitLabel;
		private JLabel bgwlLabel;
		private JLabel bloodGlucoseLabel;
		private JLabel btUnitLabel;
		private JLabel btwlLabel;
		private JLabel hbpUnitLabel;
		private JLabel hbpwlLabel;
		private JLabel heartRateLabel;
		private JFormattedTextField highBloodGlucoseTextField;
		private JLabel highBloodPressureLabel;
		private JFormattedTextField highBodyTemperatureTextField;
		private JFormattedTextField highHeartRateTextField;
		private JFormattedTextField highHighBloodPressureTextField;
		private JFormattedTextField highLowBloodPressureTextField;
		private JLabel hrUnitLabel;
		private JLabel hrwlLabel;
		private JLabel lbpUnitLabel;
		private JLabel lbpwlLabel;
		private JFormattedTextField lowBloodGlucoseTextField;
		private JLabel lowBloodPressureLabel;
		private JFormattedTextField lowBodyTemperatureTextField;
		private JFormattedTextField lowHeartRateTextField;
		private JFormattedTextField lowHighBloodPressureTextField;
		private JFormattedTextField lowLowBloodPressureTextField;
		private JButton okButton;
		private JLabel rangLabel;
		private JLabel titleLabel;
		private JLabel vitalSignsLabel;
		
		/**
		 * Creates new form SafeLimitDialog
		 */
		public SafeLimitDialog(Frame parent, boolean modal) {
			super(parent, modal);
			initComponents();
			initValues();
			setLocationRelativeTo(parent);
			
			WindowListener listener = new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent w) {
					SafeLimitDialog.this.setVisible(false);
				}
			};
			addWindowListener(listener);
		}
		
		/**
		 * Set default values to text fields.
		 */
		private void initValues() {
			lowHeartRateTextField.setText(Double.toString(SafeLimit.DEFAULT_NORMAL_LOW_HEART_RATE));
			highHeartRateTextField.setText(Double.toString(SafeLimit.DEFAULT_NORMAL_HIGH_HEART_RATE));
			lowBodyTemperatureTextField.setText(Double.toString(SafeLimit.DEFAULT_NORMAL_LOW_TEMPERATURE));
			highBodyTemperatureTextField.setText(Double.toString(SafeLimit.DEFAULT_NORMAL_HIGH_TEMPERATURE));
			lowHighBloodPressureTextField.setText(Double.toString(SafeLimit.DEFAULT_NORMAL_HIGH_PRESSURE_DOWN));
			highHighBloodPressureTextField.setText(Double.toString(SafeLimit.DEFAULT_NORMAL_HIGH_PRESSURE_UP));
			lowLowBloodPressureTextField.setText(Double.toString(SafeLimit.DEFAULT_NORMAL_LOW_PRESSURE_DOWN));
			highLowBloodPressureTextField.setText(Double.toString(SafeLimit.DEFAULT_NORMAL_LOW_PRESSURE_UP));
			lowBloodGlucoseTextField.setText(Double.toString(SafeLimit.DEFAULT_NORMAL_LOW_BLOOD_GLUCOSE_LEVEL));
			highBloodGlucoseTextField.setText(Double.toString(SafeLimit.DEFAULT_NORMAL_HIGH_BLOOD_GLUCOSE_LEVEL));
		}
		
		/**
		 * This method is called from within the constructor to
		 * initialize the form.
		 */
		@SuppressWarnings("unchecked")
		private void initComponents() {

			SafeLimitPanel = new JPanel();
			heartRateLabel = new JLabel();
			BodyTemperatureLabel = new JLabel();
			highBloodPressureLabel = new JLabel();
			lowBloodPressureLabel = new JLabel();
			bloodGlucoseLabel = new JLabel();
			vitalSignsLabel = new JLabel();
			rangLabel = new JLabel();
			lowHeartRateTextField = new JFormattedTextField(NumberFormat.getInstance());
			highHeartRateTextField = new JFormattedTextField(NumberFormat.getInstance());
			lowBodyTemperatureTextField = new JFormattedTextField(NumberFormat.getInstance());
			highBodyTemperatureTextField = new JFormattedTextField(NumberFormat.getInstance());
			lowHighBloodPressureTextField = new JFormattedTextField(NumberFormat.getInstance());
			highHighBloodPressureTextField = new JFormattedTextField(NumberFormat.getInstance());
			lowLowBloodPressureTextField = new JFormattedTextField(NumberFormat.getInstance());
			highLowBloodPressureTextField = new JFormattedTextField(NumberFormat.getInstance());
			lowBloodGlucoseTextField = new JFormattedTextField(NumberFormat.getInstance());
			highBloodGlucoseTextField = new JFormattedTextField(NumberFormat.getInstance());
			titleLabel = new JLabel();
			hrwlLabel = new JLabel();
			btwlLabel = new JLabel();
			hbpwlLabel = new JLabel();
			lbpwlLabel = new JLabel();
			bgwlLabel = new JLabel();
			okButton = new JButton();
			hrUnitLabel = new JLabel();
			btUnitLabel = new JLabel();
			hbpUnitLabel = new JLabel();
			lbpUnitLabel = new JLabel();
			bglUnitLabel = new JLabel();

			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setModal(true);
			setName("SafeLimitDialog");
			setResizable(false);

			SafeLimitPanel.setPreferredSize(new java.awt.Dimension(400, 300));

			heartRateLabel.setText("Heart Rate:");

			BodyTemperatureLabel.setText("Body Temperature:");

			highBloodPressureLabel.setText("High Blood Pressure:");

			lowBloodPressureLabel.setText("Low Blood Pressure:");

			bloodGlucoseLabel.setText("Blood Glucose:");

			vitalSignsLabel.setText("Vital Signs");

			rangLabel.setText("Range");

			lowHeartRateTextField.setHorizontalAlignment(JTextField.CENTER);

			highHeartRateTextField.setHorizontalAlignment(JTextField.CENTER);

			lowBodyTemperatureTextField.setHorizontalAlignment(JTextField.CENTER);

			highBodyTemperatureTextField.setHorizontalAlignment(JTextField.CENTER);

			lowHighBloodPressureTextField.setHorizontalAlignment(JTextField.CENTER);

			highHighBloodPressureTextField.setHorizontalAlignment(JTextField.CENTER);

			lowLowBloodPressureTextField.setHorizontalAlignment(JTextField.CENTER);

			highLowBloodPressureTextField.setHorizontalAlignment(JTextField.CENTER);

			lowBloodGlucoseTextField.setHorizontalAlignment(JTextField.CENTER);

			highBloodGlucoseTextField.setHorizontalAlignment(JTextField.CENTER);

			titleLabel.setFont(titleLabel.getFont().deriveFont(titleLabel.getFont().getStyle() | java.awt.Font.BOLD, titleLabel.getFont().getSize() + 8));
			titleLabel.setText("Safe Limits");

			hrwlLabel.setText("~");

			btwlLabel.setText("~");

			hbpwlLabel.setText("~");

			lbpwlLabel.setText("~");

			bgwlLabel.setText("~");

			okButton.setText("OK");

			hrUnitLabel.setText("beats/min");

			btUnitLabel.setText("℃");

			hbpUnitLabel.setText("mmhg");

			lbpUnitLabel.setText("mmhg");

			bglUnitLabel.setText("mg/dL");

        GroupLayout SafeLimitPanelLayout = new GroupLayout(SafeLimitPanel);
        SafeLimitPanel.setLayout(SafeLimitPanelLayout);
        SafeLimitPanelLayout.setHorizontalGroup(
            SafeLimitPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(SafeLimitPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SafeLimitPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(SafeLimitPanelLayout.createSequentialGroup()
                        .addGroup(SafeLimitPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(bloodGlucoseLabel)
                            .addComponent(vitalSignsLabel)
                            .addComponent(heartRateLabel)
                            .addComponent(BodyTemperatureLabel)
                            .addComponent(highBloodPressureLabel)
                            .addComponent(lowBloodPressureLabel))
                        .addGroup(SafeLimitPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(SafeLimitPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(SafeLimitPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lowHeartRateTextField, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                    .addComponent(lowBodyTemperatureTextField)
                                    .addComponent(lowHighBloodPressureTextField)
                                    .addComponent(lowLowBloodPressureTextField)
                                    .addComponent(lowBloodGlucoseTextField))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SafeLimitPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(SafeLimitPanelLayout.createSequentialGroup()
                                        .addComponent(bgwlLabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(highBloodGlucoseTextField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(bglUnitLabel))
                                    .addGroup(SafeLimitPanelLayout.createSequentialGroup()
                                        .addComponent(hrwlLabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(highHeartRateTextField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(hrUnitLabel))
                                    .addGroup(SafeLimitPanelLayout.createSequentialGroup()
                                        .addComponent(btwlLabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(highBodyTemperatureTextField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btUnitLabel))
                                    .addGroup(SafeLimitPanelLayout.createSequentialGroup()
                                        .addComponent(hbpwlLabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(highHighBloodPressureTextField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(hbpUnitLabel))
                                    .addGroup(SafeLimitPanelLayout.createSequentialGroup()
                                        .addComponent(lbpwlLabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(highLowBloodPressureTextField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbpUnitLabel))))
                            .addGroup(SafeLimitPanelLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(rangLabel)))
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, SafeLimitPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(SafeLimitPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, SafeLimitPanelLayout.createSequentialGroup()
                                .addComponent(titleLabel)
                                .addGap(137, 137, 137))
                            .addGroup(GroupLayout.Alignment.TRAILING, SafeLimitPanelLayout.createSequentialGroup()
                                .addComponent(okButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        SafeLimitPanelLayout.setVerticalGroup(
            SafeLimitPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(SafeLimitPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addGroup(SafeLimitPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(vitalSignsLabel)
                    .addComponent(rangLabel))
                .addGap(18, 18, 18)
                .addGroup(SafeLimitPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(heartRateLabel)
                    .addComponent(lowHeartRateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(hrwlLabel)
                    .addComponent(highHeartRateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(hrUnitLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SafeLimitPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(BodyTemperatureLabel)
                    .addComponent(lowBodyTemperatureTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btwlLabel)
                    .addComponent(highBodyTemperatureTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btUnitLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SafeLimitPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(highBloodPressureLabel)
                    .addComponent(lowHighBloodPressureTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(hbpwlLabel)
                    .addComponent(highHighBloodPressureTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(hbpUnitLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SafeLimitPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lowBloodPressureLabel)
                    .addComponent(lowLowBloodPressureTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbpwlLabel)
                    .addComponent(highLowBloodPressureTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbpUnitLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SafeLimitPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(bloodGlucoseLabel)
                    .addGroup(SafeLimitPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lowBloodGlucoseTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bgwlLabel)
                        .addComponent(highBloodGlucoseTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bglUnitLabel)))
                .addGap(15, 15, 15)
                .addComponent(okButton)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(SafeLimitPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(SafeLimitPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        pack();
		}
	}
}
