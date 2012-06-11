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

	/**
	 * create an instance of TemperatureSensor
	 */
	public TemperatureSensor(){
		rand = new Random(System.currentTimeMillis());
		previousTemperature = 37.0;
	}

	/**
	 * get the current temperature of the patient
	 * 
	 * @return current temperature of the patient.
	 * @throws TemperatureNoSignalException when the temperature sensor is failed
	 */
	public double getTemperature() throws TemperatureNoSignalException{
		int exceptionRandom = rand.nextInt(10);
		if(exceptionRandom == 0) throw new TemperatureNoSignalException();
		double curTemp = previousTemperature + (rand.nextInt() % 10)* 0.005;
		if(curTemp < DEAD_LOW_TEMPERATURE) curTemp += 0.10;
		else if(curTemp > DEAD_HIGH_TEMPERATURE) curTemp -= 0.10;
		previousTemperature = curTemp;
		return curTemp;
	}

	/**
	 * Exception class indicating the temperature sensor is failed
	 * @author Eric
	 */
	public class TemperatureNoSignalException extends NoSignalException{
		/**
		 * create an instance of TemperatureNoSignalException
		 */
		public TemperatureNoSignalException(){
			super();
		}

		/**
		 * create an instance of TemperatureNoSignalException
		 * @param message error message
		 */
		public TemperatureNoSignalException(String message){
			super(message);
		}
	}
}
