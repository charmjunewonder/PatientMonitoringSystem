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
	 */
	double getValue();
}
