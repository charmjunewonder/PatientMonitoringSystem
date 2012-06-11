/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pms;

import java.util.Random;

/**
 *
 * @author charmjunewonder
 */
public class BloodGlucoseLevelSensor  extends Senser{
	
	public static final double NORMAL_HIGH_BLOOD_GLUCOSE_LEVEL = 180.0;
	public static final double NORMAL_LOW_BLOOD_GLUCOSE_LEVEL = 64.8;
	public static final double DEAD_LOW_BLOOD_GLUCOSE_LEVEL = 15.0;
	public static final double DEAD_HIGH_BLOOD_GLUCOSE_LEVEL = 200.0;
	
	private Random rand;
	private double previousBloodGlucoseLevel;

	public BloodGlucoseLevelSensor(){
		rand = new Random(System.currentTimeMillis());
		previousBloodGlucoseLevel = 100.0;
	}

	public double getGlucoseLevel(){
		double curGlucose = previousBloodGlucoseLevel + (rand.nextInt() % 10);
		if(curGlucose < DEAD_LOW_BLOOD_GLUCOSE_LEVEL) curGlucose += 5;
		else if(curGlucose > DEAD_HIGH_BLOOD_GLUCOSE_LEVEL) curGlucose -= 5;
		previousBloodGlucoseLevel = curGlucose;
		return curGlucose;
	}

	public class BloodClucoseLevelNoSignalException extends NoSignalException{
		public BloodClucoseLevelNoSignalException(){
			super();
		}

		public BloodClucoseLevelNoSignalException(String message){
			super(message);
		}
	}
}
