package pms;

import java.util.Random;

import pms.TemperatureSensor.TemperatureNoSignalException;

/**
 * Simulates a senser measuring heart rate from one patient.
 * Heart rate is generated randomly.
 *
 * @author Anthony
 * @version 0.1
 */
public class HeartRateSenser extends Senser {
	
	public static final double MAX_HEARTBEATS = 300;
	public static final double MIN_HEARTBEATS = 25;
	public static final double NORMAL_HIGH_BEATS = 100;
	public static final double NORMAL_LOW_BEATS = 60;
	
	private Random rand;
	
	/**
	 * Constructs a HeartRateSenser.
	 */
	public HeartRateSenser() {
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
		return rand.nextDouble() * 80 + MIN_HEARTBEATS;
	}
	
	/**
	 * Exception class indicating the failure of HeartRateSenser.
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
