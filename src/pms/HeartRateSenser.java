package pms;

import java.util.Random;

/**
 * Simulate a senser measuring heart rate from one patient.
 * Heart rate is generated randomly.
 *
 * @author Anthony
 * @version 0.1
 */
public class HeartRateSenser implements Senser {
	
	private double MAXHEARTBEATS = 300;
	private double MINHEARTBEATS = 25;
	private double NORMALHIGHHEARTBEATS = 100;
	private double NORMALLOWHEARTBEATS = 60;
	
	private Random rand;
	
	/**
	 * Constructs a HeartRateSenser.
	 */
	public void HeartRateSenser() {
		rand = new Random(System.currentTimeMillis());
	}
	
	/**
	 * Get the current heart rate of patient attached.
	 * 
	 * @return the heart rate of the patient
	 * @exception HeartRateSenserNoSignalException when this heart rate senser failed.
	 */
	@Override
	public double getValue() {
		return rand.nextDouble()
			* (NORMALHIGHHEARTBEATS - NORMALLOWHEARTBEATS)
			+ NORMALLOWHEARTBEATS;
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
