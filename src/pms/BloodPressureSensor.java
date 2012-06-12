package pms;

import java.util.Random;

import pms.HeartRateSensor.HeartRateSenserNoSignalException;

/**
 * Simulates a sensor measuring blood pressure from one patient.
 * 
 * @author Anthony
 * @version 0.1
 */
public class BloodPressureSensor extends Sensor {
	
	public static final double NORMAL_HIGH_PRESSURE_UP = 139;
	public static final double NORMAL_HIGH_PRESSURE_DOWN = 120;
	public static final double NORMAL_LOW_PRESSURE_UP = 79;
	public static final double NORMAL_LOW_PRESSURE_DOWN = 60;
	
	private Random rand;
	
	/**
	 * Constructs a BloodPressureSensor.
	 */
	public BloodPressureSensor() {
		rand = new Random(System.currentTimeMillis());
	}
	
	/**
	 * Obtains the current high pressure of the patient attached.
	 * 
	 * @return current high pressure of the patient
	 * @exception BloodPressureSenserNoSignalException when the blood pressure senser failed
	 */
	public double getHighPressure() {
		int exceptionRandom = rand.nextInt(10);
		if(exceptionRandom == 0) throw new BloodPressureNoSignalException();
		return rand.nextDouble() * 20 + 110;
	}
	
	/**
	 * Obtains the current low pressure of the patient attached.
	 * 
	 * @return current low pressure of the patient
	 * @exception BloodPressureSenserNoSignalException when the blood pressure senser failed.
	 */
	public double getLowPressure() {
		int exceptionRandom = rand.nextInt(10);
		if(exceptionRandom == 0) throw new BloodPressureNoSignalException();
		return rand.nextDouble() * 20 + 50;
	}
	
	/**
	 * Exception class indicating the failure of BloodPressureSensor.
	 */
	public class BloodPressureNoSignalException extends NoSignalException {
		
		/**
		 * Constructs a BloodPressureNoSignalException.
		 */
		public BloodPressureNoSignalException() {
			super();
		}
		
		/**
		 * Constructs a BloodPressureNoSignalException with given message.
		 * 
		 * @param message error message indicating what happened
		 */
		public BloodPressureNoSignalException(String message) {
			super(message);
		}
	}
}
