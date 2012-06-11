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
	public void displayHeartRate(int heartRate, boolean warning);

	/**
	 * @param temperature
	 * @param warning
	 */
	public void displayTemperature(int temperature, boolean warning);

	/**
	 * @param pressure
	 * @param warning
	 */
	public void displayBloodPressure(int highPressure, int lowPressure, boolean warning);

	/**
	 * @param bloodGlucoseLevel
	 * @param warning
	 */
	public void displayBloodGlucoseLevel(int bloodGlucoseLevel, boolean warning);

	/**
	 * @param stateInfo
	 */
	public void displayInfo(String stateInfo);
}
