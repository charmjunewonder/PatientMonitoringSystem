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
	public void displayHeartRate(int hearRete, boolean warning);

	/**
	 * @param temperature
	 * @param warning
	 */
	public void displayTemperature(int temperature, boolean warning);

	/**
	 * @param pressure
	 * @param warning
	 */
	public void displayBloodPressure(int pressure, boolean warning);

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
