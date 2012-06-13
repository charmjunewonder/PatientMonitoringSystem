package pms;

/**
 * 
 */

/**
 * This interface is to show the status of the patient.
 * @author charmjunewonder
 * @version 1.0
 */
public interface Display {

	/**
	 * display the current heart rate of the patient
	 * @param hearRete
	 * @param warning
	 */
	public void displayHeartRate(double heartRate, boolean warning);

	/**
	 * display the current temperatur of the patient
	 * @param temperature
	 * @param warning
	 */
	public void displayTemperature(double temperature, boolean warning);

	/**
	 * display the current blood pressure of the patient
	 * @param pressure
	 * @param warning
	 */
	public void displayBloodPressure(double highPressure, double lowPressure,
			boolean warning);

	/**
	 * display the current blood glucose level of the patient
	 * @param bloodGlucoseLevel
	 * @param warning
	 */
	public void displayBloodGlucoseLevel(double bloodGlucoseLevel,
			boolean warning);

	/**
	 * Called when heart rate sensor failed.
	 */
	public void heartRateNoSignal();

	/**
	 * Called when temperature sensor failed.
	 */
	public void temperatureNoSignal();

	/**
	 * Called when blood pressure sensor failed.
	 */
	public void bloodPressureNoSignal();

	/**
	 * Called when blood glucose level sensor failed.
	 */
	public void bloodGlucoseLevelNoSignal();

	/**
	 * Display current state information.
	 * 
	 * @param stateInfo state information
	 */
	public void addInfo(String stateInfo);
}
