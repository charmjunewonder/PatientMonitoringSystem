package pms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

import pms.BloodGlucoseLevelSensor.BloodClucoseLevelNoSignalException;
import pms.BloodPressureSenser.BloodPressureNoSignalException;
import pms.HeartRateSenser.HeartRateSenserNoSignalException;
import pms.Patient.Gender;
import pms.TemperatureSensor.TemperatureNoSignalException;

/**
 * @author charmjunewonder
 * 
 */
public class Monitor {

	public static final int BLOOD_GLUCOSE_LEVEL_TIME = 100;
	public static final int BLOOD_PRESSURE_TIME = 100;
	public static final int TEMPERATURE_TIME = 100;
	public static final int HEART_RATE_TIME = 100;

	private PMSGUI view;

	private BloodGlucoseLevelSensor bloodGlucoseLevelSensor;
	private BloodPressureSenser bloodPressureSensor;
	private TemperatureSensor temperatureSensor;
	private HeartRateSenser heartRateSensor;
	private IntravenousInputMachine intravenousInputMachine;

	private boolean glucoseOutOfLifeLimit;
	private boolean pressureOutOfLifeLimit;
	private boolean temperatureOutOfLifeLimit;
	private boolean rateOutOfLifeLimit;

	/**
	 * @param patient
	 */
	public Monitor(Patient patient) {
		view = new PMSGUI(patient);
		view.setVisible(true);
		bloodGlucoseLevelSensor = new BloodGlucoseLevelSensor();
		bloodPressureSensor = new BloodPressureSenser();
		temperatureSensor = new TemperatureSensor();
		heartRateSensor = new HeartRateSenser();
		intravenousInputMachine = new IntravenousInputMachine();
		start();
	}

	/**
	 * 
	 */
	public void start() {
		ActionListener temperatureAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processTemperature();
			}
		};
		new Timer(TEMPERATURE_TIME, temperatureAction).start();

		ActionListener pressureAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processBloodPressure();
			}
		};
		new Timer(BLOOD_PRESSURE_TIME, pressureAction).start();

		ActionListener glucoseAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processBloodGlucoseLevel();
			}
		};
		new Timer(BLOOD_GLUCOSE_LEVEL_TIME, glucoseAction).start();

		ActionListener heartAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processHeartRate();
			}
		};
		new Timer(HEART_RATE_TIME, heartAction).start();

		ActionListener intravenousInputAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (glucoseOutOfLifeLimit && pressureOutOfLifeLimit
						&& temperatureOutOfLifeLimit && rateOutOfLifeLimit) {
					intravenousInputMachine.activate();
				}
			}
		};
		new Timer(100, intravenousInputAction).start();
	}

	public void processHeartRate() {
		try {
			int rate = (int) heartRateSensor.getBeats();
			view.displayHeartRate(rate, false);
		} catch (HeartRateSenserNoSignalException hrsnse) {
			view.displayHeartRate(0, true);
		}
		view.repaint();
	}

	public void processBloodPressure() {
		try {
			int highPressure = (int) bloodPressureSensor.getHighPressure();
			int lowPressure = (int) bloodPressureSensor.getLowPressure();
			view.displayBloodPressure(highPressure, lowPressure, false);
		} catch (BloodPressureNoSignalException e) {
			view.displayBloodPressure(0, 0, true);
		}

		view.repaint();
	}

	public void processBloodGlucoseLevel() {
		try {
			int glucose = (int) bloodGlucoseLevelSensor.getGlucoseLevel();
			view.displayBloodGlucoseLevel(glucose, false);
		} catch (BloodClucoseLevelNoSignalException e) {
			view.displayBloodGlucoseLevel(0, true);
		}

		view.repaint();
	}

	public void processTemperature() {
		try {
			int temp = (int) temperatureSensor.getTemperature();
			view.displayTemperature(temp, false);
		} catch (TemperatureNoSignalException e) {
			view.displayTemperature(0, true);
		}

		view.repaint();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Patient p = new Patient("sdf", "sdfsd", "sdfs", 34,
						Gender.MALE, 34.3, 32.3, "sdf");
				new Monitor(p);
			}
		});
	}
}
