/**
 * The package of the class
 */
package co.edu.unbosque.view;
/**
 * The necessary imports to work the class
 */
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * The class shows the window of the program
 * 
 * @author Kevin Pinzón, Hernan Alvarado, Omar Santos
 *
 */
public class View extends JFrame{
	/**
	 * Variable of the serial version
	 */
	private static final long serialVersionUID = 1084251622417097844L;
	/**
	 * Variable that instance de class PanelPrincipal
	 */
	private MainPanel panelMain = new MainPanel();
	/**
	 * Variable that contains the direction of the file
	 */
	private String ruta;
	
	/**
	 * The constructor of the class, it saves the specifications of the frame
	 */
	public View() {
		setTitle("Search text by an algorithm");
		setSize(850,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panelMain);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * This method allows to search the file, calling another class
	 * @return the file selected
	 */
	public File connectFileChooser() {
		FileChooser tf = new FileChooser();
		File fileChooser = tf.checkFile();
		ruta = fileChooser.getAbsolutePath();
		return fileChooser;
	}
	
	/**
	 * This method shows a validate message
	 * @param message The String message that will be showed
	 */
	public void warningMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * 
	 * @return The main panel
	 */
	public MainPanel getPanelMain() {
		return panelMain;
	}

	/**
	 * 
	 * @param Recieves the main panel
	 */
	public void setPanelMain(MainPanel panelMain) {
		this.panelMain = panelMain;
	}

	/**
	 * 
	 * @return The direction of the file
	 */
	public String getRuta() {
		return ruta;
	}

	/**
	 * 
	 * @param Recieves the direction of the file
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
}