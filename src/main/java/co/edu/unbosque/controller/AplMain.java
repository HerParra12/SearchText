/**
 * The package of the class
 */
package co.edu.unbosque.controller;
/**
 * The necessary imports to work the class
 */
import javax.swing.UIManager;
/**
 * Class that allows executing the program and gives a different visual system look, it calls the controller class
 * 
 * @author Omar Santos, Hernan Alvarado, Kevin Pinzón
 *
 */
public class AplMain {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new Controller();
		} catch (Exception e) {}
	}
	
}
