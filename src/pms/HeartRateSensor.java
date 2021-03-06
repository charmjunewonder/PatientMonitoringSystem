package pms;

import java.util.Random;


/**
 * Simulates a sensor measuring heart rate from one patient.
 * Heart rate is generated randomly.
 *
 * @author Anthony
 * @version 1.0
 */
public class HeartRateSensor extends Sensor {
	
	private Random rand;
	
	/**
	 * Constructs a HeartRateSensor.
	 */
	public HeartRateSensor() {
		rand = new Random(System.currentTimeMillis());
	}
	
	/**
	 * Get the current heart rate of the patient attached.
	 * 
	 * @return the heart rate of the patient
	 * @exception HeartRateSenserNoSignalException when this heart rate senser failed.
	 */
	public double getBeats() throws HeartRateSenserNoSignalException{
		int exceptionRandom = rand.nextInt(10);
		if(exceptionRandom == 0) throw new HeartRateSenserNoSignalException();
		return rand.nextDouble() * 80 + 25;
	}
	
	/**
	 * Exception class indicating the failure of HeartRateSensor.
	 */
	public class HeartRateSenserNoSignalException extends NoSignalException {
		
		/**
		 * Constructs a HeartRateSenserNoSignalException.
		 */
		public HeartRateSenserNoSignalException() {
			super();
		}
		
		/**
		 * Constructs a HeartRateSenserNoSignalException with given message.
		 * 
		 * @param message error message indicating what happened
		 */
		public HeartRateSenserNoSignalException(String message) {
			super(message);
		}
	}
}
