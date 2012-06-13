package pms;

/**
 * Class for safe limits.
 * 
 * @author charmjunewonder
 * @version 1.0
 */
public class SafeLimit {
	public static final double DEFAULT_NORMAL_HIGH_BLOOD_GLUCOSE_LEVEL = 180.0;
	public static final double DEFAULT_NORMAL_LOW_BLOOD_GLUCOSE_LEVEL = 64.8;
	public static final double DEFAULT_NORMAL_HIGH_PRESSURE_UP = 139;
	public static final double DEFAULT_NORMAL_HIGH_PRESSURE_DOWN = 120;
	public static final double DEFAULT_NORMAL_LOW_PRESSURE_UP = 79;
	public static final double DEFAULT_NORMAL_LOW_PRESSURE_DOWN = 60;
	public static final double DEFAULT_NORMAL_HIGH_HEART_RATE = 100;
	public static final double DEFAULT_NORMAL_LOW_HEART_RATE = 60;
	public static final double DEFAULT_NORMAL_HIGH_TEMPERATURE = 37.5;
	public static final double DEFAULT_NORMAL_LOW_TEMPERATURE = 36.5;

	private double normalHighBloodGlucoseLevel;
	private double normalLowBloodGlucoseLevel;
	private double normalHighPressureUp;
	private double normalHighPressureDown;
	private double normalLowPressureUp;
	private double normalLowPressureDown;
	private double normalHighHeartRate;
	private double normalLowHeartRate;
	private double normalHighTemperature;
	private double normalLowTemperature;

	public SafeLimit() {
		normalHighBloodGlucoseLevel = DEFAULT_NORMAL_HIGH_BLOOD_GLUCOSE_LEVEL;
		normalLowBloodGlucoseLevel = DEFAULT_NORMAL_LOW_BLOOD_GLUCOSE_LEVEL;
		normalHighPressureUp = DEFAULT_NORMAL_HIGH_PRESSURE_UP;
		normalHighPressureDown = DEFAULT_NORMAL_HIGH_PRESSURE_DOWN;
		normalLowPressureUp = DEFAULT_NORMAL_LOW_PRESSURE_UP;
		normalLowPressureDown = DEFAULT_NORMAL_LOW_PRESSURE_DOWN;
		normalHighHeartRate = DEFAULT_NORMAL_HIGH_HEART_RATE;
		normalLowHeartRate = DEFAULT_NORMAL_LOW_HEART_RATE;
		normalHighTemperature = DEFAULT_NORMAL_HIGH_TEMPERATURE;
		normalLowTemperature = DEFAULT_NORMAL_LOW_TEMPERATURE;
	}

	public SafeLimit(double normalHighBloodGlucoseLevel,
			double normalLowBloodGlucoseLevel, double normalHighPressureUp,
			double normalHighPressureDown, double normalLowPressureUp,
			double normalLowPressureDown, double normalHighHeartRate,
			double normalLowHeartRate, double normalHighTemperature,
			double normalLowTemperature) {
		this.normalHighBloodGlucoseLevel = normalHighBloodGlucoseLevel;
		this.normalLowBloodGlucoseLevel = normalLowBloodGlucoseLevel;
		this.normalHighPressureUp = normalHighPressureUp;
		this.normalHighPressureDown = normalHighPressureDown;
		this.normalLowPressureUp = normalLowPressureUp;
		this.normalLowPressureDown = normalLowPressureDown;
		this.normalHighHeartRate = normalHighHeartRate;
		this.normalLowHeartRate = normalLowHeartRate;
		this.normalHighTemperature = normalHighTemperature;
		this.normalLowTemperature = normalLowTemperature;

	}

	/**
	 * return the normalHighBloodGlucoseLevel
	 */
	public double getNormalHighBloodGlucoseLevel() {
		return normalHighBloodGlucoseLevel;
	}

	/**
	 * @param normalHighBloodGlucoseLevel the normalHighBloodGlucoseLevel to set
	 */
	public void setNormalHighBloodGlucoseLevel(
			double normalHighBloodGlucoseLevel) {
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
	public double getNormalHighHeartRate() {
		return normalHighHeartRate;
	}

	/**
	 * @param normalHighHeartRate the normalHighBeats to set
	 */
	public void setNormalHighHeartRate(double normalHighHeartRate) {
		this.normalHighHeartRate = normalHighHeartRate;
	}

	/**
	 * @return the normalLowBeats
	 */
	public double getNormalLowHeartRate() {
		return normalLowHeartRate;
	}

	/**
	 * @param normalLowHeartRate the normalLowBeats to set
	 */
	public void setNormalLowHeartRate(double normalLowHeartRate) {
		this.normalLowHeartRate = normalLowHeartRate;
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
