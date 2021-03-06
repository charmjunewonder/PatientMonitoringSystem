package pms;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Information logger for PMS. Records patient's basic information and vital signs.
 * 
 * @author Anthony
 * @version 1.0
 */
public class VitalSignLogger {
	
	public static final String LOGFOLDER = "logfiles/";
	public static final String EXTENSION = "patientinfo";
	
	private PrintWriter out;
	
	/**
	 * Constructs a vital sign logger for a patient.
	 * 
	 * @param patient target patient to record
	 */
	public VitalSignLogger(String patientName, String initialInfo) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Calendar cal = Calendar.getInstance();
		String fileName = LOGFOLDER
			+ patientName + "_"
			+ dateFormat.format(cal.getTime()).toString()
			+ "." + EXTENSION;
		try {
			File logFolder = new File(LOGFOLDER);
			if(!logFolder.exists()) {
				logFolder.mkdir();
			}
			out = new PrintWriter(fileName);
		}
		catch(IOException ex) {
			throw new RuntimeException(ex);
		}
		out.println(initialInfo);
		out.println("********************");
		out.flush();
	}
	
	/**
	 * Add a line of record to patient's log file.
	 * 
	 * @param data record of patient's information.
	 */
	public void addRecord(String data) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		out.println(dateFormat.format(cal.getTime()).toString() + " " + data);
		out.flush();
	}
	
	/**
	 * Destructs this object.
	 */
	@Override
	public void finalize() throws Throwable {
		out.close();
		super.finalize();
	}
}
