package pms;

/**
 * Sensor is a interface defines methods needed for a vital sign sensor.
 * 
 * @author Anthony
 * @version 1.0
 */
public abstract class Sensor {
	
	
	/**
	 * Represents a no signal error when a sensor failed.
	 */
	public class NoSignalException extends RuntimeException {

		/**
		 * Constructs a NoSignalException.
		 */
		public NoSignalException() {
			super();
		}

		/**
		 * Constructs a NoSignalException with given message.
		 *
		 * @param message error message indicating what happened
		 */
		public NoSignalException(String message) {
			super(message);
		}
	}
}
