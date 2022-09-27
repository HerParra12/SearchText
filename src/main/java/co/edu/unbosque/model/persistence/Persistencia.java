package co.edu.unbosque.model.persistence;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Persistencia {

	public Persistencia() {}
	
	public String contentText(String file) {
		try {
			return Files.readString(Paths.get(file), Charset.defaultCharset());
		}catch(Exception error) {}
		return null;
	}	
}
