package pms;

import javax.swing.SwingUtilities;

/**
 * Driver for Patient Monitoring System.
 *
 * @author Anthony
 * @version 0.1
 */
public class PMSDriver {
	
	/**
	 * Starts the program
	 * 
	 * @param args parameters ignored
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new LoginController();
			}
		});
	}
}
