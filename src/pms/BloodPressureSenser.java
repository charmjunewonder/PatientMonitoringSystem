package pms;

import java.util.Random;

/**
 * Simulates a senser measuring blood pressure from one patient.
 * 
 * @author Anthony
 * @version 0.1
 */
public class BloodPressureSenser extends Senser {
	
	private double NORMALHIGHPRESSUREUP = 139;
	private double NORMALHIGHPRESSUREDOWN = 120;
	private double NORMALLOWPRESSUREUP = 79;
	private double NORMALLOWPRESSUREDOWN = 60;
	
	private Random rand;
	
	/**
	 * Constructs a BloodPressureSenser.
	 */
	public BloodPressureSenser() {
		rand = new Random(System.currentTimeMillis());
	}
	
	/**
	 * Obtains the current high pressure of the patient attached.
	 * 
	 * @return current high pressure of the patient
	 * @exception BloodPressureSenserNoSignalException when the blood pressure senser failed
	 */
	public double getHighPressure() {
		return rand.nextDouble()
			* (NORMALHIGHPRESSUREUP - NORMALHIGHPRESSUREDOWN)
			+ NORMALHIGHPRESSUREDOWN;
	}
	
	/**
	 * Obtains the current low pressure of the patient attached.
	 * 
	 * @return current low pressure of the patient
	 * @exception BloodPressureSenserNoSignalException when the blood pressure senser failed.
	 */
	public double getLowPressure() {
		return rand.nextDouble()
			* (NORMALLOWPRESSUREUP - NORMALLOWPRESSUREDOWN)
			+ NORMALLOWPRESSUREDOWN;
	}
	
	/**
	 * Exception class indicating the failure of BloodPressureSenser.
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
