package pms;

/**
 * Senser is a interface defines methods needed for a vital sign senser.
 * 
 * @author Anthony
 * @version 0.1
 */
public interface Senser {
	
	/**
	 * Obtains measured value of specified vital sign.
	 * 
	 * @return measured value of one vital sign
	 * @exception NoSignalException when a senser failed.
	 */
	double getValue();
	
	/**
	 * Represents a no signal error when a senser failed.
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
