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

	private Random rand;

	public TemperatureSensor(){
		rand = new Random(System.currentTimeMillis());
	}

	public double getTemperature(){
		return TemperatureSensor.NORMAL_HIGH_TEMPERATURE;
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
