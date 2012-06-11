package pms;
/**
 * 
 */

/**
 * @author charmjunewonder
 * 
 */
public interface Display {

	/**
	 * @param hearRete
	 * @param warning
	 */
	public void displayHeartRate(double heartRate, boolean warning);

	/**
	 * @param temperature
	 * @param warning
	 */
	public void displayTemperature(double temperature, boolean warning);

	/**
	 * @param pressure
	 * @param warning
	 */
	public void displayBloodPressure(double highPressure, double lowPressure, boolean warning);

	/**
	 * @param bloodGlucoseLevel
	 * @param warning
	 */
	public void displayBloodGlucoseLevel(double bloodGlucoseLevel, boolean warning);

	/**
	 * @param stateInfo
	 */
	public void displayInfo(String stateInfo);
}
