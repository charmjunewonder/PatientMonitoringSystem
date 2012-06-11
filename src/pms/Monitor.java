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
					view.displayInfo("The patient is injected.");
				}
			}
		};
		new Timer(100, intravenousInputAction).start();
	}

	public void processHeartRate() {
		try {
			double rate = heartRateSensor.getBeats();
			boolean warning = false;
			if (rate > HeartRateSenser.NORMAL_HIGH_BEATS
					|| rate < HeartRateSenser.NORMAL_LOW_BEATS)
				warning = true;
			view.displayHeartRate(rate, warning);
		} catch (HeartRateSenserNoSignalException hrsnse) {
			view.displayHeartRate(0, true);
		}
		view.repaint();
	}

	public void processBloodPressure() {
		try {
			double highPressure = bloodPressureSensor.getHighPressure();
			double lowPressure = bloodPressureSensor.getLowPressure();
			boolean warning = false;
			if (highPressure > BloodPressureSenser.NORMAL_HIGH_PRESSURE_UP
					|| highPressure < BloodPressureSenser.NORMAL_HIGH_PRESSURE_DOWN
					|| lowPressure > BloodPressureSenser.NORMAL_LOW_PRESSURE_UP
					|| lowPressure < BloodPressureSenser.NORMAL_LOW_PRESSURE_DOWN)
				warning = true;
			view.displayBloodPressure(highPressure, lowPressure, warning);
		} catch (BloodPressureNoSignalException e) {
			//TODO view.displayBloodPressure(0, 0, true);
		}

		view.repaint();
	}

	public void processBloodGlucoseLevel() {
		try {
			double glucose = bloodGlucoseLevelSensor.getGlucoseLevel();
			boolean warning = false;
			if (glucose > BloodGlucoseLevelSensor.NORMAL_HIGH_BLOOD_GLUCOSE_LEVEL
					|| glucose < BloodGlucoseLevelSensor.NORMAL_LOW_BLOOD_GLUCOSE_LEVEL)
				warning = true;
			view.displayBloodGlucoseLevel(glucose, warning);
		} catch (BloodClucoseLevelNoSignalException e) {
			//TODO view.displayBloodGlucoseLevel(0, true);
		}

		view.repaint();
	}

	public void processTemperature() {
		try {
			double temp = temperatureSensor.getTemperature();
			boolean warning = false;
			if (temp > TemperatureSensor.NORMAL_HIGH_TEMPERATURE
					|| temp < TemperatureSensor.NORMAL_LOW_TEMPERATURE)
				warning = true;
			view.displayTemperature(temp, warning);
		} catch (TemperatureNoSignalException e) {
			//view.displayTemperature(0, true);
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
