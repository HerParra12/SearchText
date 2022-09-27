/**
 * The package of the class
 */
package co.edu.unbosque.model.persistence;
/**
 * The necessary imports to work the class
 */
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * Class that recieves the information of the file
 * 
 * @author Hernan Alvarado, Kevin Pinzon, Omar Castellanos
 *
 */
public class Persistencia {
	/**
	 * Empty constructor of the class
	 */
	public Persistencia() {}
	/**
	 * Method that recieves the file and shows it in a String type
	 * @param file The file that the user selected
	 * @return String information extracted of the file
	 */
	public String contentText(String file) {
		try {
			return Files.readString(Paths.get(file), Charset.defaultCharset());
		}catch(Exception error) {}
		return null;
	}	
}
