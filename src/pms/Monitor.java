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
	private Alarm alarm;
	private SafeLimit safeLimit;

	private boolean glucoseOutOfLifeLimit;
	private boolean pressureOutOfLifeLimit;
	private boolean temperatureOutOfLifeLimit;
	private boolean rateOutOfLifeLimit;

	/**
	 * create an instance of monitor
	 * 
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
		alarm = new Alarm();
		safeLimit = new SafeLimit();

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
			if (rate > safeLimit.getNormalHighHeartRate()
					|| rate < safeLimit.getNormalLowHeartRate()) {
				rateOutOfLifeLimit = true;
				alarm.ring();
				view.displayInfo("Heart rate is out of safe limit..");
			}
			view.displayHeartRate(rate, rateOutOfLifeLimit);
			vitalSignLogger.addRecord("Heart Rate: " + (int) rate);
		} catch (HeartRateSenserNoSignalException hrsnse) {
			// TODO view.displayHeartRate(0, true);
			alarm.ring();
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
			if (highPressure > safeLimit.getNormalHighPressureUp()
					|| highPressure < safeLimit.getNormalHighPressureDown()
					|| lowPressure > safeLimit.getNormalLowPressureUp()
					|| lowPressure < safeLimit.getNormalLowPressureDown()) {
				pressureOutOfLifeLimit = true;
				alarm.ring();
				view.displayInfo("Blood pressure is out of safe limit.");
			}
			view.displayBloodPressure(highPressure, lowPressure,
					pressureOutOfLifeLimit);
			vitalSignLogger.addRecord("Pressure low: " + (int) lowPressure
					+ "; high: " + (int) highPressure);
		} catch (BloodPressureNoSignalException e) {
			// TODO view.displayBloodPressure(0, 0, true);
			alarm.ring();
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
			if (glucose > safeLimit.getNormalHighBloodGlucoseLevel()
					|| glucose < safeLimit.getNormalLowBloodGlucoseLevel()) {
				glucoseOutOfLifeLimit = true;
				alarm.ring();
				view.displayInfo("Blood glucose level is out of safe limit.");
			}
			view.displayBloodGlucoseLevel(glucose, glucoseOutOfLifeLimit);
			vitalSignLogger.addRecord("Blood Glucose Level: "
					+ String.format("%.1f", glucose));
		} catch (BloodGlucoseLevelNoSignalException e) {
			// TODO view.displayBloodGlucoseLevel(0, true);
			alarm.ring();
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
			if (temp > safeLimit.getNormalHighTemperature()
					|| temp < safeLimit.getNormalLowTemperature()) {
				temperatureOutOfLifeLimit = true;
				alarm.ring();
				view.displayInfo("Body temperature is out of safe limit.");
			}
			view.displayTemperature(temp, temperatureOutOfLifeLimit);
			vitalSignLogger.addRecord("Temperature: "
					+ String.format("%.1f", temp));
		} catch (TemperatureNoSignalException e) {
			// TODO view.displayTemperature(0, true);
			alarm.ring();
		}

		view.repaint();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Patient p = new Patient("Eric", "Utopia", "BK001", 20,
						Gender.MALE, 150.5, 188.0, "--");
				new Monitor(p);
			}
		});
	}
}
