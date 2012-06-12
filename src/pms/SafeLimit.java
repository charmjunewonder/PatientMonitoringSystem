/**
 * 
 */
package pms;

/**
 * @author charmjunewonder
 * 
 */
public class SafeLimit {
	public static final double DEFAULT_NORMAL_HIGH_BLOOD_GLUCOSE_LEVEL = 180.0;
	public static final double DEFAULT_NORMAL_LOW_BLOOD_GLUCOSE_LEVEL = 64.8;
	public static final double DEFAULT_NORMAL_HIGH_PRESSURE_UP = 139;
	public static final double DEFAULT_NORMAL_HIGH_PRESSURE_DOWN = 120;
	public static final double DEFAULT_NORMAL_LOW_PRESSURE_UP = 79;
	public static final double DEFAULT_NORMAL_LOW_PRESSURE_DOWN = 60;
	public static final double DEFAULT_NORMAL_HIGH_BEATS = 100;
	public static final double DEFAULT_NORMAL_LOW_BEATS = 60;
	public static final double DEFAULT_NORMAL_HIGH_TEMPERATURE = 37.5;
	public static final double DEFAULT_NORMAL_LOW_TEMPERATURE = 36.5;

	private double normalHighBloodGlucoseLevel;
	private double normalLowBloodGlucoseLevel;
	private double normalHighPressureUp;
	private double normalHighPressureDown;
	private double normalLowPressureUp;
	private double normalLowPressureDown;
	private double normalHighBeats;
	private double normalLowBeats;
	private double normalHighTemperature;
	private double normalLowTemperature;
	
	public SafeLimit(){
		
	}

	/**
	 * @return the normalHighBloodGlucoseLevel
	 */
	public double getNormalHighBloodGlucoseLevel() {
		return normalHighBloodGlucoseLevel;
	}

	/**
	 * @param normalHighBloodGlucoseLevel the normalHighBloodGlucoseLevel to set
	 */
	public void setNormalHighBloodGlucoseLevel(double normalHighBloodGlucoseLevel) {
		this.normalHighBloodGlucoseLevel = normalHighBloodGlucoseLevel;
	}

	/**
	 * @return the normalLowBloodGlucoseLevel
	 */
	public double getNormalLowBloodGlucoseLevel() {
		return normalLowBloodGlucoseLevel;
	}

	/**
	 * @param normalLowBloodGlucoseLevel the normalLowBloodGlucoseLevel to set
	 */
	public void setNormalLowBloodGlucoseLevel(double normalLowBloodGlucoseLevel) {
		this.normalLowBloodGlucoseLevel = normalLowBloodGlucoseLevel;
	}

	/**
	 * @return the normalHighPressureUp
	 */
	public double getNormalHighPressureUp() {
		return normalHighPressureUp;
	}

	/**
	 * @param normalHighPressureUp the normalHighPressureUp to set
	 */
	public void setNormalHighPressureUp(double normalHighPressureUp) {
		this.normalHighPressureUp = normalHighPressureUp;
	}

	/**
	 * @return the normalHighPressureDown
	 */
	public double getNormalHighPressureDown() {
		return normalHighPressureDown;
	}

	/**
	 * @param normalHighPressureDown the normalHighPressureDown to set
	 */
	public void setNormalHighPressureDown(double normalHighPressureDown) {
		this.normalHighPressureDown = normalHighPressureDown;
	}

	/**
	 * @return the normalLowPressureUp
	 */
	public double getNormalLowPressureUp() {
		return normalLowPressureUp;
	}

	/**
	 * @param normalLowPressureUp the normalLowPressureUp to set
	 */
	public void setNormalLowPressureUp(double normalLowPressureUp) {
		this.normalLowPressureUp = normalLowPressureUp;
	}

	/**
	 * @return the normalLowPressureDown
	 */
	public double getNormalLowPressureDown() {
		return normalLowPressureDown;
	}

	/**
	 * @param normalLowPressureDown the normalLowPressureDown to set
	 */
	public void setNormalLowPressureDown(double normalLowPressureDown) {
		this.normalLowPressureDown = normalLowPressureDown;
	}

	/**
	 * @return the normalHighBeats
	 */
	public double getNormalHighBeats() {
		return normalHighBeats;
	}

	/**
	 * @param normalHighBeats the normalHighBeats to set
	 */
	public void setNormalHighBeats(double normalHighBeats) {
		this.normalHighBeats = normalHighBeats;
	}

	/**
	 * @return the normalLowBeats
	 */
	public double getNormalLowBeats() {
		return normalLowBeats;
	}

	/**
	 * @param normalLowBeats the normalLowBeats to set
	 */
	public void setNormalLowBeats(double normalLowBeats) {
		this.normalLowBeats = normalLowBeats;
	}

	/**
	 * @return the normalHighTemperature
	 */
	public double getNormalHighTemperature() {
		return normalHighTemperature;
	}

	/**
	 * @param normalHighTemperature the normalHighTemperature to set
	 */
	public void setNormalHighTemperature(double normalHighTemperature) {
		this.normalHighTemperature = normalHighTemperature;
	}

	/**
	 * @return the normalLowTemperature
	 */
	public double getNormalLowTemperature() {
		return normalLowTemperature;
	}

	/**
	 * @param normalLowTemperature the normalLowTemperature to set
	 */
	public void setNormalLowTemperature(double normalLowTemperature) {
		this.normalLowTemperature = normalLowTemperature;
	}
}
