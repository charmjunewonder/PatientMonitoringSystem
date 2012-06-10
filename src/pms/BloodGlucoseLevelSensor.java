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
	
	public static final double NORMAL_HIGH_BLOOD_GLUCOSE_LEVEL = 104.4;
	public static final double NORMAL_LOW_BLOOD_GLUCOSE_LEVEL = 64.8;

	private Random rand;

	public BloodGlucoseLevelSensor(){
		rand = new Random(System.currentTimeMillis());
	}

	public double getGlucoseLevel(){
		return BloodGlucoseLevelSensor.NORMAL_HIGH_BLOOD_GLUCOSE_LEVEL;	
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
