/**
 * The package of the class
 */
package co.edu.unbosque.view;
/**
 * The necessary imports to work the class
 */
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * The class that shows the window to select the file that will be showed
 * 
 * @author Kevin Pinzón, Hernan Alvarado, Omar Santos
 *
 */
public class FileChooser extends JPanel{
	
	/**
	 * Variable of the version that the serial has
	 */
	private static final long serialVersionUID = 7533942115625784030L;
	/**
	 * Variable that will be used to open the window FileChooser
	 */
	private JFileChooser jf;
	/**
	 * Variable to select an specific type of file, searching by the extension
	 */
	private FileNameExtensionFilter filter;
	
	/**
	 * Constructor of the class, here it contains the different configurations to open the window to select the file and the specification that the file must has
	 */
	public FileChooser() {
		jf = new JFileChooser();
		jf.showOpenDialog(FileChooser.this);
		filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		jf.setFileFilter(filter);
	}
	
	/**
	 * Method that validates the file selected has an extension .txt
	 * @return The file once it knows is a .txt file
	 */
	public File checkFile() {
		File f = jf.getSelectedFile();
		while (f == null) {
			JOptionPane.showMessageDialog(null, "You must select a .txt", "Warning message", JOptionPane.WARNING_MESSAGE);
			jf.showOpenDialog(FileChooser.this);
			jf.setFileFilter(filter);
			f = jf.getSelectedFile();
		}
		return f;
	}
	
}
