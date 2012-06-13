package pms;

import java.util.Random;

/**
 * Class BloodGlucoseLevelSensor is to measure the blood glucose level of the
 * patient
 * 
 * @author charmjunewonder
 * @version 1.0
 */
public class BloodGlucoseLevelSensor extends Sensor {

	public static final double NORMAL_HIGH_BLOOD_GLUCOSE_LEVEL = 180.0;
	public static final double NORMAL_LOW_BLOOD_GLUCOSE_LEVEL = 64.8;
	public static final double DEAD_LOW_BLOOD_GLUCOSE_LEVEL = 15.0;
	public static final double DEAD_HIGH_BLOOD_GLUCOSE_LEVEL = 200.0;

	private Random rand;

	// private double previousBloodGlucoseLevel;

	/**
	 * create an instance of BloodGlucoseLevelSensor
	 */
	public BloodGlucoseLevelSensor() {
		rand = new Random(System.currentTimeMillis());
		// previousBloodGlucoseLevel = 100.0;
	}

	/**
	 * get the current blood glucose level of the patient.
	 * 
	 * @return current blood glucose level of the patient
	 * @throws BloodGlucoseLevelNoSignalException when the blood glucose level
	 *             sensor failed
	 */
	public double getGlucoseLevel() throws BloodGlucoseLevelNoSignalException {
		int exceptionRandom = rand.nextInt(10);
		if (exceptionRandom == 0)
			throw new BloodGlucoseLevelNoSignalException();
		// double curGlucose = previousBloodGlucoseLevel + (rand.nextInt() %
		// 10);
		// double curGlucose = rand.nextDouble() * 200 +
		// DEAD_LOW_BLOOD_GLUCOSE_LEVEL;
		// if (curGlucose < DEAD_LOW_BLOOD_GLUCOSE_LEVEL) curGlucose += 5;
		// else if (curGlucose > DEAD_HIGH_BLOOD_GLUCOSE_LEVEL) curGlucose -= 5;
		// previousBloodGlucoseLevel = curGlucose;
		return rand.nextDouble() * 200 + DEAD_LOW_BLOOD_GLUCOSE_LEVEL;
	}

	/**
	 * Exception class indicating the failure of BloodGlucoseLevelSensor.
	 * 
	 * @author Eric
	 */
	public class BloodGlucoseLevelNoSignalException extends NoSignalException {
		/**
		 * create an instance of BloodGlucoseLevelNoSignalException
		 */
		public BloodGlucoseLevelNoSignalException() {
			super();
		}

		/**
		 * create an instance of BloodGlucoseLevelNoSignalException
		 * 
		 * @param message error message
		 */
		public BloodGlucoseLevelNoSignalException(String message) {
			super(message);
		}
	}
}
