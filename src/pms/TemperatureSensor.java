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
public class TemperatureSensor extends Senser{
	
	public static final double NORMAL_HIGH_TEMPERATURE = 37.5;
	public static final double NORMAL_LOW_TEMPERATURE = 36.5;
	public static final double DEAD_LOW_TEMPERATURE = 34.0;
	public static final double DEAD_HIGH_TEMPERATURE = 40.0;
	
	private double previousTemperature;
	private Random rand;

	public TemperatureSensor(){
		rand = new Random(System.currentTimeMillis());
		previousTemperature = 37.0;
	}

	public double getTemperature(){
		double curTemp = previousTemperature + (rand.nextInt() % 10)* 0.005;
		if(curTemp < DEAD_LOW_TEMPERATURE) curTemp += 0.10;
		else if(curTemp > DEAD_HIGH_TEMPERATURE) curTemp -= 0.10;
		previousTemperature = curTemp;
		return curTemp;
	}

	public class TemperatureNoSignalException extends NoSignalException{
		public TemperatureNoSignalException(){
			super();
		}

		public TemperatureNoSignalException(String message){
			super(message);
		}
	}
}
