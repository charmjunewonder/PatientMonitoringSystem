package pms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import pms.PatientInfo.Gender;

/**
 * Controller for LoginFrame.
 *
 * @author Anthony
 * @version 0.1
 */
public class LoginController {
	
	private LoginFrame loginFrame;

	/**
	 * Constructs a controller for LoginFrame.
	 */
	public LoginController() {
		loginFrame = new LoginFrame();
		
		addListeners();
		loginFrame.setVisible(true);
	}
	
	private void addListeners() {
		loginFrame.addChangedListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				stateChanged();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				stateChanged();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				stateChanged();
			}
			
			private void stateChanged() {
				String name = loginFrame.getPatientName();
				String address = loginFrame.getPatientAddress();
				String patientNumber = loginFrame.getPatientNumber();
				Gender gender = loginFrame.getPatientGender();
				String age = loginFrame.getPatientAge();
				String weight = loginFrame.getPatientWeight();
				String height = loginFrame.getPatientHeight();
				String condition = loginFrame.getPatientSpecificCondition();
				
				if(!name.isEmpty()
					&& !address.isEmpty()
					&& !patientNumber.isEmpty()
					&& gender != null
					&& age.matches("[1-9][0-9]{0,2}")
					&& !condition.isEmpty()) {
					try {
						if(Double.parseDouble(weight) > 0
							&& Double.parseDouble(weight) < 1000
							&& Double.parseDouble(height) > 0
							&& Double.parseDouble(height) < 1000) {
							loginFrame.setOkButtonEnabled(true);
							return;
						}
					}
					catch (NumberFormatException ex) {}
				}
				loginFrame.setOkButtonEnabled(false);
			}
			
		});
		
		loginFrame.addOkButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = loginFrame.getPatientName();
				String address = loginFrame.getPatientAddress();
				String patientNumber = loginFrame.getPatientNumber();
				Gender gender = loginFrame.getPatientGender();
				int age = Integer.parseInt(loginFrame.getPatientAge());
				Double weight = Double.parseDouble(loginFrame.getPatientWeight());
				Double height = Double.parseDouble(loginFrame.getPatientHeight());
				String condition = loginFrame.getPatientSpecificCondition();
				
				loginFrame.dispose();
				
				new Monitor(new PatientInfo(
					name,
					address,
					patientNumber,
					age,
					gender,
					weight,
					height,
					condition
					));
			}
		});
	}
}
