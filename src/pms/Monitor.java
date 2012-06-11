package pms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

import pms.BloodGlucoseLevelSensor.BloodGlucoseLevelNoSignalException;
import pms.BloodPressureSenser.BloodPressureNoSignalException;
import pms.HeartRateSenser.HeartRateSenserNoSignalException;
import pms.Patient.Gender;
import pms.TemperatureSensor.TemperatureNoSignalException;

/**
 * @author Eric
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
	private VitalSignLogger vitalSignLogger;

	private boolean glucoseOutOfLifeLimit;
	private boolean pressureOutOfLifeLimit;
	private boolean temperatureOutOfLifeLimit;
	private boolean rateOutOfLifeLimit;

	/**
	 * create an instance of monitor
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
		vitalSignLogger = new VitalSignLogger(patient);
		
		start();
	}

	/**
	 * let the monitor start to work
	 */
	public void start() {
		
		// get temperature value from the sensor and display them
		ActionListener temperatureAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processTemperature();
			}
		};
		new Timer(TEMPERATURE_TIME, temperatureAction).start();

		// get blood pressure value from the sensor and display them
		ActionListener pressureAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processBloodPressure();
			}
		};
		new Timer(BLOOD_PRESSURE_TIME, pressureAction).start();

		// get blood glucose level value from the sensor and display them
		ActionListener glucoseAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processBloodGlucoseLevel();
			}
		};
		new Timer(BLOOD_GLUCOSE_LEVEL_TIME, glucoseAction).start();

		// get heart rate value from the sensor and display them
		ActionListener heartAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processHeartRate();
			}
		};
		new Timer(HEART_RATE_TIME, heartAction).start();

		// check if four value is out of life limit or not.
		ActionListener intravenousInputAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.displayInfo("");
				if (glucoseOutOfLifeLimit && pressureOutOfLifeLimit
						&& temperatureOutOfLifeLimit && rateOutOfLifeLimit) {
					intravenousInputMachine.activate();
					view.displayInfo("The patient is injected.");
				}
			}
		};
		new Timer(100, intravenousInputAction).start();
	}

	/**
	 * process the heart rate and display it.
	 */
	public void processHeartRate() {
		try {
			double rate = heartRateSensor.getBeats();
			rateOutOfLifeLimit = false;
			if (rate > HeartRateSenser.NORMAL_HIGH_BEATS
					|| rate < HeartRateSenser.NORMAL_LOW_BEATS)
				rateOutOfLifeLimit = true;
			view.displayHeartRate(rate, rateOutOfLifeLimit);
			vitalSignLogger.addRecord("Heart Rate: " + (int)rate);
		} catch (HeartRateSenserNoSignalException hrsnse) {
			//TODO view.displayHeartRate(0, true);
		}
		view.repaint();
	}

	/**
	 * process the blood pressure and display it.
	 */
	public void processBloodPressure() {
		try {
			double highPressure = bloodPressureSensor.getHighPressure();
			double lowPressure = bloodPressureSensor.getLowPressure();
			pressureOutOfLifeLimit = false;
			if (highPressure > BloodPressureSenser.NORMAL_HIGH_PRESSURE_UP
					|| highPressure < BloodPressureSenser.NORMAL_HIGH_PRESSURE_DOWN
					|| lowPressure > BloodPressureSenser.NORMAL_LOW_PRESSURE_UP
					|| lowPressure < BloodPressureSenser.NORMAL_LOW_PRESSURE_DOWN)
				pressureOutOfLifeLimit = true;
			view.displayBloodPressure(highPressure, lowPressure, pressureOutOfLifeLimit);
			vitalSignLogger.addRecord("Pressure low: " + (int)lowPressure + "; high: " + (int)highPressure);
		} catch (BloodPressureNoSignalException e) {
			//TODO view.displayBloodPressure(0, 0, true);
		}

		view.repaint();
	}

	/**
	 * process the blood glucose level and display it.
	 */
	public void processBloodGlucoseLevel() {
		try {
			double glucose = bloodGlucoseLevelSensor.getGlucoseLevel();
			glucoseOutOfLifeLimit = false;
			if (glucose > BloodGlucoseLevelSensor.NORMAL_HIGH_BLOOD_GLUCOSE_LEVEL
					|| glucose < BloodGlucoseLevelSensor.NORMAL_LOW_BLOOD_GLUCOSE_LEVEL)
				glucoseOutOfLifeLimit = true;
			view.displayBloodGlucoseLevel(glucose, glucoseOutOfLifeLimit);
			vitalSignLogger.addRecord("Blood Glucose Level: " + (int)glucose);
		} catch (BloodGlucoseLevelNoSignalException e) {
			//TODO view.displayBloodGlucoseLevel(0, true);
		}

		view.repaint();
	}

	/**
	 * process the temperature and display it.
	 */
	public void processTemperature() {
		try {
			double temp = temperatureSensor.getTemperature();
			temperatureOutOfLifeLimit = false;
			if (temp > TemperatureSensor.NORMAL_HIGH_TEMPERATURE
					|| temp < TemperatureSensor.NORMAL_LOW_TEMPERATURE)
				temperatureOutOfLifeLimit = true;
			view.displayTemperature(temp, temperatureOutOfLifeLimit);
			vitalSignLogger.addRecord("Temperature: " + String.format("%.1f", temp));
		} catch (TemperatureNoSignalException e) {
			//TODO view.displayTemperature(0, true);
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
