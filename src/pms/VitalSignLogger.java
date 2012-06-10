package pms;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Information logger for PMS. Records patient's basic information and vital signs.
 * 
 * @author Anthony
 * @version 0.1
 */
public class VitalSignLogger {
	
	private PrintWriter out;
	
	/**
	 * Constructs a vital sign logger for a patient.
	 * 
	 * @param patient target patient to record
	 */
	public VitalSignLogger(Patient patient) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cal = Calendar.getInstance();
		String fileName = patient.getName()
			+ dateFormat.format(cal.getTime()).toString();
		try {
			out = new PrintWriter(fileName);
		}
		catch(IOException ex) {
			throw new RuntimeException(ex);
		}
		out.println(patient);
		out.println("********************");
	}
	
	/**
	 * Add a line of record to patient's log file.
	 * 
	 * @param data record of patient's information.
	 */
	public void addRecord(String data) {
		out.println(data);
	}
}
